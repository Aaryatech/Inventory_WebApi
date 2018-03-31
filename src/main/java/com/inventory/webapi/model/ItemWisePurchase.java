package com.inventory.webapi.model;
  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemWisePurchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pur_detail_id")
	private int purDetailId; 
	     
	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_name")
	private String itemName;
	 
	@Column(name = "rec_qty")
	private int recQty; 
	
	@Column(name = "disc_amt")
	private float discAmt;
	
	@Column(name = "freight_amt")
	private float freightAmt;

	@Column(name = "insu_amt")
	private float insuAmt;
	 
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

	@Column(name = "total")
	private float total;
	
	@Column(name = "other_extra")
	private float otherExtra;

	public int getPurDetailId() {
		return purDetailId;
	}

	public void setPurDetailId(int purDetailId) {
		this.purDetailId = purDetailId;
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

	public int getRecQty() {
		return recQty;
	}

	public void setRecQty(int recQty) {
		this.recQty = recQty;
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getOtherExtra() {
		return otherExtra;
	}

	public void setOtherExtra(float otherExtra) {
		this.otherExtra = otherExtra;
	}

	@Override
	public String toString() {
		return "ItemWisePurchase [purDetailId=" + purDetailId + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", recQty=" + recQty + ", discAmt=" + discAmt + ", freightAmt=" + freightAmt + ", insuAmt=" + insuAmt
				+ ", taxableAmt=" + taxableAmt + ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst + ", cess="
				+ cess + ", total=" + total + ", otherExtra=" + otherExtra + "]";
	}
	
	

}
