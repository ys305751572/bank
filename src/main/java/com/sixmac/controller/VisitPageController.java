package com.sixmac.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sixmac.common.DataTableFactory;
import com.sixmac.common.exception.GeneralExceptionHandler;
import com.sixmac.controller.common.CommonController;
import com.sixmac.core.Configue;
import com.sixmac.entity.VisitRecord;
import com.sixmac.service.VisitRecordService;
import com.sixmac.utils.WebUtil;

@Controller
@RequestMapping("/admin/visitpage")
public class VisitPageController extends CommonController {

	@Autowired
	private VisitRecordService service;

	@RequestMapping(value = "/index")
    public String index(HttpServletRequest request,
                        HttpServletResponse response,
                        ModelMap model) {
		 return "visit-page";
	}
	

	@RequestMapping(value = "/list")
	public void visitPage(HttpServletRequest request, HttpServletResponse response, Integer draw, Integer start,
			Integer length, String wnumber, String wname, String custname, ModelMap model) {

		try {
			int pageNum = getPageNum(start, length);
			Page<VisitRecord> page = service.find(pageNum, length, wnumber, wname, custname);
			List<VisitRecord> list = page.getContent();
			for (VisitRecord visitRecord : list) {
				visitRecord.setImage(Configue.getUploadUrl() + visitRecord.getImage());
			}
			
			Map<String, Object> result = DataTableFactory.fitting(draw, page);
			WebUtil.print(response, result);
		} catch (Exception e) {
			GeneralExceptionHandler.log(e);
		}
		WebUtil.print(response, emptyData);
	}
}