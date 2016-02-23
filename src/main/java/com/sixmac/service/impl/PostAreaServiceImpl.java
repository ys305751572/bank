package com.sixmac.service.impl;

import com.sixmac.core.Constant;
import com.sixmac.dao.PostAreaDao;
import com.sixmac.entity.PostArea;
import com.sixmac.service.PostAreaService;
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
public class PostAreaServiceImpl implements PostAreaService {

    @Autowired
    private PostAreaDao postAreaDao;


    @Override
    public List<PostArea> findAll() {
        return postAreaDao.findAll();
    }

    @Override
    public Page<PostArea> find(int pageNum, int pageSize) {

        return postAreaDao.findAll(new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "id"));

    }

    @Override
    public Page<PostArea> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public PostArea getById(int id) {
        return postAreaDao.findOne(id);
    }

    @Override
    @Transactional
    public PostArea deleteById(int id) {
        PostArea postArea = getById(id);
        postAreaDao.delete(postArea);
        return postArea;
    }

    @Override
    @Transactional
    public PostArea create(PostArea postArea) {
        postArea.setCreateDate(new Date());
        postAreaDao.save(postArea);
        return postArea;
    }

    @Override
    @Transactional
    public PostArea update(PostArea postArea) {
        PostArea origPostArea = getById(postArea.getId());
        ClassUtil.copyProperties(origPostArea, postArea);
        origPostArea.setUpdateDate(new Date());
        return postAreaDao.save(origPostArea);
    }

    @Override
    @Transactional
    public void deleteAll(int[] ids) {
        for (int id : ids) {
            deleteById(id);
        }
    }

}