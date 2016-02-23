package com.sixmac.dao;

import  com.sixmac.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by wangbin on 2015/8/17.
 */
public interface ProductDao extends JpaRepository<Product, Integer>,JpaSpecificationExecutor<Product> {

    @Query("select a from Product a where a.isAdded = true ")
    public Page<Product> find(Pageable pageable);
}
