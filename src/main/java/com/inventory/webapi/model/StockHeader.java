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
@Table(name = "t_stock_header")
public class StockHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stock_id")
	private int stockId; 
	
	@Column(name = "date")
	private Date date;

	@Column(name = "status")
	private int status;
	
	@Transient
	private List<StockDetail> stockDetailList;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

	public List<StockDetail> getStockDetailList() {
		return stockDetailList;
	}

	public void setStockDetailList(List<StockDetail> stockDetailList) {
		this.stockDetailList = stockDetailList;
	}

	@Override
	public String toString() {
		return "StockHeader [stockId=" + stockId + ", date=" + date + ", status=" + status + ", stockDetailList="
				+ stockDetailList + "]";
	}
	
	
	 
}
