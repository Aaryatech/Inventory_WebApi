package com.inventory.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_uom")
public class ItemUom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uom_id")
	private int uomId; 
	
	@Column(name = "uom_name")
	private String uomName;

	@Column(name = "del_status")
	private int delStatus;

	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "ItemUom [uomId=" + uomId + ", uomName=" + uomName + ", delStatus=" + delStatus + "]";
	} 
	
	

}
