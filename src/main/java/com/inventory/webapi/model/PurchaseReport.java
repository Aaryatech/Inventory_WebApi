package com.inventory.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PurchaseReport {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purchase_id")
	private int purchaseId; 
	   
	@Column(name = "invoice_no")
	private String invoiceNo;

	@Column(name = "inv_date")
	private Date invDate;
	
	@Column(name = "supp_id")
	private int suppId;
	
	@Column(name = "supp_name")
	private String suppName;
	 
	@Column(name = "disc_amt")
	private float discAmt; 
	
	@Column(name = "freight_amt")
	private float freightAmt;

	@Column(name = "insurance_amt")
	private float insuranceAmt;
	 
	@Column(name = "taxable_amt")
	private float taxableAmt;
	
	@Column(name = "cgst")
	private float cgst; 
	
	@Column(name = "sgst")
	private float sgst;
	
	@Column(name = "igst")
	private float igst;

	@Column(name = "cess")
	private float cess;

	@Column(name = "bill_amt")
	private float billAmt;
	
	@Column(name = "other_extra")
	private float otherExtra;

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

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getFreightAmt() {
		return freightAmt;
	}

	public void setFreightAmt(float freightAmt) {
		this.freightAmt = freightAmt;
	}

	public float getInsuranceAmt() {
		return insuranceAmt;
	}

	public void setInsuranceAmt(float insuranceAmt) {
		this.insuranceAmt = insuranceAmt;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getCess() {
		return cess;
	}

	public void setCess(float cess) {
		this.cess = cess;
	}

	public float getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(float billAmt) {
		this.billAmt = billAmt;
	}

	public float getOtherExtra() {
		return otherExtra;
	}

	public void setOtherExtra(float otherExtra) {
		this.otherExtra = otherExtra;
	}

	@Override
	public String toString() {
		return "PurchaseReport [purchaseId=" + purchaseId + ", invoiceNo=" + invoiceNo + ", invDate=" + invDate
				+ ", suppId=" + suppId + ", suppName=" + suppName + ", discAmt=" + discAmt + ", freightAmt="
				+ freightAmt + ", insuranceAmt=" + insuranceAmt + ", taxableAmt=" + taxableAmt + ", cgst=" + cgst
				+ ", sgst=" + sgst + ", igst=" + igst + ", cess=" + cess + ", billAmt=" + billAmt + ", otherExtra="
				+ otherExtra + "]";
	}
	
	

}
