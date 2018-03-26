package com.inventory.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.webapi.model.BillDetail;
import com.inventory.webapi.model.BillHeader;
import com.inventory.webapi.repository.BillDetailRepository;
import com.inventory.webapi.repository.BillHeaderRepository;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	BillHeaderRepository billHeaderRepository;
	
	@Autowired
	BillDetailRepository billDetailRepository;
	
	@Override
	public BillHeader insertBill(BillHeader billJson) {

		BillHeader billHeader=null;
		List<BillDetail> billDetailList=new ArrayList<BillDetail>(); 
		try {
			
			 billHeader=billHeaderRepository.saveAndFlush(billJson);
			
			for(int i=0;i<billHeader.getBillDetailList().size();i++)
			{
				billHeader.getBillDetailList().get(i).setBillNo(billHeader.getBillNo());	
			
			    BillDetail billDetails=billDetailRepository.saveAndFlush(billHeader.getBillDetailList().get(i));
			    billDetailList.add(billDetails);
			}
			billHeader.setBillDetailList(billDetailList);
			
		}catch (Exception e) {
			billHeader=new BillHeader();
			e.printStackTrace();
		}
		
		
		return billHeader;
	}

	@Override
	public List<BillHeader> getBillsBetweenDate(String fromDate, String toDate) {
		 List<BillHeader> billHeaderRes=null;
		try {
	        billHeaderRes=billHeaderRepository.findBillsBetweenDate(fromDate,toDate);
	        
	        for(BillHeader billHeader:billHeaderRes)
	        {
			      List<BillDetail> billDetails=billDetailRepository.findByBillNo(billHeader.getBillNo());

			      billHeader.setBillDetailList(billDetails);
	        	
	        }
		}
		catch (Exception e) {
			billHeaderRes=new ArrayList<BillHeader>();
			e.printStackTrace();
		}
		return billHeaderRes;
	}

	@Override
	public BillHeader findBillByBillNo(int billNo) {
		
		BillHeader billHeaderRes=null;
		try {
		      billHeaderRes=billHeaderRepository.findByBillNo(billNo);
		  
		      List<BillDetail> billDetails=billDetailRepository.findByBillNo(billNo);
		      
		      billHeaderRes.setBillDetailList(billDetails);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return billHeaderRes;
	}

	@Override
	public List<BillHeader> findBillsByBillNo(List<Integer> billNos) {
		 List<BillHeader> billHeaderRes=null;
			try {
				
		        billHeaderRes=billHeaderRepository.findByBillNoIn(billNos);
		        
		        for(BillHeader billHeader:billHeaderRes)
		        {
				      List<BillDetail> billDetails=billDetailRepository.findByBillNo(billHeader.getBillNo());

				      billHeader.setBillDetailList(billDetails);
		        	
		        }
			}
			catch (Exception e) {
				billHeaderRes=new ArrayList<BillHeader>();
				e.printStackTrace();
			}
			return billHeaderRes;
	}

}
