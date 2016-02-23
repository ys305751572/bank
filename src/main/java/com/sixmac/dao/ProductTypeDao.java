package com.sixmac.dao;

import  com.sixmac.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangbin on 2015/8/20.
 */
public interface ProductTypeDao  extends JpaRepository<ProductType, Integer> {
}
