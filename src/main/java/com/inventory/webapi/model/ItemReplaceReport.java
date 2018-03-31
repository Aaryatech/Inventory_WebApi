package com.inventory.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ItemReplaceReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pur_detail_id")
	private int purDetailId;
	
	@Column(name = "supp_id")
	private int suppId; 
	
	@Column(name = "supp_name")
	private String suppName; 
	
	@Column(name = "invoice_no")
	private String invoiceNo;

	@Column(name = "inv_date")
	private Date invDate;
	
	@Column(name = "batch_no")
	private String batchNo; 
	
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_name")
	private String itemName;
	 
	@Column(name = "replace_qty")
	private int replaceQty;

	public int getPurDetailId() {
		return purDetailId;
	}

	public void setPurDetailId(int purDetailId) {
		this.purDetailId = purDetailId;
	}

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
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

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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

	public int getReplaceQty() {
		return replaceQty;
	}

	public void setReplaceQty(int replaceQty) {
		this.replaceQty = replaceQty;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	@Override
	public String toString() {
		return "ItemReplaceReport [purDetailId=" + purDetailId + ", suppId=" + suppId + ", suppName=" + suppName
				+ ", invoiceNo=" + invoiceNo + ", invDate=" + invDate + ", batchNo=" + batchNo + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", replaceQty=" + replaceQty + "]";
	}
	
	
	

}
