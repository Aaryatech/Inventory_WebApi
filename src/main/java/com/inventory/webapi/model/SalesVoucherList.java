package com.inventory.webapi.model;

import java.util.List;

public class SalesVoucherList {

	List<TallyBill> salesBillList;
	
	Info info;

    
	public List<TallyBill> getSalesBillList() {
		return salesBillList;
	}

	public void setSalesBillList(List<TallyBill> salesBillList) {
		this.salesBillList = salesBillList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "SalesVoucherList [salesBillList=" + salesBillList + ", info=" + info + "]";
	}
	
	
}
