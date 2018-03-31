package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.ItemWisePurchase;

public interface ItemWisePurchaseRepository extends JpaRepository<ItemWisePurchase, Integer>{

	@Query(value="select\r\n" + 
			"        d.pur_detail_id,\r\n" + 
			"        d.item_id,\r\n" + 
			"        d.item_name, \r\n" + 
			"        SUM(d.rec_qty)as rec_qty,\r\n" + 
			"        SUM(d.disc_on_bill+d.disc_amt)as disc_amt,\r\n" + 
			"        SUM(d.freight_amt)as freight_amt,\r\n" + 
			"        SUM(d.insu_amt) as insu_amt,\r\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(d.cgst_rs) as cgst,\r\n" + 
			"        SUM(d.sgst_rs)as sgst,\r\n" + 
			"        SUM(d.igst_rs) as igst,\r\n" + 
			"        SUM(d.cess_rs) as cess, \r\n" + 
			"        SUM(d.total) as total,\r\n" + 
			"        SUM(d.other_extra) as other_extra\r\n" + 
			"    from\r\n" + 
			"        t_purchase_detail d,\r\n" + 
			"        t_purchase_header h\r\n" + 
			"    where\r\n" + 
			"        h.inv_date between :fromDate And :toDate\r\n" + 
			"        and h.purchase_id = d.purchase_id\r\n" + 
			"    group by\r\n" + 
			"        d.item_id ",nativeQuery=true)
	List<ItemWisePurchase> itemwisePurchaseReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
	@Query(value="select\r\n" + 
			"        d.pur_detail_id,\r\n" + 
			"        d.item_id,\r\n" + 
			"        d.item_name, \r\n" + 
			"        SUM(d.rec_qty)as rec_qty,\r\n" + 
			"        SUM(d.disc_on_bill+d.disc_amt)as disc_amt,\r\n" + 
			"        SUM(d.freight_amt)as freight_amt,\r\n" + 
			"        SUM(d.insu_amt) as insu_amt,\r\n" + 
			"        SUM(d.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(d.cgst_rs) as cgst,\r\n" + 
			"        SUM(d.sgst_rs)as sgst,\r\n" + 
			"        SUM(d.igst_rs) as igst,\r\n" + 
			"        SUM(d.cess_rs) as cess, \r\n" + 
			"        SUM(d.total) as total,\r\n" + 
			"        SUM(d.other_extra) as other_extra\r\n" + 
			"    from\r\n" + 
			"        t_purchase_detail d,\r\n" + 
			"        t_purchase_header h\r\n" + 
			"    where\r\n" + 
			"        h.inv_date between :fromDate And :toDate\r\n" + 
			"        and h.purchase_id = d.purchase_id\r\n" + 
			"        and d.item_id in (:itemId)\r\n" + 
			"    group by\r\n" + 
			"        d.item_id ",nativeQuery=true)
	List<ItemWisePurchase> itemwisePurchaseReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("itemId") List<Integer> itemId);

}
