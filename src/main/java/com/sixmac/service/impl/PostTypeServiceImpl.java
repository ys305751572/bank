package com.sixmac.service.impl;


import com.sixmac.core.Constant;
import com.sixmac.dao.PostTypeDao;
import com.sixmac.entity.PostType;
import com.sixmac.service.PostTypeService;
import com.sixmac.utils.ClassUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wangbin on 2015/8/20.
 */
@Service
@Transactional(readOnly = true)
public class PostTypeServiceImpl implements PostTypeService {

    @Autowired
    private PostTypeDao postTypeDao;


    @Override
    public List<PostType> findAll() {
        return postTypeDao.findAll();
    }

    @Override
    public Page<PostType> find(int pageNum, int pageSize) {
        return postTypeDao.findAll(new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "id"));
    }

    @Override
    public Page<PostType> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public PostType getById(int id) {
        return postTypeDao.findOne(id);
    }

    @Override
    @Transactional
    public PostType deleteById(int id) {
        PostType postType = getById(id);
        postTypeDao.delete(postType);
        return postType;
    }

    @Override
    @Transactional
    public PostType create(PostType postType) {
        postType.setCreateDate(new Date());
        postTypeDao.save(postType);
        return postType;
    }

    @Override
    @Transactional
    public PostType update(PostType postType) {
        PostType origProjectType = getById(postType.getId());
        ClassUtil.copyProperties(origProjectType, postType);
        origProjectType.setUpdateDate(new Date());
        return postTypeDao.save(origProjectType);
    }

    @Override
    @Transactional
    public void deleteAll(int[] ids) {
        for (int id : ids) {
            deleteById(id);
        }
    }

}