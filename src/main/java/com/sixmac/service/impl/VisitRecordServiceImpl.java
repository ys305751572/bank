package com.sixmac.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.sixmac.dao.VisitRecordDao;
import com.sixmac.entity.VisitRecord;
import com.sixmac.service.VisitRecordService;

@Service
public class VisitRecordServiceImpl implements VisitRecordService{

	@Autowired
	private VisitRecordDao dao;
	
	@Override
	public List<VisitRecord> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<VisitRecord> find(int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<VisitRecord> find(int pageNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitRecord getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitRecord deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitRecord create(VisitRecord t) {
		dao.save(t);
		return t;
	}

	@Override
	public VisitRecord update(VisitRecord t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long countToday() {
		return dao.countRecordToday(new Date());
	}

	@Override
	public List<VisitRecord> findByWnumber(String wnumber) {
		return dao.findByWnumber(wnumber);
	}

	@Override
	public List<VisitRecord> findByWnumberAndCustName(String wnumber, String custName) {
		return dao.findByWnumberAndCustName(wnumber, custName);
	}

	@Override
	public Page<VisitRecord> find(int pageNum, final int pageSize,final String wnumber,final String wname,final String custname) {
		return dao.findAll(new Specification<VisitRecord>() {
			@Override
			public Predicate toPredicate(Root<VisitRecord> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				if(StringUtils.isNotBlank(wnumber)) {
					list.add(cb.like(root.get("wnumber").as(String.class), wnumber));
				}
				if(StringUtils.isNotBlank(wname)) {
					list.add(cb.like(root.get("wname").as(String.class), wname));
				} 
				if(StringUtils.isNotBlank(custname)) {
					list.add(cb.like(root.get("custName").as(String.class), custname));
				}
				return cb.and(list.toArray(new Predicate[]{}));
			}
		}, new PageRequest(pageNum, pageSize, Sort.Direction.DESC, "id"));
	}
}
