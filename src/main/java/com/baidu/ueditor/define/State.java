package com.baidu.ueditor.define;

/**
 * ����״̬�ӿ�
 * @author hancong03@baidu.com
 *
 */
public interface State {
	
	public boolean isSuccess();
	
	public void putInfo(String name, String val);
	
	public void putInfo(String name, long val);
	
	public String toJSONString();

}
