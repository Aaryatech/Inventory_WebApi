package com.inventory.webapi.controller;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController; 
import com.inventory.webapi.model.PurchaseHeader;
import com.inventory.webapi.model.ReplaceItem;
import com.inventory.webapi.model.TSetting;
import com.inventory.webapi.model.UnpaidPurchaseBill; 
import com.inventory.webapi.model.Info;
import com.inventory.webapi.model.PurchaseDetail;
import com.inventory.webapi.repository.PurchaseDetailRepository;
import com.inventory.webapi.repository.PurchaseHeaderRepository;
import com.inventory.webapi.repository.TSettingRepository;
import com.inventory.webapi.repository.UnpaidPurchaseBillRepository;

@RestController
public class PurchaseApiController {
	
	@Autowired
	PurchaseHeaderRepository purchaseHeaderRepository;
	
	@Autowired
	PurchaseDetailRepository purchaseDetailRepository;
	
	@Autowired
	TSettingRepository tSettingRepository;
	
	@Autowired
	UnpaidPurchaseBillRepository unpaidPurchaseBillRepository;
	
	@RequestMapping(value = { "/postPurchaseHeader" }, method = RequestMethod.POST)
	public @ResponseBody PurchaseHeader postPurchaseHeader(@RequestBody PurchaseHeader purchaseHeader)
	{
		System.out.println("purchaseHeader :"+purchaseHeader.toString()); 
		PurchaseHeader response = new PurchaseHeader();
		try {
			  
			response = purchaseHeaderRepository.save(purchaseHeader);
			
			if(response!=null)
			{
				int purchaseId = response.getPurchaseId();
				for(int i=0;i<purchaseHeader.getPurchaseDetailList().size();i++)
				{
					purchaseHeader.getPurchaseDetailList().get(i).setPurchaseId(purchaseId);
					PurchaseDetail purchaseDetail = purchaseHeader.getPurchaseDetailList().get(i);
							purchaseDetailRepository.save(purchaseDetail);
				}
				 
				response.setPurchaseDetailList(response.getPurchaseDetailList());
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return response;

	}
	
	@RequestMapping(value = { "/getPurchaseHeader" }, method = RequestMethod.POST)
	public @ResponseBody List<PurchaseHeader> getPurchaseHeader(@RequestParam ("fromDate") String fromDate,
			@RequestParam ("toDate") String toDate)
	{
		 
		List<PurchaseHeader> getPurchaseHeader = new ArrayList<PurchaseHeader>();
		try {
			  
			getPurchaseHeader = purchaseHeaderRepository.getPurchaseHeader(fromDate,toDate);
			
			 
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getPurchaseHeader;

	}
	
	@RequestMapping(value = { "/getPurchaseHeaderAndDetailWithId" }, method = RequestMethod.POST)
	public @ResponseBody PurchaseHeader getPurchaseHeaderAndDetailWithId(@RequestParam ("purchaseId") int purchaseId)
	{
		 
		PurchaseHeader getPurchaseHeaderAndDetailWithId = new PurchaseHeader();
		try {
			  
			getPurchaseHeaderAndDetailWithId = purchaseHeaderRepository.findByPurchaseId(purchaseId);
			
			List<PurchaseDetail> purchaseDetailList = purchaseDetailRepository.findByPurchaseIdAndDelStatus(purchaseId,0);
			 
			getPurchaseHeaderAndDetailWithId.setPurchaseDetailList(purchaseDetailList);
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getPurchaseHeaderAndDetailWithId;

	}
	
	
	@RequestMapping(value = { "/getSettingValueByKey" }, method = RequestMethod.POST)
	public @ResponseBody TSetting getSettingValueByKey(@RequestParam ("key") String key)
	{
		 
		TSetting getSettingValueByKey = new TSetting();
		try {
			  
			getSettingValueByKey = tSettingRepository.findBySettingKey(key);
			
			if(getSettingValueByKey!=null)
			{
				int value = getSettingValueByKey.getSettingValue()+1;
				int update = tSettingRepository.updateValue(value,getSettingValueByKey.getSettingKey());
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getSettingValueByKey;

	}
	@RequestMapping(value = { "/getUniqueSettingValue" }, method = RequestMethod.POST)
	public @ResponseBody TSetting getSettingValue(@RequestParam ("key") String key)
	{
		 
		TSetting getSettingValueByKey = new TSetting();
		try {
			  
			getSettingValueByKey = tSettingRepository.findBySettingKey(key);

		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getSettingValueByKey;

	}
	@RequestMapping(value = { "/updateTsettingKey" }, method = RequestMethod.POST)
	public @ResponseBody int updateInvoiceKey(@RequestParam ("key") String key,@RequestParam ("value") int value)
	{
		int isUpdated=0;
		try {
			isUpdated = tSettingRepository.updateValue(value,key);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
         return isUpdated;
	}
	@RequestMapping(value = { "/updateIsGrnInPurchaseDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info updateIsGrnInPurchaseDetail(@RequestParam ("grnType") int grnType,@RequestParam ("batchList") List<String> batchList)
	{
		int update=0;
		Info info = new Info();
		try {
			
			if(grnType==0)
			{
				for(int i=0;i<batchList.size();i++)
				  {
					  update = purchaseDetailRepository.updateIsGrnInPurchaseDetail(batchList.get(i));
				  }
			}
			else
			{
				for(int i=0;i<batchList.size();i++)
				  {
					  update = purchaseDetailRepository.updateReplaceQtyInPurchaseDetail(batchList.get(i));
				  }
			}
			  
				 
			if(update!=0)
			{
				info.setError(false);
				info.setMessage("updated");
			}
			else
			{
				info.setError(true);
				info.setMessage("failed");
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return info;

	}
	
	@RequestMapping(value = { "/unpaidPurchaseBillList" }, method = RequestMethod.POST)
	public @ResponseBody  List<UnpaidPurchaseBill> unpaidPurchaseBillList(@RequestParam ("currentDate") String currentDate)
	{
		List<UnpaidPurchaseBill> unpaidPurchaseBillList = new ArrayList<UnpaidPurchaseBill>();
	 
		try {
			unpaidPurchaseBillList = unpaidPurchaseBillRepository.unpaidPurchaseBillList(currentDate);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
         return unpaidPurchaseBillList;
	}
	
	@RequestMapping(value = { "/approvedIsPaidInPurchaseBill" }, method = RequestMethod.POST)
	public @ResponseBody  Info approvedIsPaidInPurchaseBill(@RequestParam ("purchaseIdList") List<String> purchaseIdList)
	{
		Info info = new Info();
	 
		try {
			int update=0;
			
			for(int i=0;i<purchaseIdList.size();i++)
			{
				int purchaseId = Integer.parseInt(purchaseIdList.get(i));
				update = purchaseHeaderRepository.updateIsPaid(purchaseId);
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
	
	
	@RequestMapping(value = { "/getItemByBatchNo" }, method = RequestMethod.POST)
	public @ResponseBody PurchaseDetail getItemByBatchNo(@RequestParam ("batchNo") String batchNo)
	{
		System.out.println("batchNo :"+batchNo); 
		PurchaseDetail purchaseDetail = new PurchaseDetail();
		try {
			  
			purchaseDetail = purchaseDetailRepository.findByBatchNoAndDelStatus(batchNo,0);
			if(purchaseDetail==null)
			{
				purchaseDetail = new PurchaseDetail();
			}
			System.out.println(purchaseDetail.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return purchaseDetail;

	}
	
	@RequestMapping(value = { "/updateReplaceQtyInPurchaseBill" }, method = RequestMethod.POST)
	public @ResponseBody Info updateReplaceQtyInPurchaseBill(@RequestBody List<ReplaceItem> replaceItemList)
	{
		Info info = new Info();
		 
		try {
			int update=0;
			for(int i=0;i<replaceItemList.size();i++)
			{
				update = purchaseDetailRepository.updateReplaceQtyInPurchaseBill(replaceItemList.get(i).getBatchNo(),replaceItemList.get(i).getTotalReplaceQty());
				 
			}
				if(update==0)
				{
					info.setError(true);
					info.setMessage("unsuccess");
				}
				else
				{
					info.setError(false);
					info.setMessage("success");
				}
			
		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage("unsuccess");
		}
        
		
		return info;

	}

}
