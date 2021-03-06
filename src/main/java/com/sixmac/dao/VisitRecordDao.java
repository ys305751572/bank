package com.sixmac.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import com.sixmac.entity.VisitRecord;

public interface VisitRecordDao extends JpaRepository<VisitRecord, Integer>,JpaSpecificationExecutor<VisitRecord> {

	@Query("select count(a) from VisitRecord a where year(a.createDate) = year(?1) and MONTH(a.createDate) = MONTH(?1) and DAY(a.createDate) = DAY(?1) and a.wnumber = ?2")
	public Long countRecordToday(Date time,String wnumber);
	
	@Query("select a from VisitRecord a where a.wnumber = ?1")
	public List<VisitRecord> findByWnumber(String wnumber);
	
	@Query("select a from VisitRecord a where a.wnumber = ?1 and a.custName = ?2")
	public List<VisitRecord> findByWnumberAndCustName(String wnumber, String custName);
	
	@Query("select count(a) from VisitRecord a where a.wnumber = ?1")
	public Integer countVisitByWnumber(String wnumber);
}
