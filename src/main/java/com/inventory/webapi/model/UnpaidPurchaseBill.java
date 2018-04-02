package com.inventory.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
public class UnpaidPurchaseBill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purchase_id")
	private int purchaseId; 
	
	@Column(name = "date")
	private Date date; 
	
	@Column(name = "invoice_no")
	private String invoiceNo;

	@Column(name = "inv_date")
	private Date invDate;
	 
	@Column(name = "supp_id")
	private int suppId; 
	
	@Column(name = "supp_name")
	private String suppName;
	
	@Column(name = "bill_amt")
	private float billAmt;
	
	@Column(name = "cd_date1")
	private Date cdDate1;
	 
	@Column(name = "cd_date2")
	private Date cdDate2;
	
	@Column(name = "cd_date3")
	private Date cdDate3;
	 
	@Column(name = "cd_date4")
	private Date cdDate4;
	
	@Transient
	private int extra;

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public float getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(float billAmt) {
		this.billAmt = billAmt;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getCdDate1() {
		return cdDate1;
	}

	public void setCdDate1(Date cdDate1) {
		this.cdDate1 = cdDate1;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getCdDate2() {
		return cdDate2;
	}

	public void setCdDate2(Date cdDate2) {
		this.cdDate2 = cdDate2;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getCdDate3() {
		return cdDate3;
	}

	public void setCdDate3(Date cdDate3) {
		this.cdDate3 = cdDate3;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getCdDate4() {
		return cdDate4;
	}

	public void setCdDate4(Date cdDate4) {
		this.cdDate4 = cdDate4;
	}

	public int getExtra() {
		return extra;
	}

	public void setExtra(int extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "UnpaidPurchaseBill [purchaseId=" + purchaseId + ", date=" + date + ", invoiceNo=" + invoiceNo
				+ ", invDate=" + invDate + ", suppId=" + suppId + ", suppName=" + suppName + ", billAmt=" + billAmt
				+ ", cdDate1=" + cdDate1 + ", cdDate2=" + cdDate2 + ", cdDate3=" + cdDate3 + ", cdDate4=" + cdDate4
				+ ", extra=" + extra + "]";
	}
	
	
	
}
