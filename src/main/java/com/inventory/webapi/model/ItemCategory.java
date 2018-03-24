package com.inventory.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_item_category")
public class ItemCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private int catId; 
	
	@Column(name = "cat_name")
	private String catName;

	@Column(name = "group_id")
	private int groupId;
	
	@Column(name = "cat_desc")
	private String catDesc;
	
	@Column(name = "del_status")
	private int delStatus;

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "ItemCategory [catId=" + catId + ", catName=" + catName + ", groupId=" + groupId + ", catDesc=" + catDesc
				+ ", delStatus=" + delStatus + "]";
	}
	
	

}
