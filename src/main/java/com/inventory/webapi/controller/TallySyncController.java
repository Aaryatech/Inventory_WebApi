package com.inventory.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.webapi.model.CustomerList;
import com.inventory.webapi.model.Info;
import com.inventory.webapi.model.ItemList;
import com.inventory.webapi.model.JsonUtil;
import com.inventory.webapi.model.PurchaseBillList;
import com.inventory.webapi.model.SalesVoucherList;
import com.inventory.webapi.model.SupplierList;
import com.inventory.webapi.service.TallySyncService;

@RestController
@RequestMapping("/tally")
public class TallySyncController {

	@Autowired
	TallySyncService tallyService;

	@RequestMapping(value = { "/getAllItems" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> showAllItem() {

		ItemList itemList = tallyService.getAllItems();

		String regData = JsonUtil.javaToJson(itemList);

		byte[] output = regData.getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		responseHeaders.setContentLength(output.length);

		responseHeaders.set("Content-disposition", "attachment; filename=allItems.json");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);

	}

	@RequestMapping(value = { "/getAllCustomers" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> getAllCustomers() {

		CustomerList customerList = tallyService.getAllCustomers();

		String regData = JsonUtil.javaToJson(customerList);

		byte[] output = regData.getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		responseHeaders.setContentLength(output.length);

		responseHeaders.set("Content-disposition", "attachment; filename=allCustomers.json");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);

	}

	@RequestMapping(value = { "/getAllSuppliers" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> getAllSuppliers() {

		SupplierList supplierList = tallyService.getAllSuppliers();

		String regData = JsonUtil.javaToJson(supplierList);

		byte[] output = regData.getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		responseHeaders.setContentLength(output.length);

		responseHeaders.set("Content-disposition", "attachment; filename=allSuppliers.json");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);

	}

	@RequestMapping(value = { "/updateItems" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> updateItems(@RequestParam("id") int id,
			@RequestParam("isTallySync") int isTallySync) {

		Info info = tallyService.updateItems(id, isTallySync);

		String regData = JsonUtil.javaToJson(info);

		byte[] output = regData.getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		responseHeaders.setContentLength(output.length);

		responseHeaders.set("Content-disposition", "attachment; filename=updateItems.json");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = { "/updateSupplier" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> updateSupplier(@RequestParam("suppId") int id,
			@RequestParam("isTallySync") int isTallySync) {

		Info info = tallyService.updateSupplier(id, isTallySync);

		String regData = JsonUtil.javaToJson(info);

		byte[] output = regData.getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		responseHeaders.setContentLength(output.length);

		responseHeaders.set("Content-disposition", "attachment; filename=updateSupplier.json");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = { "/updateCustomer" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> updateCustomer(@RequestParam("custId") int id,
			@RequestParam("isTallySync") int isTallySync) {

		Info info = tallyService.updateCustomer(id, isTallySync);

		String regData = JsonUtil.javaToJson(info);

		byte[] output = regData.getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		responseHeaders.setContentLength(output.length);

		responseHeaders.set("Content-disposition", "attachment; filename=updateCustomer.json");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = { "/getAllSalesVouchers" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> showAllSalesVoucher() {

		SalesVoucherList salesVoucherList = tallyService.getAllSalesVoucher();

		String regData = JsonUtil.javaToJson(salesVoucherList);

		byte[] output = regData.getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		responseHeaders.setContentLength(output.length);

		responseHeaders.set("Content-disposition", "attachment; filename=allSalesVouchers.json");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = { "/getAllPurchaseBill" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> getAllPurchaseBill() {

		PurchaseBillList purchaseBillList = tallyService.getAllPurchaseBill();

		String regData = JsonUtil.javaToJson(purchaseBillList);

		byte[] output = regData.getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		responseHeaders.setContentLength(output.length);

		responseHeaders.set("Content-disposition", "attachment; filename=allPurchaseBills.json");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = { "/updateSalesVoucher" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> updateSalesVoucher(@RequestParam("bill_no") int billNo,
			@RequestParam("isTallySync") int isTallySync) {

		Info info = tallyService.updateSalesVoucher(billNo, isTallySync);

		String regData = JsonUtil.javaToJson(info);

		byte[] output = regData.getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		responseHeaders.setContentLength(output.length);

		responseHeaders.set("Content-disposition", "attachment; filename=updateSalesVoucher.json");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}
	@RequestMapping(value = { "/updatePurchaseBill" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> updatePurchaseBill(@RequestParam("purchaseId") int purchaseId,
			@RequestParam("isTallySync") int isTallySync) {

		Info info = tallyService.updatePurchaseBill(purchaseId, isTallySync);

		String regData = JsonUtil.javaToJson(info);

		byte[] output = regData.getBytes();

		HttpHeaders responseHeaders = new HttpHeaders();

		responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		responseHeaders.setContentLength(output.length);

		responseHeaders.set("Content-disposition", "attachment; filename=updatePurchaseBill.json");

		return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	}
}
