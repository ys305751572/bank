package com.sixmac.controller;

import com.sixmac.common.exception.GeneralExceptionHandler;
import com.sixmac.common.DataTableFactory;
import com.sixmac.controller.common.CommonController;
import com.sixmac.core.Configue;
import com.sixmac.core.bean.Result;
import com.sixmac.entity.Image;
import com.sixmac.entity.Post;
import com.sixmac.entity.PostArea;
import com.sixmac.entity.PostType;
import com.sixmac.service.PostAreaService;
import com.sixmac.service.PostImagesService;
import com.sixmac.service.PostService;
import com.sixmac.service.PostTypeService;
import com.sixmac.utils.JsonUtil;
import com.sixmac.utils.WebUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangbin on 2015/8/17.
 */
@RequestMapping(value = "admin/post")
@Controller
public class PostController extends CommonController {


    @Autowired
    private PostService postService;
    @Autowired
    private PostImagesService postImagesService;
    @Autowired
    private PostAreaService postAreaService;
    @Autowired
    private PostTypeService postTypeService;

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request,
                        HttpServletResponse response,
                        ModelMap model) {

        return "文章列表";
    }


    @RequestMapping(value = "/list")
    public void list(HttpServletRequest request,
                     HttpServletResponse response,
                     Integer draw,
                     Integer start,
                     Integer length,
                     String postCode,
                     Integer typeId,
                     Integer areaId,
                     ModelMap model) {
        try {
            int pageNum = getPageNum(start, length);
            Page<Post> page = postService.find(pageNum, length,postCode,typeId,areaId);
            Map<String, Object> result = DataTableFactory.fitting(draw, page);
            WebUtil.print(response, result);
        } catch (Exception e) {
            GeneralExceptionHandler.log(e);
            WebUtil.print(response, emptyData);
        }
    }

    @RequestMapping(value = "/save")
    public void save(HttpServletRequest request,
                     HttpServletResponse response,
                     String imageIds,
                     Integer imageId,
                     Post post) {

        try {
            if (imageId != null) {
                Image image = new Image();
                image.setId(imageId);
                post.setImage(image);
            } else {
                WebUtil.print(response, new Result(false).msg("缩略图不能为空!"));
                return;
            }

            if (post.getId() == null) {
                if (StringUtils.isBlank(imageIds)) {
                    WebUtil.print(response, new Result(false).msg("至少需要上传一张商品图!"));
                    return;
                }
                postService.create(post, imageIds);
            } else {
                List<Image> images = postImagesService.findImageListByPost(post.getId());
                if (images == null || images.size() == 0) {
                    if (StringUtils.isBlank(imageIds)) {
                        WebUtil.print(response, new Result(false).msg("至少需要上传一张商品图!"));
                        return;
                    }
                }
                postService.update(post, imageIds);
            }
            WebUtil.print(response, new Result(true).msg("文章操作成功!"));
        } catch (DataIntegrityViolationException ex) {
            GeneralExceptionHandler.log("文章编码已存在", ex);
            WebUtil.print(response, new Result(false).msg("文章编码已存在!"));
        } catch (Exception e) {
            GeneralExceptionHandler.log("文章添加失败", e);
            WebUtil.print(response, new Result(false).msg("文章操作失败!"));
        }
    }


    @RequestMapping(value = "/delete")
    public void delete(HttpServletRequest request,
                       HttpServletResponse response,
                       String ids) {
        try {
            int[] arrayId = JsonUtil.json2Obj(ids, int[].class);
            postService.deleteAll(arrayId);
            WebUtil.print(response, new Result(true).msg("删除成功！"));
        } catch (Exception e) {
            GeneralExceptionHandler.log(e);
            WebUtil.print(response, new Result(false).msg("改文章存在关联无法删除！"));
        }
    }


    @RequestMapping(value = "/add")
    public String add(HttpServletRequest request,
                      HttpServletResponse response,
                      Integer id,
                      ModelMap model) {

        List<PostArea> postAreaList = postAreaService.findAll();
        List<PostType> postTypeList = postTypeService.findAll();
        model.put("postAreaList", postAreaList);
        model.put("postTypeList", postTypeList);
        if (id != null) {
            Post post = postService.getById(id);
            if (StringUtils.isNotBlank(post.getContent())) {
                post.setContent(post.getContent().replace("&lt", "<").replace("&gt", ">"));
            }
            List<Image> imageList = postImagesService.findImageListByPost(id);
            for(Image image : imageList){
                image.setPath(Configue.getUploadUrl() + image.getPath());
            }
            post.getImage().setPath(Configue.getUploadUrl() + post.getImage().getPath());
            post.setImages(imageList);
            model.put("post", post);
        }
        return "添加文章";
    }


    /**
     * 上下架文章
     *
     * @param request
     * @param response
     * @param id
     * @param isAdded
     */
    @RequestMapping("setting/isAdded")
    public void settingAdded(HttpServletRequest request,
                             HttpServletResponse response,
                             Integer id,
                             Boolean isAdded) {
        try {
            postService.settingAdded(id);
            String msg = "发表文章成功!";
            if (isAdded) {
                msg = "下架文章成功!";
            }
            WebUtil.print(response, new Result(true).msg(msg));
        } catch (Exception e) {
            GeneralExceptionHandler.log("操作文章失败!", e);
            WebUtil.print(response, new Result(false).msg("操作文章失败!"));
        }
    }


    /**
     * 删除图片
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "delPic")
    public void delPic(HttpServletRequest request,
                       HttpServletResponse response,
                       Integer postId,
                       Integer imageId) {
        postImagesService.delete(postId, imageId);
        WebUtil.print(response, new HashMap<>());
    }




}
