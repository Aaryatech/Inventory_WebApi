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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_bill_header")
public class BillHeader implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_no")
	private int billNo; 
	
	@Column(name = "invoice_no")
	private String invoiceNo; 
	
	@Column(name = "invoice_date")
	private Date invoiceDate; 
	
	@Column(name = "cust_id")
	private int custId;
	
	@Column(name = "cust_name")
	private String custName; 
	
	@Column(name = "gstin")
	private String gstin;
	
	@Column(name = "cust_type")
	private int custType;
	
	@Column(name = "taxable_amt")
	private float taxableAmt;
	
	private float cgstRs;
	
	private float sgstRs;
	
	private float igstRs;
	
	private float cessRs;
	
	@Column(name = "tax_amt")
	private float taxAmt;
	
	@Column(name = "grand_total")
	private float grandTotal;
	
	@Column(name = "discount_per")
	private float discountPer;
	
	@Column(name = "discount_amt")
	private float discountAmt;
	
	@Column(name = "paid_amt")
	private float paidAmt;
	
	@Column(name = "rem_amt")
	private float remAmt;
	
	@Column(name = "bill_status")
	private int billStatus;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "expiry_date")
	private Date expiryDate;

	@Transient
	List<BillDetail> billDetailList;
	
	
	
	public float getDiscountPer() {
		return discountPer;
	}

	public void setDiscountPer(float discountPer) {
		this.discountPer = discountPer;
	}

	public float getCgstRs() {
		return cgstRs;
	}

	public void setCgstRs(float cgstRs) {
		this.cgstRs = cgstRs;
	}

	public float getSgstRs() {
		return sgstRs;
	}

	public void setSgstRs(float sgstRs) {
		this.sgstRs = sgstRs;
	}

	public float getIgstRs() {
		return igstRs;
	}

	public void setIgstRs(float igstRs) {
		this.igstRs = igstRs;
	}

	public float getCessRs() {
		return cessRs;
	}

	public void setCessRs(float cessRs) {
		this.cessRs = cessRs;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public List<BillDetail> getBillDetailList() {
		return billDetailList;
	}

	public void setBillDetailList(List<BillDetail> billDetailList) {
		this.billDetailList = billDetailList;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
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

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public int getCustType() {
		return custType;
	}

	public void setCustType(int custType) {
		this.custType = custType;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public float getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(float discountAmt) {
		this.discountAmt = discountAmt;
	}

	public float getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(float paidAmt) {
		this.paidAmt = paidAmt;
	}

	public float getRemAmt() {
		return remAmt;
	}

	public void setRemAmt(float remAmt) {
		this.remAmt = remAmt;
	}

	public int getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(int billStatus) {
		this.billStatus = billStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		return "BillHeader [billNo=" + billNo + ", invoiceNo=" + invoiceNo + ", invoiceDate=" + invoiceDate
				+ ", custId=" + custId + ", custName=" + custName + ", gstin=" + gstin + ", custType=" + custType
				+ ", taxableAmt=" + taxableAmt + ", cgstRs=" + cgstRs + ", sgstRs=" + sgstRs + ", igstRs=" + igstRs
				+ ", cessRs=" + cessRs + ", taxAmt=" + taxAmt + ", grandTotal=" + grandTotal + ", discountPer="
				+ discountPer + ", discountAmt=" + discountAmt + ", paidAmt=" + paidAmt + ", remAmt=" + remAmt
				+ ", billStatus=" + billStatus + ", remark=" + remark + ", expiryDate=" + expiryDate
				+ ", billDetailList=" + billDetailList + "]";
	}

    
}
