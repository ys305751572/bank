package com.sixmac.service.impl;

import com.sixmac.core.Constant;
import com.sixmac.dao.MemberDao;
import com.sixmac.entity.Member;

import com.sixmac.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wangbin on 2015/8/10.
 */
@Service
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;


    @Override
    public List<Member> findAll() {
        return memberDao.findAll();
    }

    @Override
    public Page<Member> find(int pageNum, int pageSize) {
        return memberDao.findAll(new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "id"));
    }

    @Override
    public Page<Member> find(int pageNum) {
        return find(pageNum, Constant.PAGE_DEF_SZIE);
    }

    @Override
    public Member getById(int id) {
        return memberDao.findOne(id);
    }

    @Override
    @Transactional
    public Member deleteById(int id) {
        Member member = getById(id);
        memberDao.delete(member);
        return member;
    }

    @Override
    @Transactional
    public Member create(Member member) {
        member.setCreateDate(new Date());
        member.setUpdateDate(new Date());
        memberDao.save(member);
        return member;
    }

    @Override
    @Transactional
    public Member update(Member member) {
        return memberDao.save(member);
    }

    @Override
    @Transactional
    public void deleteAll(int[] ids) {
        for (int id : ids) {
            deleteById(id);
        }
    }

    @Override
    public Member findByUsernameAndPassword(String username, String password) {
        return memberDao.findByUnameAndPword(username,password);
    }

    @Override
    public Member findByUsernameAndPassword(String username, String password, String type) {
        return memberDao.findByUnameAndPword(username,password,type);
    }

    @Override
    public Page<Member> findByBusiness(int pageNum, int pageSize) {
        return memberDao.findByBusiness(new PageRequest(pageNum - 1, pageSize, Sort.Direction.DESC, "business.sort"));
    }
}