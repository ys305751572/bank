package com.sixmac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_em_cust")
public class EmCust {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "wnumber")
	private String wnumber; // 员工工号
	
	@Column(name = "name")
	private String name; // 员工姓名
	
	@Column(name = "mobile")
	private String mobile; // 员工手机
	
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "customer_name")
	private String customerName; // 客户姓名
	
	@Column(name = "be_insurance_name")
	private String beInsuranceName; // 被保人姓名
	
	@Column(name = "bf")
	private Double bf; // 保费
	
	@Column(name = "be")
	private Double be; // 保额
	
	@Column(name = "limit")
	private Integer limit; // 期限
	
	@Column(name = "year")
	private Integer year; // 年份

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

	public Double getBe() {
		return be;
	}

	public void setBe(Double be) {
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
