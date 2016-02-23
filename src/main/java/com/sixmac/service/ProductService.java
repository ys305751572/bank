package com.sixmac.service;


import com.sixmac.entity.Product;
import com.sixmac.service.common.ICommonService;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by wangbin on 2015/8/17.
 */
public interface ProductService extends ICommonService<Product> {

    public void settingAdded(int id);

    public Product create(Product product, String imageIds);

    public Product update(Product product, String imageIds);

    public Page<Product> find(int pageNum, int pageSize, String type, Integer productTypeId, Integer productAreaId, String productPrice);

    public Page<Product> find(int pageNum, int pageSize, String productCode, Integer productTypeId, Integer productAreaId);

    public Page<Product> findByAdd(int pageNum, int pageSize);

    public List<Product> productList();
}
