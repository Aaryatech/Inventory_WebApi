package com.inventory.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "grn_gvn_detail")
public class GrnGvnDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_detail_id")
	private int grnDetailId; 
	   
	@Column(name = "grn_id")
	private int grnId; 
	
	@Column(name = "invoice_no")
	private String invoiceNo;
	
	@Column(name = "invoice_date")
	private Date invoiceDate;

	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "hsn_code")
	private String hsnCode; 
	
	@Column(name = "batch_no")
	private String batchNo;
	
	@Column(name = "rate")
	private float rate;

	@Column(name = "qty")
	private int qty;
	
	@Column(name = "total")
	private float total;
	
	@Column(name = "expire_date")
	private Date expireDate;

	public int getGrnDetailId() {
		return grnDetailId;
	}

	public void setGrnDetailId(int grnDetailId) {
		this.grnDetailId = grnDetailId;
	}

	public int getGrnId() {
		return grnId;
	}

	public void setGrnId(int grnId) {
		this.grnId = grnId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
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

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return "GrnGvnDetail [grnDetailId=" + grnDetailId + ", grnId=" + grnId + ", invoiceNo=" + invoiceNo
				+ ", invoiceDate=" + invoiceDate + ", itemId=" + itemId + ", itemName=" + itemName + ", hsnCode="
				+ hsnCode + ", batchNo=" + batchNo + ", rate=" + rate + ", qty=" + qty + ", total=" + total
				+ ", expireDate=" + expireDate + "]";
	}
	
	

}
