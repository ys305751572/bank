package com.sixmac.service;

import com.sixmac.entity.Image;
import com.sixmac.entity.PostImages;
import com.sixmac.service.common.ICommonService;

import java.util.List;

/**
 * Created by wangbin on 2015/4/16.
 */
public interface PostImagesService extends ICommonService<PostImages> {


    public void deleteByPostId(Integer postId);

    public void delete(Integer postId, Integer imageId);


    public List<Image> findImageListByPost(Integer postId);
}
