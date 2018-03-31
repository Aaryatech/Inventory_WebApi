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
public class PurchaseBill implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pur_detail_id")
	private int purDetailId;
	
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
	
	@Column(name = "supp_name")
	private String supplierName;
	
	@Column(name = "invoice_no")
	private String invoiceNo;

	@Column(name = "inv_date")
	private Date invoiceDate;
	
	
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

	@Column(name = "is_grn")
	private String isGrn;

	@Column(name = "expiry_date")
	private Date expiryDate;
	
	@Column(name = "replace_qty")
	private int replaceQty;
	
	@Column(name = "total_value")
	private float totalValue; 
	
	@Column(name = "total_disc_per")
	private float totalDiscPer;

	@Column(name = "total_disc_amt")
	private float totalDiscAmt;
	
	@Column(name = "total_disc_amt2")
	private float totalDiscAmt2; 
	
	@Column(name = "total_freight_amt")
	private float totalFreightAmt;

	@Column(name = "total_insurance_amt")
	private float totalInsuranceAmt;
	
	@Column(name = "total_cgst")
	private float totalCgst; 
	
	@Column(name = "total_sgst")
	private float totalSgst;
	
	@Column(name = "total_igst")
	private float totalIgst;

	@Column(name = "total_cess")
	private float totalCess;
	
	@Column(name = "total_taxable_amt")
	private float totalTaxableAmt;

	@Column(name = "total_bill_amt")
	private float totalBillAmt;
	
	@Column(name = "total_round_off")
	private float totalRoundOff; 
	
	@Column(name = "total_other_extra")
	private float totalOtherExtra; 
	
	@Column(name = "pay_deadline1")
	private Date payDeadline1;
	
	@Column(name = "pay_deadline2")
	private Date payDeadline2;
	
	@Column(name = "pay_deadline3")
	private Date payDeadline3;
	
	@Column(name = "pay_deadline4")
	private Date payDeadline4;
	
	@Column(name = "is_bill_paid")
	private String isBillPaid;

	@PostLoad
	public void onLoad() {
		if(isGrn.equalsIgnoreCase("1"))
		{
			this.isGrn="YES";
		}else 
		{
			this.isGrn="No";
		}
		
		if(isBillPaid.equalsIgnoreCase("2"))
		{
			this.isBillPaid="YES";
		}else
		{
			this.isBillPaid="No";
		}
	}
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

	public String getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

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

	

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	public String getIsGrn() {
		return isGrn;
	}

	public void setIsGrn(String isGrn) {
		this.isGrn = isGrn;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getReplaceQty() {
		return replaceQty;
	}

	public void setReplaceQty(int replaceQty) {
		this.replaceQty = replaceQty;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	public float getTotalDiscPer() {
		return totalDiscPer;
	}

	public void setTotalDiscPer(float totalDiscPer) {
		this.totalDiscPer = totalDiscPer;
	}

	public float getTotalDiscAmt() {
		return totalDiscAmt;
	}

	public void setTotalDiscAmt(float totalDiscAmt) {
		this.totalDiscAmt = totalDiscAmt;
	}

	public float getTotalDiscAmt2() {
		return totalDiscAmt2;
	}

	public void setTotalDiscAmt2(float totalDiscAmt2) {
		this.totalDiscAmt2 = totalDiscAmt2;
	}

	public float getTotalFreightAmt() {
		return totalFreightAmt;
	}

	public void setTotalFreightAmt(float totalFreightAmt) {
		this.totalFreightAmt = totalFreightAmt;
	}

	public float getTotalInsuranceAmt() {
		return totalInsuranceAmt;
	}

	public void setTotalInsuranceAmt(float totalInsuranceAmt) {
		this.totalInsuranceAmt = totalInsuranceAmt;
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

	public float getTotalTaxableAmt() {
		return totalTaxableAmt;
	}

	public void setTotalTaxableAmt(float totalTaxableAmt) {
		this.totalTaxableAmt = totalTaxableAmt;
	}

	public float getTotalBillAmt() {
		return totalBillAmt;
	}

	public void setTotalBillAmt(float totalBillAmt) {
		this.totalBillAmt = totalBillAmt;
	}

	public float getTotalRoundOff() {
		return totalRoundOff;
	}

	public void setTotalRoundOff(float totalRoundOff) {
		this.totalRoundOff = totalRoundOff;
	}

	public float getTotalOtherExtra() {
		return totalOtherExtra;
	}

	public void setTotalOtherExtra(float totalOtherExtra) {
		this.totalOtherExtra = totalOtherExtra;
	}

	public Date getPayDeadline1() {
		return payDeadline1;
	}

	public void setPayDeadline1(Date payDeadline1) {
		this.payDeadline1 = payDeadline1;
	}

	public Date getPayDeadline2() {
		return payDeadline2;
	}

	public void setPayDeadline2(Date payDeadline2) {
		this.payDeadline2 = payDeadline2;
	}

	public Date getPayDeadline3() {
		return payDeadline3;
	}

	public void setPayDeadline3(Date payDeadline3) {
		this.payDeadline3 = payDeadline3;
	}

	public Date getPayDeadline4() {
		return payDeadline4;
	}

	public void setPayDeadline4(Date payDeadline4) {
		this.payDeadline4 = payDeadline4;
	}

	public String getIsBillPaid() {
		return isBillPaid;
	}

	public void setIsBillPaid(String isBillPaid) {
		this.isBillPaid = isBillPaid;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	@Override
	public String toString() {
		return "PurchaseBill [purDetailId=" + purDetailId + ", purchaseId=" + purchaseId + ", purchaseNo=" + purchaseNo
				+ ", date=" + date + ", time=" + time + ", vehicleNo=" + vehicleNo + ", suppId=" + suppId
				+ ", supplierName=" + supplierName + ", invoiceNo=" + invoiceNo + ", invoiceDate=" + invoiceDate
				+ ", itemName=" + itemName + ", itemId=" + itemId + ", itemUom=" + itemUom + ", recQty=" + recQty
				+ ", rate=" + rate + ", baseRate=" + baseRate + ", value=" + value + ", discPer=" + discPer
				+ ", discAmt=" + discAmt + ", freightAmt=" + freightAmt + ", insuAmt=" + insuAmt + ", cgstPer="
				+ cgstPer + ", cgstRs=" + cgstRs + ", sgstPer=" + sgstPer + ", sgstRs=" + sgstRs + ", igstPer="
				+ igstPer + ", igstRs=" + igstRs + ", cessPer=" + cessPer + ", cessRs=" + cessRs + ", taxableAmt="
				+ taxableAmt + ", total=" + total + ", roundOff=" + roundOff + ", discOnBill=" + discOnBill
				+ ", otherExtra=" + otherExtra + ", batchNo=" + batchNo + ", sellQty=" + sellQty + ", balance="
				+ balance + ", rateWithoutTax=" + rateWithoutTax + ", rateWithTax=" + rateWithTax + ", wholesaleRate="
				+ wholesaleRate + ", retailRate=" + retailRate + ", isGrn=" + isGrn + ", expiryDate=" + expiryDate
				+ ", replaceQty=" + replaceQty + ", totalValue=" + totalValue + ", totalDiscPer=" + totalDiscPer
				+ ", totalDiscAmt=" + totalDiscAmt + ", totalDiscAmt2=" + totalDiscAmt2 + ", totalFreightAmt="
				+ totalFreightAmt + ", totalInsuranceAmt=" + totalInsuranceAmt + ", totalCgst=" + totalCgst
				+ ", totalSgst=" + totalSgst + ", totalIgst=" + totalIgst + ", totalCess=" + totalCess
				+ ", totalTaxableAmt=" + totalTaxableAmt + ", totalBillAmt=" + totalBillAmt + ", totalRoundOff="
				+ totalRoundOff + ", totalOtherExtra=" + totalOtherExtra + ", payDeadline1=" + payDeadline1
				+ ", payDeadline2=" + payDeadline2 + ", payDeadline3=" + payDeadline3 + ", payDeadline4=" + payDeadline4
				+ ", isBillPaid=" + isBillPaid + "]";
	}
    

	
}
