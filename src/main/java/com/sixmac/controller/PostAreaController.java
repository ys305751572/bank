package com.sixmac.controller;

import com.sixmac.common.exception.GeneralExceptionHandler;
import com.sixmac.common.DataTableFactory;
import com.sixmac.controller.common.CommonController;
import com.sixmac.core.bean.Result;
import com.sixmac.entity.PostArea;
import com.sixmac.service.PostAreaService;
import com.sixmac.utils.JsonUtil;
import com.sixmac.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by wangbin on 2015/8/20.
 */
@RequestMapping(value = "admin/post/area")
@Controller
public class PostAreaController extends CommonController {

    @Autowired
    private PostAreaService postAreaService;


    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request,
                        HttpServletResponse response){
        return "文章地址";
    }


    @RequestMapping(value = "/save")
    public void picSave(HttpServletRequest request,
                        HttpServletResponse response,
                        PostArea postArea){
        try {
            if (postArea.getId() == null) {
                postAreaService.create(postArea);
            } else {
                postAreaService.update(postArea);
            }
            WebUtil.print(response, new Result(true).msg("文章地址操作成功!"));
        } catch (Exception e) {
            GeneralExceptionHandler.log("文章地址操作失败", e);
            WebUtil.print(response, new Result(false).msg("文章地址操作失败!"));
        }
    }

    @RequestMapping(value = "/list")
    public void picList(HttpServletRequest request,
                        HttpServletResponse response,
                        String type,
                        Integer draw,
                        Integer start,
                        Integer length){
        try {
            int pageNum = getPageNum(start, length);
            Page<PostArea> page = postAreaService.find(pageNum, length);
            Map<String, Object> result = DataTableFactory.fitting(draw, page);
            WebUtil.print(response, result);
        } catch (Exception e) {
            WebUtil.print(response, emptyData);
            GeneralExceptionHandler.log(e);
        }
    }


    @RequestMapping(value = "/delete")
    public void picDel(HttpServletRequest request,
                       HttpServletResponse response,
                       String  ids){
        try {
            int[] arrayId = JsonUtil.json2Obj(ids, int[].class);
            postAreaService.deleteAll(arrayId);
            WebUtil.print(response, new Result(true).msg("删除文章地址成功！"));
        } catch (Exception e) {
            WebUtil.print(response, new Result(false).msg("删除文章地址失败！"));
        }
    }


}
