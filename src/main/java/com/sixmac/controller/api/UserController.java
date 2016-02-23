package com.sixmac.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api/user")
@Controller
public class UserController {
	
	/**
	 * @api {post} /api/user/uploadAvater 1、上传头像
	 * @apiVersion 0.0.1
	 * @apiName user.uploadAvater
	 * @apiGroup user
	 * @apiDescription 上传头像
	 * @apiParam {LONG}          userId   用户ID
	 * @apiParam {MultipartFile} file 头像
	 * 
	 */
	@RequestMapping(value = "/uploadAvater", method = RequestMethod.POST)
	public void uploadAvater() {
		
	}
	
	/**
	 * @api {post} /api/user/modifyUserInfo 2、修改个人信息
	 * @apiVersion 0.0.1
	 * @apiName user.modifyUserInfo
	 * @apiGroup user
	 * @apiDescription 修改个人信息
	 * @apiParam {LONG}    userId 用户ID
	 * @apiParam {STRING}  nickname 昵称
	 * @apiParam {INTEGER} gender 性别 :1.男 2.女
	 * @apiParam {DOUBLE}  weight 体重
	 * @apiParam {DOUBLE}  height 身高
	 * @apiParam {INTEGER} year 出身年份
	 * @apiParam {INTEGER} skin 肤质:0.敏感性,1.中性,2.油性,3.干性,4.混合性
	 * 
	 */
	@RequestMapping(value = "modifyUserInfo", method = RequestMethod.POST)
	public void modifyUserInfo() {
		
	}
	
	/**
	 * @api {post} /api/user/modifyPassword 3、修改密码
	 * @apiVersion 0.0.1
	 * @apiName user.modifyPassword
	 * @apiGroup user
	 * @apiDescription 修改密码
	 * @apiParam {STRING}  userId 用户ID
	 * @apiParam {STRING}  oldPassword 原密码(空:找回密码,不空:修改密码)
	 * @apiParam {STRING}  newPassword 新密码
	 * @apiParam {STRING}  code 验证码
	 */
	public void modifyPassword() {
		
	}
}
