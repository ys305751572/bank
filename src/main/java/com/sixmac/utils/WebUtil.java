package com.sixmac.utils;



import com.sixmac.core.Constant;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by wangbin on 14-10-17.
 */
public class WebUtil {


    public static void print(HttpServletResponse response, Object data){
        try {
            // ������Ӧͷ
            response.setContentType("application/json"); // ָ����������Ϊ JSON ��ʽ
            response.setCharacterEncoding(Constant.ENCODING); // ��ֹ��������
            // ����Ӧ��д������
            PrintWriter writer = response.getWriter();
            writer.write(JsonUtil.obj2Json(data)); // תΪ JSON �ַ���
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public static void print(HttpServletResponse response,String data){
        try {
            // ������Ӧͷ
            response.setContentType("text/html"); // ָ����������Ϊ JSON ��ʽ
            response.setStatus(HttpServletResponse.SC_OK);
            response.setCharacterEncoding(Constant.ENCODING); // ��ֹ��������
            // ����Ӧ��д������
            PrintWriter writer = response.getWriter();
            writer.write(data); // תΪ JSON �ַ���
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public  static void printJson(HttpServletResponse response, Object data){
        try {
            // ������Ӧͷ
            response.setContentType("application/json"); // ָ����������Ϊ JSON ��ʽ
            response.setCharacterEncoding(Constant.ENCODING); // ��ֹ��������
            // ����Ӧ��д������
            PrintWriter writer = response.getWriter();
            writer.write(JsonUtil.obj2Json(data)); // תΪ JSON �ַ���
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public  static void printJson(HttpServletResponse response, String data){
        try {
            // ������Ӧͷ
            response.setContentType("application/json"); // ָ����������Ϊ JSON ��ʽ
            response.setCharacterEncoding(Constant.ENCODING); // ��ֹ��������
            // ����Ӧ��д������
            PrintWriter writer = response.getWriter();
            writer.write(data); // תΪ JSON �ַ���
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
