package com.sixmac.service;

import java.util.List;

import com.sixmac.entity.EmCust;
import com.sixmac.entity.vo.CustomDataVo;
import com.sixmac.entity.vo.EmCustVo;
import com.sixmac.service.common.ICommonService;

public interface EmCustService extends ICommonService<EmCust>{

	public EmCust findByUsernameAndPassword(String username,String password);
	
	public List<EmCustVo> findCustomerByWnumber(String wnumber,String property,String sort);
	
	public CustomDataVo generateCustomDataVo(String wnumber);
	
	public List<EmCustVo> findCustByCustId(String custId,String wnumber);
	
	public EmCust findByCustNameAndWname(String custName,String wname);
	
}
