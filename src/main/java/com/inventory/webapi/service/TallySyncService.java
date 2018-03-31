package com.inventory.webapi.service;

import org.springframework.stereotype.Service;

import com.inventory.webapi.model.CustomerList;
import com.inventory.webapi.model.Info;
import com.inventory.webapi.model.ItemList;
import com.inventory.webapi.model.PurchaseBillList;
import com.inventory.webapi.model.SalesVoucherList;
import com.inventory.webapi.model.SupplierList;

@Service
public interface TallySyncService {

	ItemList getAllItems();

	CustomerList getAllCustomers();

	SupplierList getAllSuppliers();

	Info updateItems(int id, int isTallySync);

	Info updateSupplier(int id, int isTallySync);

	Info updateCustomer(int id, int isTallySync);

	SalesVoucherList getAllSalesVoucher();

	PurchaseBillList getAllPurchaseBill();

	Info updateSalesVoucher(int billNo, int isTallySync);

	Info updatePurchaseBill(int purchaseId, int isTallySync);

}
