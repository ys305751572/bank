package com.sixmac.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sixmac.entity.EmCust;
import com.sixmac.entity.Image;
import com.sixmac.entity.VisitRecord;
import com.sixmac.service.EmCustService;
import com.sixmac.service.UploadImageService;
import com.sixmac.service.VisitRecordService;

@Controller
@RequestMapping("/admin/visit")
public class VisitController2 {

	@Autowired
	private VisitRecordService service;

	@Autowired
	private UploadImageService uploadImageService;

	@Autowired
	private EmCustService emCustService;
	
	@Autowired
	private VisitRecordService visitRecordService;
	
	@RequestMapping(value = "/page")
	public String recordPage(String error,Model model) {
		
		if(StringUtils.isNotBlank(error)) {
			model.addAttribute("error", error);
		}
		return "upload_img";
	}
	
	/**
	 * 新增回访记录
	 * 
	 * @param file
	 * @param witnessesWnumber
	 * @param name
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value = "/record", method = RequestMethod.POST)
	public String visitRecord(@RequestParam(value = "file1", required = false) MultipartFile file1,String wnumber, String custName, String custMobile,Model model) {

		VisitRecord record = new VisitRecord();
		EmCust cust2 = emCustService.findByCustNameAndWname(custName, wnumber);
		List<VisitRecord> list = visitRecordService.findByWnumberAndCustName(wnumber, custName);
		
		if(list != null && list.size() > 0) {
			model.addAttribute("error", "error1");
			return "redirect:/admin/visit/page";
		}
		
		Image image = uploadImageService.uploadImage(file1);
		
		record.setCustId(cust2.getCustomerId());
		record.setCustMobile(custMobile);
		record.setCustName(custName);
		record.setWnumber(wnumber);
		record.setWname(cust2.getName());
		record.setImage(image != null ? image.getPath() : "");
		record.setCreateDate(new Date());
		record.setModifyDate(new Date());
		service.create(record);
		model.addAttribute("error", "error2");
		return "redirect:/admin/visit/page";
	}
}
