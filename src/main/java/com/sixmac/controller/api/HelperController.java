package com.sixmac.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api/help")
public class HelperController {

	/**
	 * @api                  {post} /api/help/helper 1、帮助
	 * @apiVersion           0.0.1
	 * @apiName              help.helper
	 * @apiGroup             helper
	 * @apiDescription       帮助
	 * 
	 * @apiParam   {INTEGER} type 类型:0.注册协议 1.关于软件 2.帮助 3.测试帮助
	 * 
	 * @apiSuccess {STRING}  content 内容
	 * @apiSuccess {INTEGER} type 类型:0.注册协议 1.关于软件 2.帮助 3.测试帮助
	 * 
	 * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
        {"status":0,
         "msg":"",
         "data":{	
     		"type": 0,
     		"content": 注册协议
         }
        }
	 */
	@RequestMapping(value = "/helper", method = RequestMethod.POST)
	public void helper() {
		
	}
}
