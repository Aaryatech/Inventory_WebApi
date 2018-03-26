package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.BillDetail;

@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail, Integer>{

	List<BillDetail> findByBillNo(int billNo);

	@Query(value="select  d.bill_detail_id,d.bill_no,d.item_id,d.item_name,d.item_hsncd,SUM(d.bill_qty) as bill_qty,d.rate,d.batch_no,SUM(d.taxable_amt) as taxable_amt,SUM(d.cgst_per) as cgst_per,SUM(d.cgst_rs) as cgst_rs,SUM(d.sgst_per)as sgst_per,SUM(d.sgst_rs) as sgst_rs,SUM(d.igst_per) as igst_per,SUM(d.igst_rs) as igst_rs ,SUM(d.cess_per)as cess_per,\n" + 
			"  SUM(d.cess_rs) as cess_rs,SUM(d.tax_amt) as tax_amt,SUM(d.grand_total) as grand_total,d.base_rate,d.item_uom,SUM(d.value) as value from t_bill_detail d,t_bill_header h where h.invoice_date between :fromDate And :toDate and d.bill_no=h.bill_no group by d.item_id , d.item_hsncd",nativeQuery=true)
	List<BillDetail> findSaleItemAndHsnCodeWise(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

}
