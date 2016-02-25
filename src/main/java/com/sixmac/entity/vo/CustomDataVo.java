package com.sixmac.entity.vo;

/**
 * 
 * @author yesong
 *
 */
public class CustomDataVo {

	private Long allCustomCount;
	
	private Long allMoney;
	
	private Integer proviceCustomCount;
	
	private Long todayCount;

	public Long getAllCustomCount() {
		return allCustomCount;
	}

	public void setAllCustomCount(Long allCustomCount) {
		this.allCustomCount = allCustomCount;
	}
	public Long getAllMoney() {
		return allMoney;
	}

	public void setAllMoney(Long allMoney) {
		this.allMoney = allMoney;
	}

	public Integer getProviceCustomCount() {
		return proviceCustomCount;
	}

	public void setProviceCustomCount(Integer proviceCustomCount) {
		this.proviceCustomCount = proviceCustomCount;
	}

	public Long getTodayCount() {
		return todayCount;
	}

	public void setTodayCount(Long todayCount) {
		this.todayCount = todayCount;
	}
}
