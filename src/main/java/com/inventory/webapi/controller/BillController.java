package com.inventory.webapi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.inventory.webapi.common.Common;
import com.inventory.webapi.model.BillDetail;
import com.inventory.webapi.model.BillHeader;
import com.inventory.webapi.model.Info;
import com.inventory.webapi.model.PurchaseDetail;
import com.inventory.webapi.model.PurchaseHeader;
import com.inventory.webapi.repository.BillDetailRepository;
import com.inventory.webapi.repository.BillHeaderRepository;
import com.inventory.webapi.repository.PurchaseDetailRepository;
import com.inventory.webapi.repository.PurchaseHeaderRepository;
import com.inventory.webapi.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	BillService billService;
	
	@Autowired
	PurchaseHeaderRepository purchaseHeaderRepository;
	
	@Autowired
	PurchaseDetailRepository purchaseDetailRepository;
	
	@Autowired
	BillHeaderRepository billHeaderRepository;
	@Autowired
	BillDetailRepository billDetailRepository;
	//------------------------------------- BILL---------------------------------
		@RequestMapping(value = { "/insertBill" }, method = RequestMethod.POST)
		public @ResponseBody BillHeader placeItemOrder(@RequestBody BillHeader billJson)
				throws ParseException, JsonParseException, JsonMappingException, IOException {

			BillHeader jsonResult = billService.insertBill(billJson);

			return jsonResult;
		}
		//-----------------------------END-------------------------------------------------------------
		@RequestMapping(value = { "/getItemBatches" }, method = RequestMethod.GET)
		public @ResponseBody List<PurchaseDetail> getItemBatches()
		{
			List<PurchaseDetail> purchaseDetailList=null;
			try {
				 
			 purchaseDetailList = purchaseDetailRepository.findBatchesOfItem();
				 
			} catch (Exception e) {
				purchaseDetailList=new ArrayList<PurchaseDetail>();
				e.printStackTrace();
			}
			
			return purchaseDetailList;

		}
		@RequestMapping(value = { "/findBillsBetweenDate" }, method = RequestMethod.POST)
		public @ResponseBody List<BillHeader> getBillsBetweenDate( @RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			List<BillHeader> billHeaders=billService.getBillsBetweenDate(fromDate,toDate);
			    
			return billHeaders;
		  }
		
		@RequestMapping(value = { "/findBillsByBillNo" }, method = RequestMethod.POST)
		public @ResponseBody List<BillHeader> findBillsByBillNo( @RequestParam("billNos") List<Integer> billNos) {
		
			List<BillHeader> billHeaders=billService.findBillsByBillNo(billNos);
			    
			return billHeaders;
		  }
		@RequestMapping(value = { "/findBillDetailByBillNo" }, method = RequestMethod.POST)
		public @ResponseBody List<BillDetail> findBillDetailByBillNo(@RequestParam("billNo") int billNo) {

			List<BillDetail> billDetailRes=billDetailRepository.findByBillNo(billNo);
			    
			return billDetailRes;
		  }
		@RequestMapping(value = { "/findBillByBillNo" }, method = RequestMethod.POST)
		public @ResponseBody BillHeader findBillByBillNo(@RequestParam("billNo") int billNo) {

			BillHeader billHeaderRes=billService.findBillByBillNo(billNo);
			    
			return billHeaderRes;
		  }

		@RequestMapping(value = { "/postPurchaseDetails" }, method = RequestMethod.POST)
		public @ResponseBody Info postPurchaseDetails(@RequestBody List<PurchaseDetail> batchList)
		{
			System.out.println("purchaseDetails :"+batchList.toString()); 
			List<PurchaseDetail> response = new ArrayList<>();
			Info info=null;
			try {
				  
				response = purchaseDetailRepository.saveAll(batchList);
				info=new Info();
			    if(response!=null)
			    {
			    	
			    	info.setError(false);
			    	info.setMessage("Purchase Details Updated Successfully");
			    }
			    else
			    {
			    	info.setError(true);
			    	info.setMessage("Purchase Details Updation Failed");
			    }
				 
			} catch (Exception e) {
				info=new Info();
				info.setError(true);
		    	info.setMessage("Purchase Details Updation Failed");
				e.printStackTrace();
			}
			return info;
		}
		@RequestMapping(value = { "/approvedPaidInSaleBill" }, method = RequestMethod.POST)
		public @ResponseBody  Info approvedPaidInSaleBill(@RequestParam ("billNoList") List<String> billNoList)
		{
			Info info = new Info();
		 
			try {
				int update=0;
				
				for(int i=0;i<billNoList.size();i++)
				{
					int billNo = Integer.parseInt(billNoList.get(i));
					update = billHeaderRepository.updateBillStatus(billNo);
				}
				
				if(update==0)
				{
					info.setError(true);
					info.setMessage("not update");
				}
					
				
			} catch (Exception e) {
				e.printStackTrace();
				info.setError(true);
				info.setMessage("not update");
			}
	         return info;
		}

		
}
