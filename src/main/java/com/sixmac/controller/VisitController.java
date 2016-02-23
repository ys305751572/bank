package com.sixmac.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sixmac.controller.common.CommonController;
import com.sixmac.core.Constant;
import com.sixmac.entity.EmCust;
import com.sixmac.entity.Image;
import com.sixmac.entity.VisitRecord;
import com.sixmac.entity.vo.CustomDataVo;
import com.sixmac.entity.vo.EmCustVo;
import com.sixmac.service.EmCustService;
import com.sixmac.service.UploadImageService;
import com.sixmac.service.VisitRecordService;

@Controller
@RequestMapping("/visit")
public class VisitController extends CommonController {

	@Autowired
	private VisitRecordService service;

	@Autowired
	private UploadImageService uploadImageService;

	@Autowired
	private EmCustService emCustService;
	
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

	/**
	 * 保单明细
	 * 
	 * @param wnumber
	 * @return
	 */
	@RequestMapping(value = "/bddetail")
	public String bddetail(String custId,HttpServletRequest request,Model model) {
		
		EmCust loginUser = (EmCust) request.getSession().getAttribute(Constant.SESSION_MEMBER_BUSINESS);
		
		if(loginUser == null) { 
			return "redirect:/admin/login";
		}
		List<EmCustVo> voList = emCustService.findCustByCustId(custId,loginUser.getWnumber());
		model.addAttribute("list", voList);
		return "";
	}

	/**
	 * 健康一起行
	 * 
	 * @return
	 */
	@RequestMapping(value = "/recordDetail")
	public String visitRecordDetail(Model model) {
		
		CustomDataVo vo = emCustService.generateCustomDataVo();
		model.addAttribute("vo", vo);
		return "";
	}

	/**
	 * 客户明细	
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "customerDetail")
	public String customerDetail(HttpServletRequest request,Model model) {
		
		EmCust loginUser = (EmCust) request.getSession().getAttribute(Constant.SESSION_MEMBER_BUSINESS);
		
		String wnumber = "";
		if(loginUser != null) {
			wnumber = loginUser.getWnumber();
			List<EmCustVo> list = emCustService.findCustomerByWnumber(wnumber);
			
			
			model.addAttribute("list", list);
			return "";
		}
		else {
			return "redirect:/admin/login";
		}
	}
}
