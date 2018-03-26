package com.inventory.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_bill_detail")
public class BillDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_detail_id")
	private int billDetailId; 
	
	@Column(name = "bill_no")
	private int billNo; 
	
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
	
	@Column(name = "value")
	private float value; 
	
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

	
	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	public float getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(float baseRate) {
		this.baseRate = baseRate;
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

	@Override
	public String toString() {
		return "BillDetail [billDetailId=" + billDetailId + ", billNo=" + billNo + ", itemId=" + itemId + ", itemName="
				+ itemName + ", itemHsncd=" + itemHsncd + ", billQty=" + billQty + ", rate=" + rate + ", batch_no="
				+ batchNo + ", taxableAmt=" + taxableAmt + ", cgstPer=" + cgstPer + ", cgstRs=" + cgstRs + ", sgstPer="
				+ sgstPer + ", sgstRs=" + sgstRs + ", igstPer=" + igstPer + ", igstRs=" + igstRs + ", cessPer="
				+ cessPer + ", cessRs=" + cessRs + ", taxAmt=" + taxAmt + ", grandTotal=" + grandTotal + "]";
	}
	
}
