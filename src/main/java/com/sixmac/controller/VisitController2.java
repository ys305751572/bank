package com.sixmac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sixmac.entity.EmCust;
import com.sixmac.entity.Image;
import com.sixmac.entity.VisitRecord;
import com.sixmac.service.EmCustService;
import com.sixmac.service.UploadImageService;
import com.sixmac.service.VisitRecordService;

@Controller
@RequestMapping("/api/visit")
public class VisitController2 {

	@Autowired
	private VisitRecordService service;

	@Autowired
	private UploadImageService uploadImageService;

	@Autowired
	private EmCustService emCustService;
	
	@RequestMapping(value = "/recordPage")
	public String recordPage() {
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
	@RequestMapping(value = "/record")
	public String visitRecord(@RequestParam MultipartFile file,String wnumber, String custName, String custMobile) {

		Image image = uploadImageService.uploadImage(file);
		
		VisitRecord record = new VisitRecord();
		EmCust cust2 = emCustService.findByCustNameAndWname(custName, wnumber);
		
		
		record.setCustId(cust2.getCustomerId());
		record.setCustMobile(custMobile);
		record.setCustName(custName);
		record.setWnumber(wnumber);
		record.setImage(image != null ? image.getPath() : "");
		service.create(record);
		return "";
	}
}
