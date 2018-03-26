package com.inventory.webapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_order_header")
public class Order implements Serializable{

	@Transient
	private boolean isError;
	@Transient
	private String message;
	
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
	
	@Column(name = "is_bill_generated")
	private int isBillGenerated;

	
	@Transient
	List<OrderDetail> orderDetail;
	
	
	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
   
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIsBillGenerated() {
		return isBillGenerated;
	}

	public void setIsBillGenerated(int isBillGenerated) {
		this.isBillGenerated = isBillGenerated;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", custId=" + custId
				+ ", custType=" + custType + ", orderSubType=" + orderSubType + ", orderStatus=" + orderStatus
				+ ", orderDatetime=" + orderDatetime + ", deliveryDate=" + deliveryDate + ", userId=" + userId
				+ ", isBillGenerated=" + isBillGenerated + "]";
	} 
	
	
}
