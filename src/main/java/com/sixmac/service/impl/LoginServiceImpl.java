package com.sixmac.service.impl;

import com.sixmac.core.Constant;
import com.sixmac.entity.EmCust;
import com.sixmac.entity.Member;
import com.sixmac.service.EmCustService;
import com.sixmac.service.LoginService;
import com.sixmac.service.MemberService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by wangbin on 2015/3/3.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private EmCustService emCustService;

    @Override
    public Member getMember(HttpServletRequest request,String type) {
        Member member = null;
        if(Constant.MEMBER_TYPE_GLOBLE.equals(type)){
            member = (Member)request.getSession().getAttribute(Constant.SESSION_MEMBER_GLOBLE);
        }
        else if(Constant.MEMBER_TYPE_BUSINESS.equals(type)){
            member = (Member)request.getSession().getAttribute(Constant.SESSION_MEMBER_BUSINESS);
        }
        return member;
    }

    // �ܺ�̨��½
    @Override
    public Boolean login(HttpServletRequest request, String username, String password, String remark) {
//        Member member = memberService.findByUsernameAndPassword(username,password);
    	
    	EmCust cust = emCustService.findByUsernameAndPassword(username, password);
        if(cust!=null){
            request.getSession().setAttribute(Constant.SESSION_MEMBER_GLOBLE, cust);
            if(StringUtils.isNotBlank(remark)){
                request.getSession().setMaxInactiveInterval(60*60*24*7);
            }
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean login(HttpServletRequest request, EmCust cust, String remark,String type) {
        if(cust!=null){
            if(Constant.MEMBER_TYPE_GLOBLE.equals(type)){
                request.getSession().setAttribute(Constant.SESSION_MEMBER_GLOBLE, cust);
            }else if(Constant.MEMBER_TYPE_BUSINESS.equals(type)){
                request.getSession().setAttribute(Constant.SESSION_MEMBER_BUSINESS, cust);
            }
            if(StringUtils.isNotBlank(remark)){
                request.getSession().setMaxInactiveInterval(60*60*24*7);
            }
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean login(HttpServletRequest request, String username, String password, String type, String remark) {
    	EmCust cust = emCustService.findByUsernameAndPassword(username, password);
        return login(request,cust,remark,type);
    }

    @Override
    public void logOut(HttpServletRequest request,String type) {
        HttpSession session = request.getSession(false);
        if(Constant.MEMBER_TYPE_GLOBLE.equals(type)){
            session.removeAttribute(Constant.SESSION_MEMBER_GLOBLE);
        }else if(Constant.MEMBER_TYPE_BUSINESS.equals(type)){
            session.removeAttribute(Constant.SESSION_MEMBER_BUSINESS);
        }

    }


}
