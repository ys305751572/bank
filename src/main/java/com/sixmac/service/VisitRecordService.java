package com.sixmac.service;

import java.util.List;

import com.sixmac.entity.VisitRecord;
import com.sixmac.service.common.ICommonService;

public interface VisitRecordService extends ICommonService<VisitRecord> {

	public Long countToday();
	
	public List<VisitRecord> findByWnumber(String wnumber);
	
	public List<VisitRecord> findByWnumberAndCustName(String wnumber,String custName);
}
