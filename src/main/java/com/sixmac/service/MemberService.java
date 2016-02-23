package com.sixmac.service;

import com.sixmac.entity.Member;

import com.sixmac.service.common.ICommonService;
import org.springframework.data.domain.Page;

/**
 * Created by wangbin on 2015/8/10.
 */
public interface MemberService extends ICommonService<Member> {


    public Member findByUsernameAndPassword(String username, String password);

    public Member findByUsernameAndPassword(String username, String password, String type);

    public Page<Member> findByBusiness(int pageNum, int pageSize);
}
