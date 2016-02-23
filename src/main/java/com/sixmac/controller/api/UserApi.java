package com.sixmac.controller.api;

import com.sixmac.core.bean.Result;
import com.sixmac.entity.Product;
import com.sixmac.utils.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/18.
 */
@RequestMapping("/api/user")
@Controller
public class UserApi {

	@RequestMapping(value = "/info")
	public void userInfo(HttpServletRequest request, HttpServletResponse response, Integer userId) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		map.put("name", "wb");

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("user", map);
		WebUtil.print(response, new Result(true).data(result));
	}
}
