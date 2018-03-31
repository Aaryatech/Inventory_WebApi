package com.inventory.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.webapi.model.CustomerList;
import com.inventory.webapi.model.Info;
import com.inventory.webapi.model.ItemList;
import com.inventory.webapi.model.ItemMaster;
import com.inventory.webapi.model.PurchaseBill;
import com.inventory.webapi.model.PurchaseBillList;
import com.inventory.webapi.model.SalesVoucherList;
import com.inventory.webapi.model.SupplierList;
import com.inventory.webapi.model.TallyBill;
import com.inventory.webapi.model.TallyCustomer;
import com.inventory.webapi.model.TallyItem;
import com.inventory.webapi.model.TallySupplier;
import com.inventory.webapi.repository.ItemMasterRepository;
import com.inventory.webapi.repository.TallyBillRepository;
import com.inventory.webapi.repository.TallyCustomerRepository;
import com.inventory.webapi.repository.TallyCustomerUpdateRepository;
import com.inventory.webapi.repository.TallyItemRepository;
import com.inventory.webapi.repository.TallyItemUpdateRepository;
import com.inventory.webapi.repository.TallyPurchaseBillRepository;
import com.inventory.webapi.repository.TallyPurchaseBillUpdateRepository;
import com.inventory.webapi.repository.TallySaleBillUpdateRepository;
import com.inventory.webapi.repository.TallySupplierRepository;
import com.inventory.webapi.repository.TallyUpdateSupplierRepository;

@Service
public class TallySyncServiceImpl implements TallySyncService{

	@Autowired
	TallyItemRepository tallyItemRepository;
	
	@Autowired
	TallyCustomerRepository tallyCustomerRepository;
	
	@Autowired
	TallySupplierRepository tallySupplierRepository;
	
	@Autowired
	ItemMasterRepository itemMasterRepository;
	
	@Autowired
	TallyItemUpdateRepository tallyItemUpdateRepository;
	
	@Autowired
	TallyUpdateSupplierRepository tallyUpdateSupplierRepository ;
	
	@Autowired
	TallyCustomerUpdateRepository tallyCustomerUpdateRepository;
	
	@Autowired
	TallyBillRepository tallyBillRepository;
	
	@Autowired
	TallyPurchaseBillRepository tallyPurchaseBillRepository;
	
	@Autowired
	TallyPurchaseBillUpdateRepository tallyPurchaseBillUpdateRepository;
	
	@Autowired
	TallySaleBillUpdateRepository tallySaleBillUpdateRepository;
	
	@Override
	public ItemList getAllItems() {
		  List<TallyItem> itemList=tallyItemRepository.findByIsTallySync();
			
			ItemList allItemList=new ItemList();
			Info info=new Info();
			
			if(itemList==null)
			{
			
				info.setError(true);
				info.setMessage("Items Not Found");
				
			    allItemList.setInfo(info);	
			}
			else
			{
				info.setError(false);
				info.setMessage("Items Found Successfully");
				
				allItemList.setItemList(itemList);
	            allItemList.setInfo(info);	
			}
			
			return allItemList;	
			
	}

	@Override
	public CustomerList getAllCustomers() {
		
		  List<TallyCustomer> custList=tallyCustomerRepository.findByIsTallySync();
			
			CustomerList allCustList=new CustomerList();
			Info info=new Info();
			
			if(custList==null)
			{
			
				info.setError(true);
				info.setMessage("Items Not Found");
				
				allCustList.setInfo(info);	
			}
			else
			{
				info.setError(false);
				info.setMessage("Items Found Successfully");
				
				allCustList.setCustomerList(custList);
				allCustList.setInfo(info);	
			}
			
			return allCustList;	
			
	}

