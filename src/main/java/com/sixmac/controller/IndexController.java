package com.sixmac.controller;

import com.sixmac.common.exception.GeneralExceptionHandler;
import com.sixmac.controller.common.CommonController;
import com.sixmac.core.Constant;
import com.sixmac.core.bean.Result;
import com.sixmac.entity.Member;
import com.sixmac.service.LoginService;
import com.sixmac.service.MemberService;
import com.sixmac.utils.CookiesUtils;
import com.sixmac.utils.Md5Util;
import com.sixmac.utils.WebUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangbin on 2015/7/29.
 */
@Controller
@RequestMapping(value = "admin")
public class IndexController extends CommonController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request,
                        HttpServletResponse response,
                        String error,
                        ModelMap model) {
        if (StringUtils.isNotBlank(error)) {
            model.addAttribute("error", error);
        }
        // 先读取cookies，如果存在，则将用户名回写到输入框
        Map<String, Object> params = CookiesUtils.ReadCookieMap(request);
        if (params != null && params.size() != 0) {
            String username = (String) params.get("username");
            model.put("username",username);
        }
        return "登录";
    }

    @RequestMapping(value = "/login/check")
    public String checkLogin(String username,
                             String password,
                             HttpServletRequest request, HttpServletResponse response,
                             String remark,
                             ModelMap model) {

        Boolean success = loginService.login(request, username, Md5Util.md5(password), Constant.MEMBER_TYPE_GLOBLE, remark);
        if (success) {
            // 登录成功后，将用户名放入cookies
            int loginMaxAge = 30 * 24 * 60 * 60; // 定义cookies的生命周期，这里是一个月。单位为秒
            CookiesUtils.addCookie(response, "username", username, loginMaxAge);
            return "redirect:/admin/dashboard";
        }
        model.addAttribute("error", "用户名或密码错误!");
        return "redirect:/admin/login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response,
                         ModelMap model) {
        loginService.logOut(request, Constant.MEMBER_TYPE_GLOBLE);
        return "登录";
    }

    @RequestMapping(value = "/")
    public String index(){

        return "redirect:/admin/dashboard";
    }


    @RequestMapping(value = "/dashboard")
    public String dashboard(HttpServletRequest request,
                            HttpServletResponse response,
                            ModelMap model) {

        return "控制面板";
    }


    @RequestMapping("/check/oldPwd")
    public void checkOldPwd(HttpServletRequest request,
                            HttpServletResponse response,
                            String oldPwd){
        Map<String,String> result = new HashMap<String, String>();
        Member member = loginService.getMember(request, Constant.MEMBER_TYPE_GLOBLE);
        if(!member.getPassword().equals(Md5Util.md5(oldPwd))){
            result.put("error","旧密码不正确!");
            WebUtil.print(response, result);
        }else{
            result.put("ok","");
            WebUtil.print(response, result);
        }
    }


    @RequestMapping("/modifyPwd")
    public void modifyPwd(HttpServletRequest request,
                          HttpServletResponse response,
                          String oldPwd,
                          String newPwd) {
        Member member = null;
        try {
            member = loginService.getMember(request,Constant.MEMBER_TYPE_GLOBLE);
            if(null != member){
                if(member.getPassword().equals(Md5Util.md5(oldPwd))){
                    member.setPassword(Md5Util.md5(newPwd));
                    memberService.update(member);
                    loginService.logOut(request,Constant.MEMBER_TYPE_GLOBLE);
                    WebUtil.print(response, new Result(true).msg("修改密码成功！请重新登录！"));
                }else{
                    WebUtil.print(response, new Result(false).msg("旧密码错误，修改密码失败！"));
                }
            }else{
                WebUtil.print(response, new Result(false).msg("当前用户未登录！"));
            }
        } catch (Exception e) {
            GeneralExceptionHandler.log("修改密码失败", e);
            WebUtil.print(response, new Result(false).msg("修改密码失败！"));
        }
    }

}
