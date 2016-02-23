package com.sixmac.service.impl;

import com.sixmac.core.Constant;
import com.sixmac.dao.ProductDao;
import com.sixmac.entity.Image;
import com.sixmac.entity.Product;
import com.sixmac.entity.ProductImages;
import com.sixmac.service.ProductImagesService;
import com.sixmac.service.ProductService;
import com.sixmac.utils.ClassUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangbin on 2015/8/17.
 */
@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductImagesService productImagesService;

    @Override
    public List<Product> findAll() { return productDao.findAll();}

    @Override
    public Page<Product> find(int pageNum, int pageSize) {
        return productDao.findAll(new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "sort"));
    }

    @Override
    public Page<Product> findByAdd(int pageNum, int pageSize) {
        return productDao.find(new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "sort"));
    }

    @Override
    public List<Product> productList() {
        return null;
    }


    @Override
    public Page<Product> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public Product getById(int id) {
        return productDao.findOne(id);
    }

    @Override
    @Transactional
    public Product deleteById(int id) {
        Product product = getById(id);
        productImagesService.deleteByProductId(id);
        productDao.delete(product);
        return product;
    }

    @Override
    @Transactional
    public Product create(Product product) {
        product.setSort(0);
        product.setSalesCount(0L);
        product.setCollectCount(0L);
        product.setIsAdded(false);
        product.setCreateDate(new Date());
        productDao.save(product);
        return product;
    }

    @Override
    @Transactional
    public Product update(Product product) {
        Product origProduct = getById(product.getId());
        ClassUtil.copyProperties(origProduct, product);
        return productDao.save(origProduct);
    }

    @Override
    @Transactional
    public void deleteAll(int[] ids) {
        for (int id : ids) {
            deleteById(id);
        }
    }

    @Override
    @Transactional
    public Product create(Product product, String imageIds) {
        if (StringUtils.isNotBlank(imageIds)) {
            String[] ids = imageIds.split(",");
            for (String id : ids) {
                Image image = new Image();
                Integer imageId = Integer.valueOf(id);
                image.setId(imageId);
                ProductImages productImages = new ProductImages();
                productImages.setImage(image);
                productImages.setProduct(product);
                productImagesService.create(productImages);
            }
        }
        return create(product);
    }


    @Override
    @Transactional
    public Product update(Product product, String imageIds) {
        //productImagesService.deleteByProductId(product.getId());
        if (StringUtils.isNotBlank(imageIds)) {
            String[] ids = imageIds.split(",");
            for (String id : ids) {
                Image image = new Image();
                Integer imageId = Integer.valueOf(id);
                image.setId(imageId);
                ProductImages productImages = new ProductImages();
                productImages.setImage(image);
                productImages.setProduct(product);
                productImagesService.create(productImages);
            }
        }
        return update(product);
    }

    @Override
    public Page<Product> find(int pageNum, int pageSize, String type,final Integer productTypeId,final Integer productAreaId,final String productPrice) {

        Sort.Direction direction = Sort.Direction.DESC;
        if (StringUtils.isBlank(type)) {
            type = "salesCount";
        }

        if ("price".equals(type)) {
            direction = Sort.Direction.ASC;
        }

        if ("sx".equals(type)) {
            type = "salesCount";
        }

        Page<Product> page = productDao.findAll(new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                Predicate result = null;
                {
                    Predicate predicate = cb.equal(root.get("isAdded").as(Boolean.class), true);
                    predicateList.add(predicate);
                }

                if (productTypeId != null && productTypeId > 0) {
                    Predicate predicate = cb.equal(root.get("productType").get("id").as(Integer.class), productTypeId);
                    predicateList.add(predicate);
                }
                if (productAreaId != null && productAreaId > 0) {
                    Predicate predicate = cb.equal(root.get("productArea").get("id").as(Integer.class), productAreaId);
                    predicateList.add(predicate);
                }
                if (StringUtils.isNotBlank(productPrice) && !productPrice.equals("-1")) {
                    String[] productPrices = productPrice.split(",");
                    Predicate predicate = cb.gt(root.get("price").as(Double.class), Integer.parseInt(productPrices[0]));
                    predicateList.add(predicate);
                    if (productPrices.length == 2) {
                        Predicate predicate1 = cb.lt(root.get("price").as(Double.class), Integer.parseInt(productPrices[1]));
                        predicateList.add(predicate1);
                    }
                }

                if (predicateList.size() > 0) {
                    result = cb.and(predicateList.toArray(new Predicate[]{}));
                }
                if (result != null) {
                    query.where(result);
                }

                return query.getRestriction();
            }

        }, new PageRequest(pageNum - 1, pageSize, direction, type));

        return page;
    }

    @Override
    public Page<Product> find(int pageNum, int pageSize,final String productCode,final Integer productTypeId,final Integer productAreaId) {
        Page<Product> page = productDao.findAll(new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                Predicate result = null;

                if (StringUtils.isNotBlank(productCode)) {
                    Predicate predicate = cb.equal(root.get("code").as(String.class), productCode);
                    predicateList.add(predicate);
                }
                if (productTypeId != null && productTypeId > 0) {
                    Predicate predicate = cb.equal(root.get("productType").get("id").as(Integer.class), productTypeId);
                    predicateList.add(predicate);
                }
                if (productAreaId != null && productAreaId > 0) {
                    Predicate predicate = cb.equal(root.get("productArea").get("id").as(Integer.class), productAreaId);
                    predicateList.add(predicate);
                }

                if (predicateList.size() > 0) {
                    result = cb.and(predicateList.toArray(new Predicate[]{}));
                }
                if (result != null) {
                    query.where(result);
                }

                return query.getRestriction();
            }

        }, new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "id"));

        return page;
    }


    @Override
    @Transactional
    public void settingAdded(int id) {
        Product product = getById(id);
        if (product.getIsAdded()) {
            product.setIsAdded(false);
        } else {
            product.setUpdateDate(new Date());
            product.setIsAdded(true);
        }

        productDao.save(product);
    }


}