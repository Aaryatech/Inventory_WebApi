package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.BillHeader;

@Repository
public interface BillHeaderRepository extends JpaRepository<BillHeader, Integer>{

	@Query(value="select  bill_no, invoice_no, invoice_date, cust_id, cust_name,gstin,cust_type,taxable_amt,tax_amt,grand_total,discount_per,discount_amt,paid_amt,rem_amt, bill_status, remark, expiry_date,cgst_rs,sgst_rs,igst_rs,cess_rs from t_bill_header where invoice_date between :fromDate And :toDate ",nativeQuery=true)
	List<BillHeader> findBillsBetweenDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	BillHeader findByBillNo(int billNo);

	List<BillHeader> findByBillNoIn(List<Integer> billNos);

	@Query(value="select  bill_no, invoice_no, invoice_date, cust_id, cust_name,gstin,cust_type,SUM(taxable_amt)as taxable_amt,SUM(tax_amt)as tax_amt,SUM(grand_total)as grand_total,SUM(discount_per)as discount_per,SUM(discount_amt) as discount_amt,SUM(paid_amt) as paid_amt,SUM(rem_amt) as rem_amt, bill_status, remark, expiry_date,SUM(cgst_rs) as cgst_rs,SUM(sgst_rs) as sgst_rs,SUM(igst_rs) as igst_rs,SUM(cess_rs)as cess_rs from t_bill_header where invoice_date between :fromDate And :toDate group by invoice_date",nativeQuery=true)
	List<BillHeader> findByInvoiceDateInAndGroupByInvoiceDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="select  bill_no,  MONTHNAME(invoice_date)as invoice_no, invoice_date, cust_id, cust_name,gstin,cust_type,SUM(taxable_amt)as taxable_amt,SUM(tax_amt)as tax_amt,SUM(grand_total)as grand_total,SUM(discount_per)as discount_per,SUM(discount_amt) as discount_amt,SUM(paid_amt) as paid_amt,SUM(rem_amt) as rem_amt, bill_status, remark, expiry_date,SUM(cgst_rs) as cgst_rs,SUM(sgst_rs) as sgst_rs,SUM(igst_rs) as igst_rs,SUM(cess_rs)as cess_rs from t_bill_header where invoice_date between :fromDate And :toDate group by MONTHNAME(invoice_date)",nativeQuery=true)
	List<BillHeader> findSaleGroupByMonth(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="select  bill_no, invoice_no, invoice_date, cust_id, cust_name,gstin,cust_type,taxable_amt,tax_amt,grand_total,discount_per,discount_amt,paid_amt,rem_amt, bill_status, remark, expiry_date,cgst_rs,sgst_rs,igst_rs,cess_rs from t_bill_header where bill_status=2 ",nativeQuery=true)
	List<BillHeader> findUnpaidBills();

}
