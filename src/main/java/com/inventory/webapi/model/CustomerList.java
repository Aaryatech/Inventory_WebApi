package com.inventory.webapi.model;

import java.util.List;

public class CustomerList {

	List<TallyCustomer> customerList;
	
	Info info;

	

	public List<TallyCustomer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<TallyCustomer> customerList) {
		this.customerList = customerList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "CustomerList [customerList=" + customerList + ", info=" + info + "]";
	}

	
}
