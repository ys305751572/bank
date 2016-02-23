package com.sixmac.dao;

import  com.sixmac.entity.Image;
import  com.sixmac.entity.PostImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wangbin on 2015/4/16.
 */
public interface PostImagesDao extends JpaRepository<PostImages, Integer> {

    @Modifying
    @Query("delete from PostImages a where a.post.id =?1")
    public void deleteByPostId(Integer postId);

    @Modifying
    @Query("delete from PostImages a where a.post.id =?1 and a.image.id=?2")
    public void delete(Integer postId, Integer imageId);

    @Query("select a.image from PostImages a where a.post.id =?1")
    public List<Image> findImagesByPost(Integer postId);



}
