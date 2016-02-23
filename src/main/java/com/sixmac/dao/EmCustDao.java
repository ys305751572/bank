package com.sixmac.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sixmac.entity.EmCust;

public interface EmCustDao extends JpaRepository<EmCust, Integer>{

	@Query("select a from EmCust a where a.wnumber = ?1 and a.mobile = ?2 limit 1")
	public EmCust findByUsernameAndPassword(String username,String password);
	
	@Query("select a from EmCust a where a.wnumber = ?1")
	public List<EmCust> findCustomerByWnumber(String wnumber);
	
	@Query("select count from EmCust a")
	public Long countCustom();
	
	@Query("select sum(a.bf) from EmCust a")
	public Double countMoney();
	
	@Query("select a from EmCust a where a.customerId = ?1 and a.wnumber = ?2")
	public List<EmCust> findByCustId(String custId,String wnumber);
	
	@Query("select a where EmCust a where a.customerName = ?1 and wnumber = ?2 limit 1")
	public EmCust findByCustNameAndWname(String custName,String wname);
}
