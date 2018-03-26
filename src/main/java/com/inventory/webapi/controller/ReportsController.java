package com.inventory.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.webapi.common.Common;
import com.inventory.webapi.model.BillHeader;
import com.inventory.webapi.repository.BillHeaderRepository;
import com.inventory.webapi.service.BillService;

@RestController
@RequestMapping("/report")
public class ReportsController {
	
	@Autowired
	BillService billService; 
	@Autowired
	BillHeaderRepository billHeaderRepository;
	
	@RequestMapping(value = { "/findSaleOrderByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<BillHeader> findSaleOrderByDate( @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<BillHeader> billHeaders=billHeaderRepository.findByInvoiceDateInAndGroupByInvoiceDate(fromDate,toDate);
		    
		return billHeaders;
	  }

}
