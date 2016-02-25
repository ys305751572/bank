package com.sixmac.entity.vo;

public class EmCustVo {

	private Integer id;
	
	private String wnumber; // 员工工号
	
	private String name; // 员工姓名
	
	private String mobile; // 员工手机
	
	private String customerId;
	
	private String customerName; // 客户姓名
	
	private String beInsuranceName; // 被保人姓名
	
	private Double bf; // 保费
	
	private Long be; // 保额
	
	private Integer limit; // 期限
	
	private Integer year; // 年份

	private Long allBf; // 保费
	
	private Boolean isJoin = false; // 是否参加

	public Boolean getIsJoin() {
		return isJoin;
	}

	public void setIsJoin(Boolean isJoin) {
		this.isJoin = isJoin;
	}
	public Long getAllBf() {
		return allBf;
	}

	public void setAllBf(Long allBf) {
		this.allBf = allBf;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWnumber() {
		return wnumber;
	}

	public void setWnumber(String wnumber) {
		this.wnumber = wnumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getBeInsuranceName() {
		return beInsuranceName;
	}

	public void setBeInsuranceName(String beInsuranceName) {
		this.beInsuranceName = beInsuranceName;
	}

	public Double getBf() {
		return bf;
	}

	public void setBf(Double bf) {
		this.bf = bf;
	}
	public Long getBe() {
		return be;
	}

	public void setBe(Long be) {
		this.be = be;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}
