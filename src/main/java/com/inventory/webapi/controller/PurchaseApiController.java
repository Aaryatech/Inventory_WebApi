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
import com.inventory.webapi.model.TSetting;
import com.inventory.webapi.model.Info;
import com.inventory.webapi.model.PurchaseDetail;
import com.inventory.webapi.repository.PurchaseDetailRepository;
import com.inventory.webapi.repository.PurchaseHeaderRepository;
import com.inventory.webapi.repository.TSettingRepository;

@RestController
public class PurchaseApiController {
	
	@Autowired
	PurchaseHeaderRepository purchaseHeaderRepository;
	
	@Autowired
	PurchaseDetailRepository purchaseDetailRepository;
	
	@Autowired
	TSettingRepository tSettingRepository;
	
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
	public @ResponseBody Info updateIsGrnInPurchaseDetail(@RequestParam ("batchList") List<String> batchList)
	{
		int update=0;
		Info info = new Info();
		try {
			  for(int i=0;i<batchList.size();i++)
			  {
				  update = purchaseDetailRepository.updateIsGrnInPurchaseDetail(batchList.get(i));
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

}
