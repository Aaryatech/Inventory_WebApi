package com.inventory.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
@Entity
public class TallyCustomer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	private int custId; 
	
	@Column(name = "cust_name")
	private String custName;

	@Column(name = "address")
	private String address;
	
	@Column(name = "gstin")
	private String gstin;
	
	@Column(name = "cust_code")
	private String custCode;
	
	@Column(name = "mobile")
	private String mobile; 
	
	@Column(name = "email")
	private String email;

	@Column(name = "phone1")
	private String phone1;
	
	@Column(name = "cust_type")
	private String custType;
	
	@Column(name = "conct_prsn")
	private String conctPrsn;
	
	@Column(name = "prsn_email")
	private String prsnEmail;
	
	@Column(name = "pan_no")
	private String panNo;
	
	@Column(name = "is_same_state")
	private String isSameState;
	
	@Column(name = "credit_days")
	private int creditDays;
	
	@Column(name = "del_status")
	private int delStatus;

	@PostLoad
	public void onLoad() {
		if(isSameState.equalsIgnoreCase("1"))
		{
			this.isSameState="YES";
		}else 
		{
			this.isSameState="No";
		}
		if(custType.equalsIgnoreCase("1"))
		{
			this.custType="Wholesaler";
		}else
		{
			this.custType="Retailer";
		}
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getConctPrsn() {
		return conctPrsn;
	}

	public void setConctPrsn(String conctPrsn) {
		this.conctPrsn = conctPrsn;
	}

	public String getPrsnEmail() {
		return prsnEmail;
	}

	public void setPrsnEmail(String prsnEmail) {
		this.prsnEmail = prsnEmail;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getIsSameState() {
		return isSameState;
	}

	public void setIsSameState(String isSameState) {
		this.isSameState = isSameState;
	}

	public int getCreditDays() {
		return creditDays;
	}

	public void setCreditDays(int creditDays) {
		this.creditDays = creditDays;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "TallyCustomer [custId=" + custId + ", custName=" + custName + ", address=" + address + ", gstin="
				+ gstin + ", custCode=" + custCode + ", mobile=" + mobile + ", email=" + email + ", phone1=" + phone1
				+ ", custType=" + custType + ", conctPrsn=" + conctPrsn + ", prsnEmail=" + prsnEmail + ", panNo="
				+ panNo + ", isSameState=" + isSameState + ", creditDays=" + creditDays + ", delStatus=" + delStatus
				+ "]";
	}
	
	
}
