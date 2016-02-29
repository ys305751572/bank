package com.sixmac.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.sixmac.utils.ExportExcel;
import com.sixmac.utils.RecordExcel;
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
	
	@RequestMapping(value = "downloadTaskExcel")
	public void downloadTaskExcel(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/x-download");
		String filename = "";
		try {
			filename = URLEncoder.encode("任务完成列表","UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		response.addHeader("Content-Disposition", "attachment;filename="+ filename +".xls");

		
		List<RecordExcel> list = new ArrayList<RecordExcel>();
		RecordExcel re = null;
		List<VisitRecord> _list = service.findAll();
		for (VisitRecord visitRecord : _list) {
			re = new RecordExcel();
			re.setWnumber(visitRecord.getWnumber());
			re.setWname(visitRecord.getWname());
			re.setCustName(visitRecord.getCustName());
			re.setCustMobile(visitRecord.getCustMobile());
			re.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(visitRecord.getCreateDate()));
			list.add(re);
		}
		
		String[] headers = { "工号", "员工姓名", "客户姓名", "客户电话 ", "创建时间" };

		ExportExcel<RecordExcel> ex = new ExportExcel<RecordExcel>();
		try {
			OutputStream out = response.getOutputStream();
			ex.exportExcel(headers, list, out);
			out.close();
			System.out.println("excel导出成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}