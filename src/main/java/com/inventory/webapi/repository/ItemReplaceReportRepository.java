package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.webapi.model.ItemReplaceReport;

public interface ItemReplaceReportRepository extends JpaRepository<ItemReplaceReport, Integer>{

	
	@Query(value="select\r\n" + 
			"    d.pur_detail_id,\r\n" + 
			"    h.supp_id,\r\n" + 
			"    s.supp_name,\r\n" + 
			"    h.invoice_no,\r\n" + 
			"    h.inv_date,\r\n" + 
			"    d.batch_no,\r\n" + 
			"    d.item_id,\r\n" + 
			"    d.item_name, \r\n" + 
			"    d.replace_qty\r\n" + 
			"from \r\n" + 
			"    t_purchase_detail d,\r\n" + 
			"    t_purchase_header h,\r\n" + 
			"    supplier s\r\n" + 
			"where \r\n" + 
			"    h.purchase_id=d.purchase_id \r\n" + 
			"    and s.supp_id=h.supp_id\r\n" + 
			"    and d.replace_qty>0 ",nativeQuery=true)
	List<ItemReplaceReport> itemReplaceReport();

}
