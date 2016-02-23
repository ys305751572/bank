package com.sixmac.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api/measure")
public class MeasureController {

	/**
	 * @api                {post} /api/measure/save 1、测量-新增记录
	 * @apiVersion         0.0.1
	 * @apiName            measure.save
	 * @apiGroup           measure
	 * @apiDescription     测量-新增记录
	 * @apiParam {LONG}    userId 用户ID
	 * @apiParam {INTEGER} part 测量部位:0.颈部,1.手部,2:脸部
	 * @apiParam {DOUBLE}  measureMoisture 水分值
	 * @apiParam {DOUBLE}  measureGrease 油脂
	 * @apiParam {STRING}  address 测量城市
	 *
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save() {
		
	}
	
	/**
	 * @api                  {post} /api/measure/list 2、测量-列表
	 * @apiVersion           0.0.1
	 * @apiName              measure.list
	 * @apiGroup             measure
	 * @apiDescription       测量-列表
	 * 
	 * @apiParam {LONG}      userId 用户
	 * @apiParam {INTEGER}   type 1.今日 2.本周 3.本月
	 *
	 * @apiSuccess {INTEGER} part 测量部位:0.颈部,1.手部,2:脸部
	 * @apiSuccess {DOUBLE}  result 肤质状况
	 * @apiSuccess {DOUBLE}  measureMoistureAve 水分 (平均值)
	 * @apiSuccess {DOUBLE}  result2 比较
	 * 
	 * @apiSuccessExample    {json} Success-Response:
     * HTTP/1.1 200 OK
        {"status":0,
         "msg":"",
         "data":{	
     		"list": {
     			"part": 0
         		"result": 湿润,
         		"measureMoistureAve" : 24%,
         		"result2" : 比最近一天+1.2%
     		}
        }
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public void list() {
		
	}
	
	/**
	 * @api {post} /api/measure/delete 3、测量-删除
	 * @apiVersion 0.0.1
	 * @apiName measure.delete
	 * @apiGroup measure
	 * @apiDescription 测量-删除
	 * 
	 * @apiParam {LONG} userId 用户ID
	 * @apiParam {LONG} id 记录ID
	 *
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public void delete() {
		
	}
	
	/**
	 * @api {post}           /api/measure/detail 4、测量-详情
	 * @apiVersion           0.0.1
	 * @apiName              measure.detail
	 * @apiGroup             measure
	 * @apiDescription       测量-列表
	 * 
	 * @apiParam {LONG}      userId 用户
	 * @apiParam {INTEGER}   part 测量部位:0.颈部,1.手部,2:脸部
	 * @apiParam {LONG}      timeDown 查询时间,下限
	 * @apiParam {LONG}      timeUp 查询时间,上限
	 *
	 * @apiSuccess {INTEGER} part 测量部位:0.颈部,1.手部,2:脸部
	 * @apiSuccess {DOUBLE}  result1 脸部肌肤润度 
	 * @apiSuccess {DOUBLE}  result2 脸部老化角质
	 * @apiSuccess {DOUBLE}  measureMoistureAve 脸部肌肤润度 (平均值)
	 * @apiSuccess {DOUBLE}  measureGreaseAve 脸部老化角质(平均值)
	 * @apiSuccess {DOUBLE}  list.measureMoisture 水分值
	 * @apiSuccess {DOUBLE}  list.measureGrease 油脂
	 * 
	 * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
        {"status":0,
         "msg":"",
         "data":{	
     		"part": 0,
     		"measureMoistureAve": 24%,
     		"measureGreaseAve" : 24%,
            "list":[
               {
               	"measureMoisture":24%,
                "measureGrease": 24%
               }
            ]
        }
	 */
	@RequestMapping(value = "detail", method = RequestMethod.POST)
	public void detail() {
		
	}
	
	/**
	 * @api {post}           /api/measure/advice 5、测量-建议
	 * @apiVersion           0.0.1
	 * @apiName              measure.advice
	 * @apiGroup             measure
	 * @apiDescription       测量-建议
	 * 
	 * @apiParam {LONG}      userId 用户ID
	 * @apiParam {INTEGER}   part 测量部位:0.颈部,1.手部,2:脸部
	 * @apiParam {INTEGER}   type 1.今日 2.本周 3.本月
	 *
	 * @apiSuccess {INTEGER} part 测量部位:0.颈部,1.手部,2:脸部
	 * @apiSuccess {DOUBLE}  measureMoistureAve 脸部肌肤润度 (平均值)
	 * @apiSuccess {DOUBLE}  measureGreaseAve 脸部老化角质(平均值)
	 * @apiSuccess {DOUBLE}  measureMoistureCompare 水分值比较
	 * @apiSuccess {DOUBLE}  measureGreaseCompare 油脂比较
	 * @apiSuccess {STRING}  result 肤质状况
	 * 
	 * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 200 OK
        {"status":0,
         "msg":"",
         "data":{	
     		"part": 0,
     		"measureMoistureAve": 24%,
     		"measureGreaseAve" : 24%,
            "measureMoistureCompare":+2.9%,
            "measureGreaseCompare": -2.9%,
            "result" : "肤质状况"
            ]
        }
	 */
	@RequestMapping(value = "advice", method = RequestMethod.POST)
	public void advice() {
		
	}
}
