package com.inventory.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat; 

@Entity 
public class GrnList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pur_detail_id")
	private int purDetailId; 
	
	@Column(name = "purchase_id")
	private int purchaseId; 
	
	@Column(name = "invoice_no")
	private String invoiceNo;

	@Column(name = "inv_date")
	private Date invDate;
	
	@Column(name = "item_id")
	private int itemId; 
	
	@Column(name = "supp_id")
	private int suppId; 
	
	@Column(name = "supp_name")
	private String suppName;
	
	@Column(name = "batch_no")
	private String batchNo;
	
	@Column(name = "item_name")
	private String itemName;
	 
	@Column(name = "hsn_code")
	private String hsnCode;
	
	@Column(name = "balance")
	private int balance;
	
	@Column(name = "rate_with_tax")
	private float rateWithTax;
	
	@Column(name = "expiry_date")
	private Date expiryDate;

	public int getPurDetailId() {
		return purDetailId;
	}

	public void setPurDetailId(int purDetailId) {
		this.purDetailId = purDetailId;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public float getRateWithTax() {
		return rateWithTax;
	}

	public void setRateWithTax(float rateWithTax) {
		this.rateWithTax = rateWithTax;
	}

	
	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "GrnList [purDetailId=" + purDetailId + ", purchaseId=" + purchaseId + ", invoiceNo=" + invoiceNo
				+ ", invDate=" + invDate + ", itemId=" + itemId + ", suppId=" + suppId + ", suppName=" + suppName
				+ ", batchNo=" + batchNo + ", itemName=" + itemName + ", hsnCode=" + hsnCode + ", balance=" + balance
				+ ", rateWithTax=" + rateWithTax + ", expiryDate=" + expiryDate + "]";
	}
	
	

}
