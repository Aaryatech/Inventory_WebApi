package com.inventory.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;


@Entity
public class TallyBill implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_detail_id")
	private int billDetailId; 
	
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
	private String custType;
	
	@Column(name = "item_id")
	private int itemId; 
	
	@Column(name = "item_name")
	private String itemName; 
	
	@Column(name = "item_hsncd")
	private String itemHsncd; 
	
	@Column(name = "item_uom")
	private String itemUom; 
	
	@Column(name = "bill_qty")
	private int billQty; 
	
	@Column(name = "rate")
	private float rate; 
	
	@Column(name = "base_rate")
	private float baseRate; 
	
	@Column(name = "batch_no")
	private String batchNo; 
	
	@Column(name = "taxable_amt")
	private float taxableAmt; 
	
	@Column(name = "disc_amt")
	private float discAmt; 

	@Column(name = "cgst_per")
	private float cgstPer; 
	
	@Column(name = "cgst_rs")
	private float cgstRs; 
	
	@Column(name = "sgst_per")
	private float sgstPer; 
	
	@Column(name = "sgst_rs")
	private float sgstRs; 
	
	@Column(name = "igst_per")
	private float igstPer; 
	
	@Column(name = "igst_rs")
	private float igstRs; 
	
	@Column(name = "cess_per")
	private float cessPer; 
	
	@Column(name = "cess_rs")
	private float cessRs; 
	
	@Column(name = "tax_amt")
	private float taxAmt;
	
	@Column(name = "grand_total")
	private float grandTotal;
	
	@Column(name = "total_taxable_amt")
	private float totalTaxableAmt;
	
	@Column(name = "total_cgst")
	private float totalCgst;
	
	@Column(name = "total_sgst")
	private float totalSgst;
	
	@Column(name = "total_igst")
	private float totalIgst;
	
	@Column(name = "total_cess")
	private float totalCess;
	
	@Column(name = "total_tax_amt")
	private float totaTaxAmt;
	
	@Column(name = "total_grand_amt")
	private float totalGrandAmt;
	
	@Column(name = "bill_discount_per")
	private float billDiscountPer;
	
	@Column(name = "total_discount_amt")
	private float totalDiscountAmt;
	
	@Column(name = "total_paid_amt")
	private float totalPaidAmt;
	
	@Column(name = "total_remaining_amt")
	private float totalRemainingAmt;
	
	@Column(name = "bill_status")
	private String billStatus;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "expiry_date")
	private Date expiryDate;

	@PostLoad
	public void onLoad() {
	
		if(this.custType.equals("1"))
		{
			this.custType="Wholesaler";
		}
		else if(this.custType.equals("2"))
		{
			this.custType="Retailer";
		}

		if(this.billStatus.equals("1"))
		{
			this.billStatus="Paid";
		}
		else if(this.billStatus.equals("2"))
		{
			this.billStatus="Unpaid";
		}
	}
	
	
	public int getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
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

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
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

	public String getItemHsncd() {
		return itemHsncd;
	}

	public void setItemHsncd(String itemHsncd) {
		this.itemHsncd = itemHsncd;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	public int getBillQty() {
		return billQty;
	}

	public void setBillQty(int billQty) {
		this.billQty = billQty;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(float baseRate) {
		this.baseRate = baseRate;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}


	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getCgstRs() {
		return cgstRs;
	}

	public void setCgstRs(float cgstRs) {
		this.cgstRs = cgstRs;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getSgstRs() {
		return sgstRs;
	}

	public void setSgstRs(float sgstRs) {
		this.sgstRs = sgstRs;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getIgstRs() {
		return igstRs;
	}

	public void setIgstRs(float igstRs) {
		this.igstRs = igstRs;
	}

	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	public float getCessRs() {
		return cessRs;
	}

	public void setCessRs(float cessRs) {
		this.cessRs = cessRs;
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

	public float getTotalTaxableAmt() {
		return totalTaxableAmt;
	}

	public void setTotalTaxableAmt(float totalTaxableAmt) {
		this.totalTaxableAmt = totalTaxableAmt;
	}

	public float getTotalCgst() {
		return totalCgst;
	}

	public void setTotalCgst(float totalCgst) {
		this.totalCgst = totalCgst;
	}

	public float getTotalSgst() {
		return totalSgst;
	}

	public void setTotalSgst(float totalSgst) {
		this.totalSgst = totalSgst;
	}

	public float getTotalIgst() {
		return totalIgst;
	}

	public void setTotalIgst(float totalIgst) {
		this.totalIgst = totalIgst;
	}

	public float getTotalCess() {
		return totalCess;
	}

	public void setTotalCess(float totalCess) {
		this.totalCess = totalCess;
	}

	public float getTotaTaxAmt() {
		return totaTaxAmt;
	}

	public void setTotaTaxAmt(float totaTaxAmt) {
		this.totaTaxAmt = totaTaxAmt;
	}

	
	public float getTotalGrandAmt() {
		return totalGrandAmt;
	}


	public void setTotalGrandAmt(float totalGrandAmt) {
		this.totalGrandAmt = totalGrandAmt;
	}


	public float getBillDiscountPer() {
		return billDiscountPer;
	}

	public void setBillDiscountPer(float billDiscountPer) {
		this.billDiscountPer = billDiscountPer;
	}

	public float getTotalDiscountAmt() {
		return totalDiscountAmt;
	}

	public void setTotalDiscountAmt(float totalDiscountAmt) {
		this.totalDiscountAmt = totalDiscountAmt;
	}

	public float getTotalPaidAmt() {
		return totalPaidAmt;
	}

	public void setTotalPaidAmt(float totalPaidAmt) {
		this.totalPaidAmt = totalPaidAmt;
	}

	public float getTotalRemainingAmt() {
		return totalRemainingAmt;
	}

	public void setTotalRemainingAmt(float totalRemainingAmt) {
		this.totalRemainingAmt = totalRemainingAmt;
	}

	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "TallyBill [billDetailId=" + billDetailId + ", billNo=" + billNo + ", invoiceNo=" + invoiceNo
				+ ", invoiceDate=" + invoiceDate + ", custId=" + custId + ", custName=" + custName + ", gstin=" + gstin
				+ ", custType=" + custType + ", itemId=" + itemId + ", itemName=" + itemName + ", itemHsncd="
				+ itemHsncd + ", itemUom=" + itemUom + ", billQty=" + billQty + ", rate=" + rate + ", baseRate="
				+ baseRate + ", batchNo=" + batchNo + ", taxableAmt=" + taxableAmt + ", discAmt=" + discAmt + " cgstPer=" + cgstPer + ", cgstRs=" + cgstRs + ", sgstPer=" + sgstPer + ", sgstRs=" + sgstRs
				+ ", igstPer=" + igstPer + ", igstRs=" + igstRs + ", cessPer=" + cessPer + ", cessRs=" + cessRs
				+ ", taxAmt=" + taxAmt + ", grandTotal=" + grandTotal + ", totalTaxableAmt=" + totalTaxableAmt
				+ ", totalCgst=" + totalCgst + ", totalSgst=" + totalSgst + ", totalIgst=" + totalIgst + ", totalCess="
				+ totalCess + ", totaTaxAmt=" + totaTaxAmt + ", totalGrandTotal=" + totalGrandAmt
				+ ", billDiscountPer=" + billDiscountPer + ", totalDiscountAmt=" + totalDiscountAmt + ", totalPaidAmt="
				+ totalPaidAmt + ", totalRemainingAmt=" + totalRemainingAmt + ", billStatus=" + billStatus + ", remark="
				+ remark + ", expiryDate=" + expiryDate + "]";
	}
	
	
}
