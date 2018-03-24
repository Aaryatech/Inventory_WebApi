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
@Table(name = "grn_gvn")
public class GrnGvnHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_id")
	private int grnId; 
	 
	@Column(name = "date")
	private Date date;
	
	@Column(name = "supp_id")
	private int suppId; 
	
	@Column(name = "gstn_no")
	private String gstnNo;

	@Column(name = "del_status")
	private int delStatus;
	 
	@Transient
	private List<GrnGvnDetail> grnGvnDetailList;

	public int getGrnId() {
		return grnId;
	}

	public void setGrnId(int grnId) {
		this.grnId = grnId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public String getGstnNo() {
		return gstnNo;
	}

	public void setGstnNo(String gstnNo) {
		this.gstnNo = gstnNo;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public List<GrnGvnDetail> getGrnGvnDetailList() {
		return grnGvnDetailList;
	}

	public void setGrnGvnDetailList(List<GrnGvnDetail> grnGvnDetailList) {
		this.grnGvnDetailList = grnGvnDetailList;
	}

	@Override
	public String toString() {
		return "GrnGvnHeader [grnId=" + grnId + ", date=" + date + ", suppId=" + suppId + ", gstnNo=" + gstnNo
				+ ", delStatus=" + delStatus + ", grnGvnDetailList=" + grnGvnDetailList + "]";
	}
	
	
}
