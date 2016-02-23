package com.sixmac.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sixmac.dao.EmCustDao;
import com.sixmac.entity.EmCust;
import com.sixmac.entity.VisitRecord;
import com.sixmac.entity.vo.CustomDataVo;
import com.sixmac.entity.vo.EmCustVo;
import com.sixmac.service.EmCustService;
import com.sixmac.service.VisitRecordService;
import com.sixmac.utils.ComparatorBe;
import com.sixmac.utils.ComparatorPinYin;

@Service
public class EmCustServiceImpl implements EmCustService{

	@Autowired
	private EmCustDao dao;
	
	@Autowired
	private VisitRecordService visitRecordService;
	
	
	@Autowired
	private EntityManagerFactory factory;
	
	@Override
	public List<EmCust> findAll() {
		return null;
	}

	@Override
	public Page<EmCust> find(int pageNum, int pageSize) {
		return null;
	}

	@Override
	public Page<EmCust> find(int pageNum) {
		return null;
	}

	@Override
	public EmCust getById(int id) {
		return null;
	}

	@Override
	public EmCust deleteById(int id) {
		return null;
	}

	@Override
	public EmCust create(EmCust t) {
		return null;
	}

	@Override
	public EmCust update(EmCust t) {
		return null;
	}

	@Override
	public void deleteAll(int[] ids) {
	}

	@Override
	public EmCust findByUsernameAndPassword(String username, String password) {
//		return dao.findByUsernameAndPassword(username, password);
		return null;
	}

	@Override
	@Transactional
	public List<EmCustVo> findCustomerByWnumber(String wnumber) {
		List<EmCust> list = dao.findCustomerByWnumber(wnumber);
		List<EmCustVo> voList = countAllBf(list);
		
		analysisIsJoin(voList,wnumber);
		sort(voList,"","");
		return voList;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void sort(List voList, String property, String sort) {
		if("be".equals(property)) {
			Collections.sort(voList, new ComparatorBe());
		}
		else {
			Collections.sort(voList, new ComparatorPinYin());
		}
		if("desc".equals(sort)) {
			Collections.reverse(voList);
		}
	}

	private void analysisIsJoin(List<EmCustVo> voList,String wnumber) {
		List<VisitRecord> recordList = visitRecordService.findByWnumber(wnumber);
		for (EmCustVo vo : voList) {
			for (VisitRecord visitRecord : recordList) {
				if(vo.getCustomerId().equals(visitRecord.getCustId()) && vo.getWnumber().equals(visitRecord.getWnumber())) {
					vo.setIsJoin(true);
				}
			}
		}
	}

	public List<EmCustVo> countAllBf(List<EmCust> list) {
		
		List<EmCustVo> voList = new ArrayList<EmCustVo>();
		for (EmCust emCust : list) {
			String custId = emCust.getCustomerId();
			if(!isContains(voList, custId)) {
				double allBf = 0.0;
				for (EmCust emCust2 : list) {
					if(custId.equals(emCust2.getCustomerId())) {
						allBf += emCust2.getBf();
					}
				}
				EmCustVo vo = new EmCustVo();
				vo.setWnumber(emCust.getWnumber());
				vo.setName(emCust.getName());
				vo.setAllBf(allBf);
				voList.add(vo);
			}
		}
		return voList;
	}
	
	public boolean isContains(List<EmCustVo> voList,String custId) {
		for (EmCustVo emCustVo : voList) {
			if(emCustVo.getCustomerId().equals(custId)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public CustomDataVo generateCustomDataVo() {
		
		Long countCustom = dao.countCustom();
		Double countMoney = dao.countMoney();
		Long todayRecord = visitRecordService.countToday();
		CustomDataVo vo = new CustomDataVo();
		vo.setAllCustomCount(countCustom);
		vo.setAllMoney(countMoney);
		vo.setProviceCustomCount(countCustom);
		vo.setTodayCount(todayRecord);
		return vo;
	}

	@Override
	public List<EmCustVo> findCustByCustId(String custId,String wnumber) {
		List<EmCustVo> voList = new ArrayList<EmCustVo>();
		EmCustVo vo = null;
		
		List<EmCust> custList = dao.findByCustId(custId,wnumber);
		for (EmCust emCust : custList) {
			vo = new EmCustVo();
			vo.setBeInsuranceName(emCust.getBeInsuranceName());
			vo.setLimit(emCust.getLimit());
			vo.setBe(emCust.getBe());
			voList.add(vo);
		}
		return voList;
	}

	@Override
	public EmCust findByCustNameAndWname(String custName, String wname) {
		EntityManager em = factory.createEntityManager();
		
		String sql = "select a.* from tb_em_cust a where a.customer_name = '"+ custName +"' and wnumber = '"+ wname +"' limit 1";
		Query query = em.createNativeQuery(sql, EmCust.class);
		EmCust cust = (EmCust) query.getSingleResult();
		return cust;
	}
}
