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

import com.inventory.webapi.model.GrnGvnHeader;
import com.inventory.webapi.model.GrnGvnDetail;
import com.inventory.webapi.model.GrnList; 
import com.inventory.webapi.repository.GrnGvnDetailRepository;
import com.inventory.webapi.repository.GrnGvnHeaderRepository;
import com.inventory.webapi.repository.GrnListRepository; 

@RestController
public class GrnApiController {
	
	@Autowired
	GrnListRepository grnListRepository;
	
	@Autowired
	GrnGvnHeaderRepository grnGvnHeaderRepository;
	
	@Autowired
	GrnGvnDetailRepository grnGvnDetailRepository;
	
	@RequestMapping(value = { "/getItemFromPurchaseBillForGvn" }, method = RequestMethod.POST)
	public @ResponseBody GrnList getItemFromPurchaseBillForGvn(@RequestParam ("batchNo") String batchNo,@RequestParam ("suppId")int suppId,
			@RequestParam ("currentDate")String currentDate)
	{
		System.out.println("batchNo :"+batchNo); 
		GrnList getItemFromPurchaseBillForGvn = new GrnList();
		try {
			  
			getItemFromPurchaseBillForGvn = grnListRepository.getItemRecord(batchNo,suppId,currentDate);
			if(getItemFromPurchaseBillForGvn==null)
			{
				getItemFromPurchaseBillForGvn = new GrnList();
			}
			System.out.println(getItemFromPurchaseBillForGvn.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getItemFromPurchaseBillForGvn;

	}
	
	@RequestMapping(value = { "/getallExpireItemSupllierWise" }, method = RequestMethod.POST)
	public @ResponseBody List<GrnList> getallExpireItemSupllierWise(@RequestParam ("suppId")int suppId, @RequestParam ("currentDate")String currentDate)
	{ 
		
		List<GrnList> getallExpireItemSupllierWise = new ArrayList<GrnList>();
		try {
			  
			getallExpireItemSupllierWise = grnListRepository.getallExpireItemSupllierWise(suppId,currentDate);
			 
			System.out.println(getallExpireItemSupllierWise.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return getallExpireItemSupllierWise;

	}
	
	@RequestMapping(value = { "/postGrnGvn" }, method = RequestMethod.POST)
	public @ResponseBody GrnGvnHeader postGrnGvn(@RequestBody GrnGvnHeader grnGvnHeader)
	{
		System.out.println("grnGvnHeader :"+grnGvnHeader.toString()); 
		GrnGvnHeader response = new GrnGvnHeader();
		try {
			  
			response = grnGvnHeaderRepository.save(grnGvnHeader);
			if(response!=null)
			{
				for(int i=0;i<grnGvnHeader.getGrnGvnDetailList().size();i++)
					grnGvnHeader.getGrnGvnDetailList().get(i).setGrnId(response.getGrnId());
				 
				List<GrnGvnDetail> GrnGvnDetailList = grnGvnDetailRepository.saveAll(grnGvnHeader.getGrnGvnDetailList());
				response.setGrnGvnDetailList(GrnGvnDetailList);
			}
			System.out.println(response.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return response;

	}
	
	 

}
