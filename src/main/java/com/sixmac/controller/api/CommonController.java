package com.sixmac.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api/common")
@Controller
public class CommonController {

	/**
	 * @api {post} /api/common/sendCode 1、发送验证码
	 * @apiVersion 0.0.1
	 * @apiName common.sendCode
	 * @apiGroup common
	 * @apiDescription 发送验证码
	 * 
	 * @apiParam {STRING}    mobile 手机
	 * 
	 */
	@RequestMapping(value = "/sendCode", method = RequestMethod.POST)
	public void sendCode() {
		
	}
	
	/**
	 * @api {post} /api/common/login 2、登录
	 * @apiVersion 0.0.1
	 * @apiName common.login
	 * @apiGroup common
	 * @apiDescription       登录
	 * @apiParam {STRING}    mobile 手机
	 * @apiParam {STRING}    password 密码
	 * 
	 * @apiSuccess {LONG}    id 用户名
	 * @apiSuccess {STRING}  mobile 手机号(登录账号)
	 * @apiSuccess {STRING}  nickname 昵称
	 * @apiSuccess {STRING}  avater 头像
	 * @apiSuccess {INTEGER} gender 性别:1.男 2.女
	 * @apiSuccess {DOUBLE}  weight 体重
	 * @apiSuccess {DOUBLE}  height 身高
	 * @apiSuccess {INTEGER} year 出身年份
	 * @apiSuccess {INTEGER} skin 肤质:0.敏感性,1.中性,2.油性,3.干性,4.混合性
	 * 
	 * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
        {"status":0,
         "msg":"",
         "data":{	
         	"user": {
         		"id": 1,
         		"mobile": 13476101111,
         		"nickname" : 张三,
                "avater" : http://image,
                "gender" : 1,
                "weight" : 70, 
                "height" : 175,
                "year"   : 1989,
                "skin"   : 0
         	}
        }
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login() {
		
	}
	
	/**
	 * @api {post} /api/common/logout 3、登出
	 * @apiVersion 0.0.1
	 * @apiName common.logout
	 * @apiGroup common
	 * @apiDescription 登出
	 * @apiParam {STRING} id 用户ID
	 *
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout() {
		
	}
	
	/**
	 * @api {post} /api/common/register 3、注册
	 * @apiVersion 0.0.1
	 * @apiName common.register
	 * @apiGroup common
	 * @apiDescription 注册
	 * 
	 * @apiParam {STRING} code 验证码
	 * @apiParam {STRING} mobile 用户名
	 * @apiParam {STRING} password 密码
	 * @apiParam {INTEGER} gender 性别 1.男 2.女
	 * @apiParam {DOUBLE} weight 体重
	 * @apiParam {DOUBLE} height 身高
	 * @apiParam {INTEGER} year 出身年份
	 * @apiParam {INTEGER} skin 肤质:0.敏感性,1.中性,2.油性,3.干性,4.混合性
	 * 
	 * @apiSuccess {LONG} id 用户名
	 * @apiSuccess {STRING} mobile 手机号(登录账号)
	 * @apiSuccess {STRING} nickname 昵称
	 * @apiSuccess {STRING} avater 头像
	 * @apiSuccess {INTEGER} gender 性别:1.男 2.女
	 * @apiSuccess {DOUBLE} weight 体重
	 * @apiSuccess {DOUBLE} height 身高
	 * @apiSuccess {INTEGER} year 出身年份
	 * @apiSuccess {INTEGER} skin 肤质:0.敏感性,1.中性,2.油性,3.干性,4.混合性
	 * 
	 * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
        {"status":0,
         "msg":"",
         "data":{	
         	"user": {
         		"id": 1,
         		"mobile": 13476101111,
         		"nickname" : 张三,
                "avater" : http://image,
                "gender" : 1,
                "weight" : 70, 
                "height" : 175,
                "year"   : 1989,
                "skin"   : 0
         	}
        }
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register() {
		
	}
	
	/**
	 * @api {post} /api/common/bind 4、绑定第三方账号
	 * @apiVersion 0.0.1
	 * @apiName common.bind
	 * @apiGroup common
	 * @apiDescription 绑定第三方账号
	 * @apiParam {LONG} userId 用户ID
	 * @apiParam {STRING} openId 第三方ID
	 * 
	 */
	@RequestMapping(value = "/bind", method = RequestMethod.POST)
	public void bind() {
		
	}
}
