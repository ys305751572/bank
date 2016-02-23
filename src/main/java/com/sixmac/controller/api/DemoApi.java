package com.sixmac.controller.api;

import com.sixmac.common.DataTableFactory;
import com.sixmac.controller.ProductController;
import com.sixmac.controller.common.CommonController;
import com.sixmac.entity.Product;
import com.sixmac.service.ProductService;
import com.sixmac.service.impl.ProductServiceImpl;
import com.sixmac.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/18.
 */
@RequestMapping("/api/demo")
@Controller
public class DemoApi {

    @Autowired
    private ProductService service;

    @RequestMapping(value = "/info")
    public void userInfo(HttpServletRequest request,
                         HttpServletResponse response){


//        Page<Product> page = productList();
      //  Map<String, Object> result = DataTableFactory.fitting(draw, page);
        Map<String,Object> result =  new HashMap<String,Object>();

        List<Product> list = service.productList();

        result.put("data",list);
        WebUtil.print(response, result);
    }


}
