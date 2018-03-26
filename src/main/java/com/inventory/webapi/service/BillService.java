package com.inventory.webapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.webapi.model.BillHeader;

@Service
public interface BillService {

	BillHeader insertBill(BillHeader billJson);

	List<BillHeader> getBillsBetweenDate(String fromDate, String toDate);

	BillHeader findBillByBillNo(int billNo);

	List<BillHeader> findBillsByBillNo(List<Integer> billNos);

}
