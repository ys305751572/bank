package com.sixmac.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
		t.setCreateDate(new Date());
		t.setUpdateDate(new Date());
		dao.save(t);
		return null;
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
}
