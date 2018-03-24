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

import com.inventory.webapi.model.GetCurrentStock;
import com.inventory.webapi.model.ItemStock;
import com.inventory.webapi.model.ItemStockDetail;
import com.inventory.webapi.model.StockDetail;
import com.inventory.webapi.model.StockHeader;
import com.inventory.webapi.repository.GetCurrentStockRepository;
import com.inventory.webapi.repository.ItemStockDetailRepository;
import com.inventory.webapi.repository.ItemStockRepository;
import com.inventory.webapi.repository.StockDetailRepository;
import com.inventory.webapi.repository.StockHeaderRepository;

@RestController
public class StockApiController {
	
	@Autowired
	StockHeaderRepository stockHeaderRepository;
	
	@Autowired
	StockDetailRepository stockDetailRepository;
	
	@Autowired
	ItemStockRepository itemStockRepository;
	
	@Autowired
	ItemStockDetailRepository itemStockDetailRepository;
	
	@Autowired
	GetCurrentStockRepository getCurrentStockRepository;
	
	@RequestMapping(value = { "/insertStock" }, method = RequestMethod.POST)
	public @ResponseBody StockHeader insertStock(@RequestBody StockHeader stockHeader)
	{
		System.out.println("stockHeader :"+stockHeader.toString()); 
		StockHeader response = new StockHeader();
		try {
			  
			response = stockHeaderRepository.save(stockHeader);
			
			if(response!=null)
			{
				int stockId = response.getStockId();
				for(int i=0;i<stockHeader.getStockDetailList().size();i++) 
					stockHeader.getStockDetailList().get(i).setStockId(stockId);
				
				List<StockDetail> stockDetail = stockDetailRepository.saveAll(stockHeader.getStockDetailList());
			  
				response.setStockDetailList(stockDetail);
			}
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return response;

	}
	
	@RequestMapping(value = { "/getStock" }, method = RequestMethod.GET)
	public @ResponseBody StockHeader getStock()
	{
		 
		StockHeader getStock = new StockHeader();
		try {
			  int status = 0;
			getStock = stockHeaderRepository.findByStatus(status);
			
			if(getStock==null)
			{
				 getStock = new StockHeader();
			}
			 
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return getStock;

	}
	
	@RequestMapping(value = { "/getStockDetailForUpdate" }, method = RequestMethod.POST)
	public @ResponseBody List<StockDetail> getStockDetailForUpdate(@RequestParam ("stockId") int stockId)
	{
		 
		List<StockDetail> getStockDetailForUpdate = new ArrayList<StockDetail>();
		try {
			 
			getStockDetailForUpdate = stockDetailRepository.findByStockId(stockId); 
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return getStockDetailForUpdate;

	}
	
	@RequestMapping(value = { "/getStockDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemStockDetail> getStockDetail(@RequestParam ("stockId") int stockId)
	{
		 
		List<ItemStockDetail> stockDetail = new ArrayList<ItemStockDetail>();
		try {
			 
				 stockDetail = itemStockDetailRepository.getDetailed(stockId); 
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return stockDetail;

	}
	
	@RequestMapping(value = { "/getFirstTimeItemStock" }, method = RequestMethod.GET)
	public @ResponseBody List<ItemStock> getFirstTimeItemStock()
	{
		 
		List<ItemStock> itemStockList = new ArrayList<ItemStock>();
		try {
			 
			  itemStockList = itemStockRepository.getFirstTimeItemStock();
			
			  
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return itemStockList;

	}
	
	
	@RequestMapping(value = { "/getCurrentStock" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStock> getCurrentStock(@RequestParam ("date") String date)
	{
		 
		List<GetCurrentStock> getCurrentStock = new ArrayList<GetCurrentStock>();
		try {
			 
			getCurrentStock = getCurrentStockRepository.getCurrentStock(date);
			
			  
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return getCurrentStock;
		
	}
	
	@RequestMapping(value = { "/getStockBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCurrentStock> getStockBetween(@RequestParam ("fromDate") String fromDate,@RequestParam ("toDate") String toDate,
			@RequestParam ("catId") int catId)
	{
		 
		List<GetCurrentStock> getStockBetween = new ArrayList<GetCurrentStock>();
		try {
			 
			getStockBetween = getCurrentStockRepository.getStockBetween(fromDate,toDate,catId);
			
			  
		} catch (Exception e) {

			e.printStackTrace();
		}
         
		return getStockBetween;
		 
		
	}

}
