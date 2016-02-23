package com.sixmac.service.impl;

import com.sixmac.core.Constant;
import com.sixmac.dao.PostImagesDao;
import com.sixmac.entity.Image;
import com.sixmac.entity.PostImages;
import com.sixmac.service.ImageService;
import com.sixmac.service.PostImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangbin on 2015/4/16.
 */
@Service
@Transactional(readOnly = true)
public class PostImagesServiceImpl implements PostImagesService {

    @Autowired
    private PostImagesDao postImagesDao;
    @Autowired
    private ImageService imageService;


    @Override
    public List<PostImages> findAll() {
        return postImagesDao.findAll();
    }

    @Override
    public Page<PostImages> find(int pageNum, int pageSize) {

        return postImagesDao.findAll(new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "id"));

    }

    @Override
    public Page<PostImages> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public PostImages getById(int id) {
        return postImagesDao.findOne(id);
    }

    @Override
    @Transactional
    public PostImages deleteById(int id) {
        PostImages postImages = getById(id);
        postImagesDao.delete(postImages);
        return postImages;
    }

    @Override
    @Transactional
    public PostImages create(PostImages postImages) {
        postImagesDao.save(postImages);
        return postImages;
    }

    @Override
    @Transactional
    public PostImages update(PostImages postImages) {
        return postImagesDao.save(postImages);
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
    public void deleteByPostId(Integer postId) {
        postImagesDao.deleteByPostId(postId);
    }

    @Override
    @Transactional
    public void delete(Integer postId,Integer imageId) {
        imageService.deleteById(imageId);
        postImagesDao.delete(postId,imageId);
    }

    @Override
    public List<Image> findImageListByPost(Integer postId) {
        return postImagesDao.findImagesByPost(postId);
    }



}