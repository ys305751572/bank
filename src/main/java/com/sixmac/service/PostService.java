package com.sixmac.service;


import com.sixmac.entity.Post;
import com.sixmac.service.common.ICommonService;
import org.springframework.data.domain.Page;

/**
 * Created by wangbin on 2015/8/17.
 */
public interface PostService extends ICommonService<Post> {

    public void settingAdded(int id);

    public Post create(Post post, String imageIds);

    public Post update(Post post, String imageIds);

    public Page<Post> find(int pageNum, int pageSize, String type, Integer postTypeId, Integer postAreaId, String postPrice);

    public Page<Post> find(int pageNum, int pageSize, String postCode, Integer postTypeId, Integer postAreaId);

    public Page<Post> findByAdd(int pageNum, int pageSize);
}
