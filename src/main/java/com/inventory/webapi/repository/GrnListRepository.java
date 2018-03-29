package com.inventory.webapi.repository;
 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.GrnList; 

public interface GrnListRepository extends JpaRepository<GrnList, Integer>{
	
	@Query(value=" select\r\n" + 
			"        d.pur_detail_id,h.purchase_id,\r\n" + 
			"        h.invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        d.item_id,\r\n" + 
			"        d.item_name,\r\n" + 
			"        i.hsn_code,\r\n" + 
			"        d.batch_no,\r\n" + 
			"        d.balance,\r\n" + 
			"        d.rate_with_tax,\r\n" + 
			"        d.expiry_date\r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        t_purchase_detail d,\r\n" + 
			"        m_item i,\r\n" + 
			"        supplier s  \r\n" + 
			"    where\r\n" + 
			"        d.batch_no=:batchNo  \r\n" + 
			"        and h.supp_id=:suppId  \r\n" + 
			"        and d.purchase_id=h.purchase_id  \r\n" + 
			"        and d.item_id=i.item_id  \r\n" + 
			"        and h.supp_id=s.supp_id  \r\n" + 
			"        and d.is_grn=0\r\n" + 
			"        and d.expiry_date<=:currentDate and d.balance>0",nativeQuery=true)
	GrnList getItemRecord(@Param("batchNo")String batchNo,@Param("suppId")int suppId,@Param("currentDate")String currentDate);
	
	@Query(value=" select\r\n" + 
			"        d.pur_detail_id,h.purchase_id,\r\n" + 
			"        h.invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        d.item_id,\r\n" + 
			"        d.item_name,\r\n" + 
			"        i.hsn_code,\r\n" + 
			"        d.batch_no,\r\n" + 
			"        d.replace_qty as balance,\r\n" + 
			"        d.rate_with_tax,\r\n" + 
			"        d.expiry_date\r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        t_purchase_detail d,\r\n" + 
			"        m_item i,\r\n" + 
			"        supplier s  \r\n" + 
			"    where\r\n" + 
			"        d.batch_no=:batchNo  \r\n" + 
			"        and h.supp_id=:suppId  \r\n" + 
			"        and d.purchase_id=h.purchase_id  \r\n" + 
			"        and d.item_id=i.item_id  \r\n" + 
			"        and h.supp_id=s.supp_id  \r\n" + 
			"        and d.replace_qty>0",nativeQuery=true)
	GrnList getItemRecordReplace(@Param("batchNo")String batchNo,@Param("suppId")int suppId);

	@Query(value="select\r\n" + 
			"        d.pur_detail_id,\r\n" + 
			"        h.purchase_id,\r\n" + 
			"        h.invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        d.item_id,\r\n" + 
			"        d.item_name,\r\n" + 
			"        i.hsn_code,\r\n" + 
			"        d.batch_no,\r\n" + 
			"        d.balance,\r\n" + 
			"        d.rate_with_tax,\r\n" + 
			"        d.expiry_date\r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        t_purchase_detail d,\r\n" + 
			"        m_item i,\r\n" + 
			"        supplier s  \r\n" + 
			"    where \r\n" + 
			"        h.supp_id=:suppId  \r\n" + 
			"        and d.purchase_id=h.purchase_id  \r\n" + 
			"        and d.item_id=i.item_id  \r\n" + 
			"        and h.supp_id=s.supp_id  \r\n" + 
			"        and d.is_grn=0\r\n" + 
			"        and d.expiry_date<=:currentDate and d.balance>0",nativeQuery=true)
	List<GrnList> getallExpireItemSupllierWiseRegular(@Param("suppId")int suppId,@Param("currentDate")String currentDate);

	@Query(value="select\r\n" + 
			"        d.pur_detail_id,\r\n" + 
			"        h.purchase_id,\r\n" + 
			"        h.invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        d.item_id,\r\n" + 
			"        d.item_name,\r\n" + 
			"        i.hsn_code,\r\n" + 
			"        d.batch_no,\r\n" + 
			"        d.replace_qty as balance,\r\n" + 
			"        d.rate_with_tax,\r\n" + 
			"        d.expiry_date      \r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        t_purchase_detail d,\r\n" + 
			"        m_item i,\r\n" + 
			"        supplier s        \r\n" + 
			"    where\r\n" + 
			"        h.supp_id=:suppId            \r\n" + 
			"        and d.purchase_id=h.purchase_id            \r\n" + 
			"        and d.item_id=i.item_id            \r\n" + 
			"        and h.supp_id=s.supp_id \r\n" + 
			"        and d.replace_qty>0",nativeQuery=true)
	List<GrnList> getallExpireItemSupllierWiseReplace(@Param("suppId")int suppId);

	

}
