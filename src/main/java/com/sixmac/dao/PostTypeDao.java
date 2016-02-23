package com.sixmac.dao;


import com.sixmac.entity.PostType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2016/1/28.
 */
public interface PostTypeDao  extends JpaRepository<PostType, Integer> {


}