	@Override
	public SupplierList getAllSuppliers() {
		 List<TallySupplier> supplierList=tallySupplierRepository.findAllByDelStatusAndIsTallySync(0,0);
			
		    SupplierList allSupplierList=new SupplierList();
			Info info=new Info();
			
			if(supplierList==null)
			{
			
				info.setError(true);
				info.setMessage("Supplier Not Found");
				
				allSupplierList.setInfo(info);	
			}
			else
			{
				info.setError(false);
				info.setMessage("Supplier Found Successfully");
				
				allSupplierList.setSupplierList(supplierList);
				allSupplierList.setInfo(info);	
			}
			
			return allSupplierList;	
	}

	@Override
	public Info updateItems(int id, int isTallySync) {
		Info info=new Info();

		int isUpdated=tallyItemUpdateRepository.updateItem(id,isTallySync);
		if(isUpdated>0) {
		
			info.setError(false);
			info.setMessage("Items Updated Successfully");
		}
		else
		{
			info.setError(false);
			info.setMessage("Items Updation Failed");
			
		}
		return info;
		
	}

	@Override
	public Info updateSupplier(int id, int isTallySync) {
		Info info=new Info();
	
	int i=tallyUpdateSupplierRepository.updateSupplier(id,isTallySync);
	if(i==1) {
	
		info.setError(false);
		info.setMessage("Supplier Updated Successfully");
	}
	else
	{
		info.setError(false);
		info.setMessage("Supplier Updation Failed");
		
	}
	return info;
	}

	@Override
	public Info updateCustomer(int id, int isTallySync) {
		Info info=new Info();
		
		int i=tallyCustomerUpdateRepository.updateCustomer(id,isTallySync);
		if(i==1) {
		
			info.setError(false);
			info.setMessage("Customer Updated Successfully");
		}
		else
		{
			info.setError(false);
			info.setMessage("Customer Updation Failed");
			
		}
		return info;
	}

	@Override
	public SalesVoucherList getAllSalesVoucher() {
		  List<TallyBill> saleBillList=tallyBillRepository.findByIsTallySync();
			
		  SalesVoucherList allSales=new SalesVoucherList();
				Info info=new Info();
				
				if(saleBillList==null)
				{
				
					info.setError(true);
					info.setMessage("SalesVoucher Not Found");
					
					allSales.setInfo(info);	
				}
				else
				{
					info.setError(false);
					info.setMessage("SalesVoucher Found Successfully");
					
					allSales.setTallyBillList(saleBillList);
					allSales.setInfo(info);	
				}
				
				return allSales;	
	}

	@Override
	public PurchaseBillList getAllPurchaseBill() {
		
		 List<PurchaseBill> purchaseBilllList=tallyPurchaseBillRepository.findByIsTallySync();
			
		 PurchaseBillList purchaseList=new PurchaseBillList();
				Info info=new Info();
				
				if(purchaseBilllList==null)
				{
				
					info.setError(true);
					info.setMessage("Purchase Bill Not Found");
					
					purchaseList.setInfo(info);	
				}
				else
				{
					info.setError(false);
					info.setMessage("Purchase Bill Found Successfully");
					
					purchaseList.setPurchaseBillList(purchaseBilllList);
					purchaseList.setInfo(info);	
				}
				
				return purchaseList;	
	}

	@Override
	public Info updateSalesVoucher(int billNo, int isTallySync) {
    Info info=new Info();
		
		int i=tallySaleBillUpdateRepository.updateSalesVoucher(billNo,isTallySync);
		if(i==1) {
		
			info.setError(false);
			info.setMessage("SalesVoucher Updated Successfully");
		}
		else
		{
			info.setError(false);
			info.setMessage("SalesVoucher Updation Failed");
			
		}
		return info;
	}

	@Override
	public Info updatePurchaseBill(int purchaseId, int isTallySync) {
Info info=new Info();
		
		int i=tallyPurchaseBillUpdateRepository.updatePurchaseBill(purchaseId,isTallySync);
		if(i==1) {
		
			info.setError(false);
			info.setMessage("PurchaseBill Updated Successfully");
		}
		else
		{
			info.setError(false);
			info.setMessage("PurchaseBill Updation Failed");
			
		}
		return info;
	}

	
	
}
