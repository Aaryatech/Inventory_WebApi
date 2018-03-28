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
import com.inventory.webapi.model.BillDetail;
import com.inventory.webapi.model.BillHeader;
import com.inventory.webapi.repository.BillDetailRepository;
import com.inventory.webapi.repository.BillHeaderRepository;
import com.inventory.webapi.service.BillService;

@RestController
@RequestMapping("/report")
public class ReportsController {
	
	@Autowired
	BillService billService; 
	@Autowired
	BillHeaderRepository billHeaderRepository;
	@Autowired
	BillDetailRepository billDetailRepository;
	
	@RequestMapping(value = { "/findSaleGroupByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<BillHeader> findSaleGroupByDate( @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<BillHeader> billHeaders=new ArrayList<>();
		try {
		 billHeaders=billHeaderRepository.findByInvoiceDateInAndGroupByInvoiceDate(fromDate,toDate);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return billHeaders;
	  }
	
	@RequestMapping(value = { "/findSaleGroupByMonth" }, method = RequestMethod.POST)
	public @ResponseBody List<BillHeader> findSaleGroupByMonth( @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<BillHeader> billHeaders=new ArrayList<>();
		try {
		 billHeaders=billHeaderRepository.findSaleGroupByMonth(fromDate,toDate);
		}
		catch (Exception e) {
			e.printStackTrace();
		}    
		return billHeaders;
	  }
	@RequestMapping(value = { "/findSaleItemAndHsnCodeWise" }, method = RequestMethod.POST)
	public @ResponseBody List<BillDetail> findSaleItemAndHsnCodeWise(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<BillDetail> billDetails=new ArrayList<>();
		try {
		 billDetails=billDetailRepository.findSaleItemAndHsnCodeWise(fromDate,toDate);
		}
		catch (Exception e) {
			e.printStackTrace();
		}    
		return billDetails;
	  }
	@RequestMapping(value = { "/findUnpaidBills" }, method = RequestMethod.GET)
	public @ResponseBody List<BillHeader> findUnpaidBills() {
	
		List<BillHeader> billHeaders=new ArrayList<>();
		try {
		 billHeaders=billHeaderRepository.findUnpaidBills();
		}
		catch (Exception e) {
			e.printStackTrace();
		}    
		return billHeaders;
	  }
}
