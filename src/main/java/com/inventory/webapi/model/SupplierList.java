package com.inventory.webapi.model;

import java.util.List;

public class SupplierList {

	List<TallySupplier> supplierList;
	
	Info info;

	public List<TallySupplier> getSupplierList() {
		return supplierList;
	}

	public void setSupplierList(List<TallySupplier> supplierList) {
		this.supplierList = supplierList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "SupplierList [supplierList=" + supplierList + ", info=" + info + "]";
	}
	
	
}
