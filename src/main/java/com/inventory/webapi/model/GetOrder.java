package com.inventory.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetOrder implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId; 
	
	@Column(name = "order_date")
	private Date orderDate; 
	
	@Column(name = "cust_id")
	private int custId; 
	
	@Column(name = "cust_type")
	private int custType; 
	
	@Column(name = "is_same_state")
	private int isSameState; 
	
	@Column(name = "cust_name")
	private String custName; 
	
	@Column(name = "gstin")
	private String gstin; 
	
	@Column(name = "address")
	private String address; 
	
	@Column(name = "mobile")
	private String mobile; 
	
	@Column(name = "credit_days")
	private int creditDays; 
	
	
	@Column(name = "order_sub_type")
	private int orderSubType; 
	
	@Column(name = "order_status")
	private int orderStatus; 
	
	@Column(name = "order_datetime")
	private String orderDatetime; 
	
	@Column(name = "delivery_date")
	private Date deliveryDate;
	
	@Column(name = "user_id")
	private int userId; 
	
	@Column(name = "user_name")
	private String userName; 
	
	@Column(name = "is_bill_generated")
	private int isBillGenerated;

	
	
	public int getIsSameState() {
		return isSameState;
	}

	public void setIsSameState(int isSameState) {
		this.isSameState = isSameState;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getCreditDays() {
		return creditDays;
	}

	public void setCreditDays(int creditDays) {
		this.creditDays = creditDays;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOrderDate() {
		return orderDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getCustType() {
		return custType;
	}

	public void setCustType(int custType) {
		this.custType = custType;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getOrderSubType() {
		return orderSubType;
	}

	public void setOrderSubType(int orderSubType) {
		this.orderSubType = orderSubType;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDatetime() {
		return orderDatetime;
	}

	public void setOrderDatetime(String orderDatetime) {
		this.orderDatetime = orderDatetime;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getIsBillGenerated() {
		return isBillGenerated;
	}

	public void setIsBillGenerated(int isBillGenerated) {
		this.isBillGenerated = isBillGenerated;
	}

	@Override
	public String toString() {
		return "GetOrder [orderId=" + orderId + ", orderDate=" + orderDate + ", custId=" + custId + ", custType="
				+ custType + ", isSameState=" + isSameState + ", custName=" + custName + ", gstin=" + gstin
				+ ", address=" + address + ", mobile=" + mobile + ", creditDays=" + creditDays + ", orderSubType="
				+ orderSubType + ", orderStatus=" + orderStatus + ", orderDatetime=" + orderDatetime + ", deliveryDate="
				+ deliveryDate + ", userId=" + userId + ", userName=" + userName + ", isBillGenerated="
				+ isBillGenerated + "]";
	}
    
}
