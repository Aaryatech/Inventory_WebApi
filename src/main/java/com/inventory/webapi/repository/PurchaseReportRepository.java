package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.PurchaseReport;

public interface PurchaseReportRepository extends JpaRepository<PurchaseReport, Integer>{

	
	@Query(value="select\r\n" + 
			"        h.purchase_id, \r\n" + 
			"        h.invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        SUM(h.disc_amt+h.disc_amt2)as disc_amt,\r\n" + 
			"        SUM(h.freight_amt)as freight_amt,\r\n" + 
			"        SUM(h.insurance_amt)as insurance_amt, \r\n" + 
			"        SUM(h.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(h.cgst)as cgst,\r\n" + 
			"        SUM(h.sgst) as sgst,\r\n" + 
			"        SUM(h.igst) as igst,\r\n" + 
			"        SUM(h.cess) as cess,\r\n" + 
			"        SUM(h.bill_amt) as bill_amt,\r\n" + 
			"        SUM(h.other_extra) as other_extra\r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        supplier s\r\n" + 
			"    where\r\n" + 
			"        h.inv_date between :fromDate And :toDate\r\n" + 
			"        and s.supp_id = h.supp_id \r\n" + 
			"    group by\r\n" + 
			"        h.inv_date",nativeQuery=true)
	List<PurchaseReport> datewisePurchaseReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="select\r\n" + 
			"        h.purchase_id, \r\n" + 
			"        h.invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        SUM(h.disc_amt+h.disc_amt2)as disc_amt,\r\n" + 
			"        SUM(h.freight_amt)as freight_amt,\r\n" + 
			"        SUM(h.insurance_amt)as insurance_amt, \r\n" + 
			"        SUM(h.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(h.cgst)as cgst,\r\n" + 
			"        SUM(h.sgst) as sgst,\r\n" + 
			"        SUM(h.igst) as igst,\r\n" + 
			"        SUM(h.cess) as cess,\r\n" + 
			"        SUM(h.bill_amt) as bill_amt,SUM(h.other_extra) as other_extra\r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        supplier s\r\n" + 
			"    where\r\n" + 
			"        h.inv_date between :fromDate And :toDate\r\n" + 
			"        and s.supp_id = h.supp_id\r\n" + 
			"        and h.supp_id in (:suppId)\r\n" + 
			"    group by\r\n" + 
			"        h.inv_date ",nativeQuery=true)
	List<PurchaseReport> datewisePurchaseReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("suppId") List<Integer> suppId);

	
	@Query(value="select\r\n" + 
			"        h.purchase_id, \r\n" + 
			"        h.invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        SUM(h.disc_amt+h.disc_amt2)as disc_amt,\r\n" + 
			"        SUM(h.freight_amt)as freight_amt,\r\n" + 
			"        SUM(h.insurance_amt)as insurance_amt, \r\n" + 
			"        SUM(h.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(h.cgst)as cgst,\r\n" + 
			"        SUM(h.sgst) as sgst,\r\n" + 
			"        SUM(h.igst) as igst,\r\n" + 
			"        SUM(h.cess) as cess,\r\n" + 
			"        SUM(h.bill_amt) as bill_amt,SUM(h.other_extra) as other_extra\r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        supplier s\r\n" + 
			"    where\r\n" + 
			"        h.inv_date between :fromDate And :toDate\r\n" + 
			"        and s.supp_id = h.supp_id\r\n" + 
			"    group by\r\n" + 
			"        h.supp_id",nativeQuery=true)
	List<PurchaseReport> supplierwisePurchaseReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	
	@Query(value="select\r\n" + 
			"        h.purchase_id, \r\n" + 
			"        h.invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        SUM(h.disc_amt+h.disc_amt2)as disc_amt,\r\n" + 
			"        SUM(h.freight_amt)as freight_amt,\r\n" + 
			"        SUM(h.insurance_amt)as insurance_amt, \r\n" + 
			"        SUM(h.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(h.cgst)as cgst,\r\n" + 
			"        SUM(h.sgst) as sgst,\r\n" + 
			"        SUM(h.igst) as igst,\r\n" + 
			"        SUM(h.cess) as cess,\r\n" + 
			"        SUM(h.bill_amt) as bill_amt,SUM(h.other_extra) as other_extra\r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        supplier s\r\n" + 
			"    where\r\n" + 
			"        h.inv_date between :fromDate And :toDate\r\n" + 
			"        and s.supp_id = h.supp_id\r\n" + 
			"        and h.supp_id in (:suppId)\r\n" + 
			"    group by\r\n" + 
			"        h.supp_id",nativeQuery=true)
	List<PurchaseReport> supplierwisePurchaseReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("suppId") List<Integer> suppId);

	@Query(value="select\r\n" + 
			"        h.purchase_id, \r\n" + 
			"        MONTHNAME(inv_date)as invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        SUM(h.disc_amt+h.disc_amt2)as disc_amt,\r\n" + 
			"        SUM(h.freight_amt)as freight_amt,\r\n" + 
			"        SUM(h.insurance_amt)as insurance_amt, \r\n" + 
			"        SUM(h.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(h.cgst)as cgst,\r\n" + 
			"        SUM(h.sgst) as sgst,\r\n" + 
			"        SUM(h.igst) as igst,\r\n" + 
			"        SUM(h.cess) as cess,\r\n" + 
			"        SUM(h.bill_amt) as bill_amt,SUM(h.other_extra) as other_extra\r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        supplier s\r\n" + 
			"    where\r\n" + 
			"        h.inv_date between :fromDate And :toDate\r\n" + 
			"        and s.supp_id = h.supp_id\r\n" + 
			"    group by\r\n" + 
			"        MONTHNAME(h.inv_date)",nativeQuery=true)
	List<PurchaseReport> monthwisePurchaseReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="select\r\n" + 
			"        h.purchase_id, \r\n" + 
			"        MONTHNAME(inv_date)as invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        SUM(h.disc_amt+h.disc_amt2)as disc_amt,\r\n" + 
			"        SUM(h.freight_amt)as freight_amt,\r\n" + 
			"        SUM(h.insurance_amt)as insurance_amt, \r\n" + 
			"        SUM(h.taxable_amt) as taxable_amt,\r\n" + 
			"        SUM(h.cgst)as cgst,\r\n" + 
			"        SUM(h.sgst) as sgst,\r\n" + 
			"        SUM(h.igst) as igst,\r\n" + 
			"        SUM(h.cess) as cess,\r\n" + 
			"        SUM(h.bill_amt) as bill_amt,SUM(h.other_extra) as other_extra\r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        supplier s\r\n" + 
			"    where\r\n" + 
			"        h.inv_date between :fromDate And :toDate\r\n" + 
			"        and s.supp_id = h.supp_id\r\n" + 
			"        and h.supp_id in (:suppId)\r\n" + 
			"    group by\r\n" + 
			"        MONTHNAME(h.inv_date)",nativeQuery=true)
	List<PurchaseReport> monthwisePurchaseReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("suppId") List<Integer> suppId);

	
	@Query(value="select\r\n" + 
			"        h.purchase_id,\r\n" + 
			"        invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        (h.disc_amt+h.disc_amt2)as disc_amt,\r\n" + 
			"        h.freight_amt,\r\n" + 
			"        h.insurance_amt,\r\n" + 
			"        h.taxable_amt,\r\n" + 
			"        h.cgst,\r\n" + 
			"        h.sgst,\r\n" + 
			"        h.igst,\r\n" + 
			"        h.cess,\r\n" + 
			"        h.bill_amt,\r\n" + 
			"        h.other_extra\r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        supplier s      \r\n" + 
			"    where\r\n" + 
			"        h.inv_date between :fromDate And :toDate          \r\n" + 
			"        and s.supp_id = h.supp_id ",nativeQuery=true)
	List<PurchaseReport> billwisePurchaseReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="select\r\n" + 
			"        h.purchase_id,\r\n" + 
			"        invoice_no,\r\n" + 
			"        h.inv_date,\r\n" + 
			"        h.supp_id,\r\n" + 
			"        s.supp_name,\r\n" + 
			"        (h.disc_amt+h.disc_amt2)as disc_amt,\r\n" + 
			"        h.freight_amt,\r\n" + 
			"        h.insurance_amt,\r\n" + 
			"        h.taxable_amt,\r\n" + 
			"        h.cgst,\r\n" + 
			"        h.sgst,\r\n" + 
			"        h.igst,\r\n" + 
			"        h.cess,\r\n" + 
			"        h.bill_amt,\r\n" + 
			"        h.other_extra\r\n" + 
			"    from\r\n" + 
			"        t_purchase_header h,\r\n" + 
			"        supplier s      \r\n" + 
			"    where\r\n" + 
			"        h.inv_date between :fromDate And :toDate \r\n" + 
			"        and s.supp_id = h.supp_id \r\n" + 
			"        and h.supp_id in (:suppId) ",nativeQuery=true)
	List<PurchaseReport> billwisePurchaseReport(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("suppId") List<Integer> suppId);
	
	

}
