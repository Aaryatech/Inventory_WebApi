package com.inventory.webapi.model;

import java.util.List;

public class PurchaseBillList {

	List<PurchaseBill> purchaseBillList;
	
	Info info;

	public List<PurchaseBill> getPurchaseBillList() {
		return purchaseBillList;
	}

	public void setPurchaseBillList(List<PurchaseBill> purchaseBillList) {
		this.purchaseBillList = purchaseBillList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "PurchaseBillList [info=" + info + "]";
	}
	
	
}
