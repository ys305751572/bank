package com.sixmac.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api/report")
public class ReportController {

	/**
	 * @api {post} /api/report/save 1、反馈-新增记录
	 * @apiVersion 0.0.1
	 * @apiName report.save
	 * @apiGroup report
	 * @apiDescription    测量-新增记录
	 * @apiParam {LONG}   userId 用户ID
	 * @apiParam {STRING} contact 联系方式
	 * @apiParam {STRING} content 反馈内容
	 *
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public void save() {
		
	}
}
