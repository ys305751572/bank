package com.sixmac.service;


import com.sixmac.entity.EmCust;
import com.sixmac.entity.Member;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangbin on 2015/3/3.
 */
public interface LoginService {

    public Member getMember(HttpServletRequest request, String type);

    public Boolean login(HttpServletRequest request, String username, String password, String remark);

    public Boolean login(HttpServletRequest request, EmCust emCust, String remark, String type);

    public Boolean login(HttpServletRequest request, String username, String password, String type, String remark);

    public void logOut(HttpServletRequest request, String type);



}
