package com.inventory.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.webapi.common.Common;
import com.inventory.webapi.model.ItemWisePurchase;
import com.inventory.webapi.model.PurchaseReport;
import com.inventory.webapi.repository.ItemWisePurchaseRepository;
import com.inventory.webapi.repository.PurchaseReportRepository; 

@RestController
@RequestMapping("/purchaseReport")
public class PurchaseReportApiController {
	
	@Autowired
	PurchaseReportRepository purchaseReportRepository;
	
	@Autowired
	ItemWisePurchaseRepository itemWisePurchaseRepository;
	
	@RequestMapping(value = { "/billwisePurchaseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<PurchaseReport> billwisePurchaseReport( @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,
			@RequestParam("suppId") List<Integer> suppId) {
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<PurchaseReport> billwisePurchaseReport=new ArrayList<PurchaseReport>();
		try {
			if(suppId.get(0)==0)
				billwisePurchaseReport=purchaseReportRepository.billwisePurchaseReport(fromDate,toDate);
			else
				billwisePurchaseReport=purchaseReportRepository.billwisePurchaseReport(fromDate,toDate,suppId);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return billwisePurchaseReport;
	  }
	
	@RequestMapping(value = { "/datewisePurchaseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<PurchaseReport> datewisePurchaseReport( @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,
			@RequestParam("suppId") List<Integer> suppId) {
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<PurchaseReport> datewisePurchaseReport=new ArrayList<PurchaseReport>();
		try {
			if(suppId.get(0)==0)
				datewisePurchaseReport=purchaseReportRepository.datewisePurchaseReport(fromDate,toDate);
			else
				datewisePurchaseReport=purchaseReportRepository.datewisePurchaseReport(fromDate,toDate,suppId);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return datewisePurchaseReport;
	  }
	
	@RequestMapping(value = { "/supplierwisePurchaseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<PurchaseReport> supplierwisePurchaseReport( @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,
			@RequestParam("suppId") List<Integer> suppId) {
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<PurchaseReport> supplierwisePurchaseReport=new ArrayList<PurchaseReport>();
		try {
			if(suppId.get(0)==0)
				supplierwisePurchaseReport=purchaseReportRepository.supplierwisePurchaseReport(fromDate,toDate);
			else
				supplierwisePurchaseReport=purchaseReportRepository.supplierwisePurchaseReport(fromDate,toDate,suppId);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return supplierwisePurchaseReport;
	  }
	
	@RequestMapping(value = { "/monthwisePurchaseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<PurchaseReport> monthwisePurchaseReport( @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,
			@RequestParam("suppId") List<Integer> suppId) {
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<PurchaseReport> monthwisePurchaseReport=new ArrayList<PurchaseReport>();
		try {
			if(suppId.get(0)==0)
				monthwisePurchaseReport=purchaseReportRepository.monthwisePurchaseReport(fromDate,toDate);
			else
				monthwisePurchaseReport=purchaseReportRepository.monthwisePurchaseReport(fromDate,toDate,suppId);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return monthwisePurchaseReport;
	  }
	
	@RequestMapping(value = { "/itemwisePurchaseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemWisePurchase> itemwisePurchaseReport( @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,
			@RequestParam("itemId") List<Integer> itemId) {
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<ItemWisePurchase> itemwisePurchaseReport=new ArrayList<ItemWisePurchase>();
		try {
			if(itemId.get(0)==0)
				itemwisePurchaseReport=itemWisePurchaseRepository.itemwisePurchaseReport(fromDate,toDate);
			else
				itemwisePurchaseReport=itemWisePurchaseRepository.itemwisePurchaseReport(fromDate,toDate,itemId);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return itemwisePurchaseReport;
	  }

}
