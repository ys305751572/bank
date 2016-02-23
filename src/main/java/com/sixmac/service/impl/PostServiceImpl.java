package com.sixmac.service.impl;

import com.sixmac.core.Constant;
import com.sixmac.dao.PostDao;
import com.sixmac.entity.Image;
import com.sixmac.entity.Post;
import com.sixmac.entity.PostImages;
import com.sixmac.service.PostImagesService;
import com.sixmac.service.PostService;
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
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private PostImagesService postImagesService;

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public Page<Post> find(int pageNum, int pageSize) {
        return postDao.findAll(new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "sort"));
    }

    @Override
    public Page<Post> findByAdd(int pageNum, int pageSize) {
        return postDao.find(new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "sort"));
    }

    @Override
    public Page<Post> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public Post getById(int id) {
        return postDao.findOne(id);
    }

    @Override
    @Transactional
    public Post deleteById(int id) {
        Post post = getById(id);
        postImagesService.deleteByPostId(id);
        postDao.delete(post);
        return post;
    }

    @Override
    @Transactional
    public Post create(Post post) {
        post.setSort(0);
        post.setSalesCount(0L);
        post.setCollectCount(0L);
        post.setIsAdded(false);
        post.setCreateDate(new Date());
        postDao.save(post);
        return post;
    }

    @Override
    @Transactional
    public Post update(Post post) {
        Post origPost = getById(post.getId());
        ClassUtil.copyProperties(origPost, post);
        return postDao.save(origPost);
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
    public Post create(Post post, String imageIds) {
        if (StringUtils.isNotBlank(imageIds)) {
            String[] ids = imageIds.split(",");
            for (String id : ids) {
                Image image = new Image();
                Integer imageId = Integer.valueOf(id);
                image.setId(imageId);
                PostImages postImages = new PostImages();
                postImages.setImage(image);
                postImages.setPost(post);
                postImagesService.create(postImages);
            }
        }
        return create(post);
    }


    @Override
    @Transactional
    public Post update(Post post, String imageIds) {
        //productImagesService.deleteByProductId(product.getId());
        if (StringUtils.isNotBlank(imageIds)) {
            String[] ids = imageIds.split(",");
            for (String id : ids) {
                Image image = new Image();
                Integer imageId = Integer.valueOf(id);
                image.setId(imageId);
                PostImages postImages = new PostImages();
                postImages.setImage(image);
                postImages.setPost(post);
                postImagesService.create(postImages);
            }
        }
        return update(post);
    }

    @Override
    public Page<Post> find(int pageNum, int pageSize, String type,final Integer postTypeId,final Integer postAreaId,final String postPrice) {

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

        Page<Post> page = postDao.findAll(new Specification<Post>() {
            @Override
            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                Predicate result = null;
                {
                    Predicate predicate = cb.equal(root.get("isAdded").as(Boolean.class), true);
                    predicateList.add(predicate);
                }

                if (postTypeId != null && postTypeId > 0) {
                    Predicate predicate = cb.equal(root.get("postType").get("id").as(Integer.class), postTypeId);
                    predicateList.add(predicate);
                }
                if (postAreaId != null && postAreaId > 0) {
                    Predicate predicate = cb.equal(root.get("postArea").get("id").as(Integer.class), postAreaId);
                    predicateList.add(predicate);
                }
                if (StringUtils.isNotBlank(postPrice) && !postPrice.equals("-1")) {
                    String[] postPrices = postPrice.split(",");
                    Predicate predicate = cb.gt(root.get("price").as(Double.class), Integer.parseInt(postPrices[0]));
                    predicateList.add(predicate);
                    if (postPrices.length == 2) {
                        Predicate predicate1 = cb.lt(root.get("price").as(Double.class), Integer.parseInt(postPrices[1]));
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
    public Page<Post> find(int pageNum, int pageSize,final String postCode,final Integer postTypeId,final Integer postAreaId) {
        Page<Post> page = postDao.findAll(new Specification<Post>() {
            @Override
            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                Predicate result = null;

                if (StringUtils.isNotBlank(postCode)) {
                    Predicate predicate = cb.equal(root.get("code").as(String.class), postCode);
                    predicateList.add(predicate);
                }
                if (postTypeId != null && postTypeId > 0) {
                    Predicate predicate = cb.equal(root.get("postType").get("id").as(Integer.class), postTypeId);
                    predicateList.add(predicate);
                }
                if (postAreaId != null && postAreaId > 0) {
                    Predicate predicate = cb.equal(root.get("postArea").get("id").as(Integer.class), postAreaId);
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
        Post post = getById(id);
        if (post.getIsAdded()) {
            post.setIsAdded(false);
        } else {
            post.setUpdateDate(new Date());
            post.setIsAdded(true);
        }

        postDao.save(post);
    }


}