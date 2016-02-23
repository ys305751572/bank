package com.sixmac.dao;

import  com.sixmac.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by wangbin on 2015/8/17.
 */
public interface PostDao extends JpaRepository<Post, Integer>,JpaSpecificationExecutor<Post> {

    @Query("select a from Post a where a.isAdded = true ")
    public Page<Post> find(Pageable pageable);
}
