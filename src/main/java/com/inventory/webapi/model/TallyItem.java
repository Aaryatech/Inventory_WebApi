package com.inventory.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
public class TallyItem implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int id; 
	
	@Column(name = "item_code")
	private int itemCode;

	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "hsn_code")
	private String hsnCode; 
	
	@Column(name = "group_name")
	private String itemGroup;
	
    @Transient
	private String subGroup;
	
    @Transient
	private String subSubGroup;
	
	@Column(name = "cat_name")
	private String categoryName;
	
	@Column(name = "uom_name")
	private String uom;

	@Column(name = "weight")
	private float weight;
	
	@Column(name = "pack_qty")
	private int packQty; 
	
	@Column(name = "bms_min_qty")
	private int bmsMinQty;

	@Column(name = "bms_max_qty")
	private int bmsMaxQty;
	
	@Column(name = "bms_rol_qty")
	private int bmsRolQty; 
	
	@Column(name = "cgst")
	private float cgstPer;

	@Column(name = "sgst")
	private float sgstPer;
	
	@Column(name = "igst")
	private float igstPer; 
	
	@Column(name = "cess")
	private float cessPer;

	@Column(name = "store_min_qty")
	private int storeMinQty;
	
	@Column(name = "store_max_qty")
	private int storeMaxQty;

	@Column(name = "store_rol_qty")
	private int storeRolQty;
	
	@Column(name = "is_critical")
	private String isCritical;
	
	@Column(name = "image")
	private String image; 
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "is_tally_sync")
	private int isTallySync;

	@PostLoad
	public void onLoad() {
		this.subGroup="";
		this.subSubGroup="";
		if(this.isCritical=="0")
		{
			this.isCritical="LOW";
		}
		else if(this.isCritical=="1")
		{
			this.isCritical="Medium";
		}
		else
		{
			this.isCritical="HIGH";
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(String itemGroup) {
		this.itemGroup = itemGroup;
	}

	public String getCatName() {
		return categoryName;
	}

	public void setCatName(String categoryName) {
		this.categoryName = categoryName;
	}
   
	
	public String getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}

	public String getSubSubGroup() {
		return subSubGroup;
	}

	public void setSubSubGroup(String subSubGroup) {
		this.subSubGroup = subSubGroup;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getPackQty() {
		return packQty;
	}

	public void setPackQty(int packQty) {
		this.packQty = packQty;
	}

	public int getBmsMinQty() {
		return bmsMinQty;
	}

	public void setBmsMinQty(int bmsMinQty) {
		this.bmsMinQty = bmsMinQty;
	}

	public int getBmsMaxQty() {
		return bmsMaxQty;
	}

	public void setBmsMaxQty(int bmsMaxQty) {
		this.bmsMaxQty = bmsMaxQty;
	}

	public int getBmsRolQty() {
		return bmsRolQty;
	}

	public void setBmsRolQty(int bmsRolQty) {
		this.bmsRolQty = bmsRolQty;
	}

	public int getStoreMinQty() {
		return storeMinQty;
	}

	public void setStoreMinQty(int storeMinQty) {
		this.storeMinQty = storeMinQty;
	}

	public int getStoreMaxQty() {
		return storeMaxQty;
	}

	public void setStoreMaxQty(int storeMaxQty) {
		this.storeMaxQty = storeMaxQty;
	}

	public int getStoreRolQty() {
		return storeRolQty;
	}

	public void setStoreRolQty(int storeRolQty) {
		this.storeRolQty = storeRolQty;
	}

	public String getIsCritical() {
		return isCritical;
	}

	public void setIsCritical(String isCritical) {
		this.isCritical = isCritical;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
    
	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	@Override
	public String toString() {
		return "TallyItem [id=" + id + ", itemCode=" + itemCode + ", itemName=" + itemName + ", hsnCode=" + hsnCode
				+ ", itemGroup=" + itemGroup + ", subGroup=" + subGroup + ", subSubGroup=" + subSubGroup
				+ ", categoryName=" + categoryName + ", uom=" + uom + ", weight=" + weight + ", packQty=" + packQty
				+ ", bmsMinQty=" + bmsMinQty + ", bmsMaxQty=" + bmsMaxQty + ", bmsRolQty=" + bmsRolQty + ", cgstPer="
				+ cgstPer + ", sgstPer=" + sgstPer + ", igstPer=" + igstPer + ", cessPer=" + cessPer + ", storeMinQty="
				+ storeMinQty + ", storeMaxQty=" + storeMaxQty + ", storeRolQty=" + storeRolQty + ", isCritical="
				+ isCritical + ", image=" + image + ", delStatus=" + delStatus + ", isTallySync=" + isTallySync + "]";
	}

    
	
}
