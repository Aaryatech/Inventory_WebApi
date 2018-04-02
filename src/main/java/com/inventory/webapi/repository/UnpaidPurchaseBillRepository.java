package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.UnpaidPurchaseBill;

public interface UnpaidPurchaseBillRepository extends JpaRepository<UnpaidPurchaseBill, Integer>{

	
	@Query(value="select h.purchase_id,h.date,h.invoice_no,h.inv_date,h.supp_id,s.supp_name,h.bill_amt,h.cd_date1,h.cd_date2,h.cd_date3,h.cd_date4 \r\n" + 
			"from t_purchase_header h,supplier s\r\n" + 
			"where h.cd_date1<=:currentDate and h.is_paid=1 and h.supp_id = s.supp_id",nativeQuery=true) 
	List<UnpaidPurchaseBill> unpaidPurchaseBillList(@Param("currentDate")String currentDate);
	
	

}
