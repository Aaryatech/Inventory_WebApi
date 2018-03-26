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
public class GetOrderDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_detail_id")
	private int orderDetailId; 
	
	@Column(name = "order_date")
	private Date orderDate; 
	
	@Column(name = "order_id")
	private int orderId; 
	
	@Column(name = "item_id")
	private int itemId; 
	
	@Column(name = "item_name")
	private String itemName; 
	
	@Column(name = "uom_id")
	private int uomId; 
	
	@Column(name = "uom_name")
	private String uomName; 
	
	@Column(name = "hsn_code")
	private String hsnCode; 
	
	@Column(name = "weight")
	private float weight; 
	
	@Column(name = "order_qty")
	private int orderQty;

	public int getOrderDetailId() {
		return orderDetailId;
	}

	
	public int getUomId() {
		return uomId;
	}


	public void setUomId(int uomId) {
		this.uomId = uomId;
	}


	public String getUomName() {
		return uomName;
	}


	public void setUomName(String uomName) {
		this.uomName = uomName;
	}


	public String getHsnCode() {
		return hsnCode;
	}


	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}


	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOrderDate() {
		return orderDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	@Override
	public String toString() {
		return "GetOrderDetail [orderDetailId=" + orderDetailId + ", orderDate=" + orderDate + ", orderId=" + orderId
				+ ", itemId=" + itemId + ", itemName=" + itemName + ", orderQty=" + orderQty + "]";
	}
	
}
