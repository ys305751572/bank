package com.sixmac.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.sixmac.entity.VisitRecord;
import com.sixmac.service.common.ICommonService;

public interface VisitRecordService extends ICommonService<VisitRecord> {

	public Long countToday(String wnumber);
	
	public List<VisitRecord> findByWnumber(String wnumber);
	
	public Integer countVisitByWnumber(String wnumber);
	
	public List<VisitRecord> findByWnumberAndCustName(String wnumber,String custName);
	
	public Page<VisitRecord> find(int pageNum, int pageSize,String wnumber,String wname,String custname);
}
