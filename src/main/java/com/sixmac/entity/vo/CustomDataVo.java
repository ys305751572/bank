package com.sixmac.entity.vo;

/**
 * 
 * @author yesong
 *
 */
public class CustomDataVo {

	private Long allCustomCount;
	
	private Double allMoney;
	
	private Long proviceCustomCount;
	
	private Long todayCount;

	public Long getAllCustomCount() {
		return allCustomCount;
	}

	public void setAllCustomCount(Long allCustomCount) {
		this.allCustomCount = allCustomCount;
	}

	public Double getAllMoney() {
		return allMoney;
	}

	public void setAllMoney(Double allMoney) {
		this.allMoney = allMoney;
	}

	public Long getProviceCustomCount() {
		return proviceCustomCount;
	}

	public void setProviceCustomCount(Long proviceCustomCount) {
		this.proviceCustomCount = proviceCustomCount;
	}

	public Long getTodayCount() {
		return todayCount;
	}

	public void setTodayCount(Long todayCount) {
		this.todayCount = todayCount;
	}
}
