package com.inventory.webapi.model;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_purchase_detail")
public class PurchaseDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pur_detail_id")
	private int purDetailId;
	
	@Column(name = "purchase_id")
	private int purchaseId; 
	
	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_uom")
	private String itemUom; 
	
	@Column(name = "rec_qty")
	private int recQty;

	@Column(name = "rate")
	private float rate;
	
	@Column(name = "base_rate")
	private float baseRate;

	@Column(name = "value")
	private float value;
	
	@Column(name = "disc_per")
	private float discPer; 
	
	@Column(name = "disc_amt")
	private float discAmt;

	@Column(name = "freight_amt")
	private float freightAmt;
	
	@Column(name = "insu_amt")
	private float insuAmt; 
	
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
	
	@Column(name = "taxable_amt")
	private float taxableAmt; 
	
	@Column(name = "total")
	private float total; 
	
	@Column(name = "round_off")
	private float roundOff;

	@Column(name = "disc_on_bill")
	private float discOnBill;
	
	@Column(name = "other_extra")
	private float otherExtra;

	@Column(name = "batch_no")
	private String batchNo;
	
	@Column(name = "sell_qty")
	private int sellQty;
	
	@Column(name = "balance")
	private int balance;
	
	@Column(name = "rate_without_tax")
	private float rateWithoutTax; 
	
	@Column(name = "rate_with_tax")
	private float rateWithTax;

	@Column(name = "wholesale_rate")
	private float wholesaleRate;
	
	@Column(name = "retail_rate")
	private float retailRate;
	
	@Column(name = "del_status")
	private int delStatus;

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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
 
	public String getItemUom() {
		return itemUom;
	}

	public void setItemUom(String itemUom) {
		this.itemUom = itemUom;
	}

	public int getRecQty() {
		return recQty;
	}

	public void setRecQty(int recQty) {
		this.recQty = recQty;
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

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
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

	public float getFreightAmt() {
		return freightAmt;
	}

	public void setFreightAmt(float freightAmt) {
		this.freightAmt = freightAmt;
	}

	public float getInsuAmt() {
		return insuAmt;
	}

	public void setInsuAmt(float insuAmt) {
		this.insuAmt = insuAmt;
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

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public float getDiscOnBill() {
		return discOnBill;
	}

	public void setDiscOnBill(float discOnBill) {
		this.discOnBill = discOnBill;
	}

	public float getOtherExtra() {
		return otherExtra;
	}

	public void setOtherExtra(float otherExtra) {
		this.otherExtra = otherExtra;
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

	public int getSellQty() {
		return sellQty;
	}

	public void setSellQty(int sellQty) {
		this.sellQty = sellQty;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public float getRateWithoutTax() {
		return rateWithoutTax;
	}

	public void setRateWithoutTax(float rateWithoutTax) {
		this.rateWithoutTax = rateWithoutTax;
	}

	public float getRateWithTax() {
		return rateWithTax;
	}

	public void setRateWithTax(float rateWithTax) {
		this.rateWithTax = rateWithTax;
	}

	public float getWholesaleRate() {
		return wholesaleRate;
	}

	public void setWholesaleRate(float wholesaleRate) {
		this.wholesaleRate = wholesaleRate;
	}

	public float getRetailRate() {
		return retailRate;
	}

	public void setRetailRate(float retailRate) {
		this.retailRate = retailRate;
	}
 

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "PurchaseDetail [purDetailId=" + purDetailId + ", purchaseId=" + purchaseId + ", itemName=" + itemName
				+ ", itemId=" + itemId + ", itemUom=" + itemUom + ", recQty=" + recQty + ", rate=" + rate
				+ ", baseRate=" + baseRate + ", value=" + value + ", discPer=" + discPer + ", discAmt=" + discAmt
				+ ", freightAmt=" + freightAmt + ", insuAmt=" + insuAmt + ", cgstPer=" + cgstPer + ", cgstRs=" + cgstRs
				+ ", sgstPer=" + sgstPer + ", sgstRs=" + sgstRs + ", igstPer=" + igstPer + ", igstRs=" + igstRs
				+ ", cessPer=" + cessPer + ", cessRs=" + cessRs + ", taxableAmt=" + taxableAmt + ", total=" + total
				+ ", roundOff=" + roundOff + ", discOnBill=" + discOnBill + ", otherExtra=" + otherExtra + ", batchNo="
				+ batchNo + ", sellQty=" + sellQty + ", balance=" + balance + ", rateWithoutTax=" + rateWithoutTax
				+ ", rateWithTax=" + rateWithTax + ", wholesaleRate=" + wholesaleRate + ", retailRate=" + retailRate
				+ ", delStatus=" + delStatus + "]";
	}
	
	
	

}
