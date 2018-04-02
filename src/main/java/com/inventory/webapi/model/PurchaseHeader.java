package com.inventory.webapi.model;

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
@Table(name = "t_purchase_header")
public class PurchaseHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purchase_id")
	private int purchaseId; 
	
	@Column(name = "purchase_no")
	private String purchaseNo;

	@Column(name = "date")
	private Date date;
	
	@Column(name = "time")
	private String time; 
	
	@Column(name = "vehicle_no")
	private String vehicleNo;

	@Column(name = "supp_id")
	private int suppId;
	
	@Column(name = "invoice_no")
	private String invoiceNo;

	@Column(name = "inv_date")
	private Date invDate;
	
	@Column(name = "basic_value")
	private float basicValue; 
	
	@Column(name = "disc_per")
	private float discPer;

	@Column(name = "disc_amt")
	private float discAmt;
	
	@Column(name = "disc_amt2")
	private float discAmt2; 
	
	@Column(name = "freight_amt")
	private float freightAmt;

	@Column(name = "insurance_amt")
	private float insuranceAmt;
	
	@Column(name = "cgst")
	private float cgst; 
	
	@Column(name = "sgst")
	private float sgst;
	
	@Column(name = "igst")
	private float igst;

	@Column(name = "cess")
	private float cess;
	
	@Column(name = "taxable_amt")
	private float taxableAmt;

	@Column(name = "bill_amt")
	private float billAmt;
	
	@Column(name = "round_off")
	private float roundOff; 
	
	@Column(name = "other_extra")
	private float otherExtra; 
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "cd_date1")
	private Date cdDate1;
	
	@Column(name = "cd_date2")
	private Date cdDate2;
	
	@Column(name = "cd_date3")
	private Date cdDate3;
	
	@Column(name = "cd_date4")
	private Date cdDate4;
	
	@Column(name = "is_paid")
	private int isPaid;
	
	@Transient
	private List<PurchaseDetail> purchaseDetailList;
	
	
	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
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

	public float getBasicValue() {
		return basicValue;
	}

	public void setBasicValue(float basicValue) {
		this.basicValue = basicValue;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getDiscAmt2() {
		return discAmt2;
	}

	public void setDiscAmt2(float discAmt2) {
		this.discAmt2 = discAmt2;
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

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(float billAmt) {
		this.billAmt = billAmt;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public float getOtherExtra() {
		return otherExtra;
	}

	public void setOtherExtra(float otherExtra) {
		this.otherExtra = otherExtra;
	}
 
	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public List<PurchaseDetail> getPurchaseDetailList() {
		return purchaseDetailList;
	}

	public void setPurchaseDetailList(List<PurchaseDetail> purchaseDetailList) {
		this.purchaseDetailList = purchaseDetailList;
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

	public int getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(int isPaid) {
		this.isPaid = isPaid;
	}

	@Override
	public String toString() {
		return "PurchaseHeader [purchaseId=" + purchaseId + ", purchaseNo=" + purchaseNo + ", date=" + date + ", time="
				+ time + ", vehicleNo=" + vehicleNo + ", suppId=" + suppId + ", invoiceNo=" + invoiceNo + ", invDate="
				+ invDate + ", basicValue=" + basicValue + ", discPer=" + discPer + ", discAmt=" + discAmt
				+ ", discAmt2=" + discAmt2 + ", freightAmt=" + freightAmt + ", insuranceAmt=" + insuranceAmt + ", cgst="
				+ cgst + ", sgst=" + sgst + ", igst=" + igst + ", cess=" + cess + ", taxableAmt=" + taxableAmt
				+ ", billAmt=" + billAmt + ", roundOff=" + roundOff + ", otherExtra=" + otherExtra + ", delStatus="
				+ delStatus + ", cdDate1=" + cdDate1 + ", cdDate2=" + cdDate2 + ", cdDate3=" + cdDate3 + ", cdDate4="
				+ cdDate4 + ", isPaid=" + isPaid + ", purchaseDetailList=" + purchaseDetailList + "]";
	}
	
	

}
