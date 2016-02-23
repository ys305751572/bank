package com.sixmac.utils;

import com.sixmac.core.Constant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class CookiesUtils {

    /**
     * ����cookie���ӿڷ�����
     *
     * @param response
     * @param name
     *            cookie����
     * @param value
     *            cookieֵ
     * @param maxAge
     *            cookie�������� ����Ϊ��λ
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        try {
            Cookie cookie = new Cookie(name, URLEncoder.encode(value, Constant.ENCODING) );
            cookie.setPath("/");
            if (maxAge > 0){
                cookie.setMaxAge(maxAge);
            }
            response.addCookie(cookie);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * ��cookie��װ��Map���棨�ǽӿڷ�����
     *
     * @param request
     * @return ����֮�����Զ���½����
     */
    public static Map<String, Object> ReadCookieMap(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                String attname = cookie.getName();
                params.put(attname, cookie.getValue());
            }
        }
        return params;
    }

    public static String readCookie(HttpServletRequest request,String name){
       try {
           Cookie[] cookies = request.getCookies();
           if (null == cookies) {
               return null;
           }
           for (Cookie cookie : cookies) {
               if(cookie.getName().equals(name)){
                   return URLDecoder.decode(cookie.getValue(),Constant.ENCODING) ;
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }


    /**
     * ���cookie
     *
     * @param request
     * @param response
     * @return
     * @author Ϳ�Ⱥ�
     * @Date 2014-12-15 ����11:13:32
     */
    public static void clearCookie(HttpServletRequest request, HttpServletResponse response,String name) {
        Cookie[] cookies = request.getCookies();
        try {
            for (int i = 0; i < cookies.length; i++) {
                if(name.equals(cookies[i].getName())){
                    Cookie cookie = new Cookie(cookies[i].getName(), null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");// �����㴴��cookie��·��������д
                    response.addCookie(cookie);
                }
            }
        }
        catch (Exception ex) {
            System.out.println("���Cookies�����쳣��");
            ex.printStackTrace();
        }
    }
}