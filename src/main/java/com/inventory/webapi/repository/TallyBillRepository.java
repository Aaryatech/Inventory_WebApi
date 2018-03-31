package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.TallyBill;

@Repository
public interface TallyBillRepository extends JpaRepository<TallyBill, Integer> {

	@Query(value="select  t_bill_detail.bill_detail_id,\n" + 
			" t_bill_header.bill_no,\n" + 
			" t_bill_header.invoice_no,\n" + 
			" t_bill_header.invoice_date,\n" + 
			" t_bill_header.cust_id,\n" + 
			" t_bill_header.cust_name,\n" + 
			" t_bill_header.gstin,\n" + 
			" t_bill_header.cust_type,\n" + 
			" t_bill_detail.item_id,\n" + 
			"  t_bill_detail.item_name,\n" + 
			"  t_bill_detail.item_hsncd,\n" + 
			"  t_bill_detail.bill_qty,\n" + 
			"  t_bill_detail.rate,\n" + 
			"  t_bill_detail.batch_no,\n" + 
			"  t_bill_detail.taxable_amt,\n" + 
			"  t_bill_detail.cgst_per,\n" + 
			"  t_bill_detail.cgst_rs,\n" + 
			"  t_bill_detail.sgst_per,\n" + 
			"  t_bill_detail.sgst_rs,\n" + 
			"  t_bill_detail.igst_per,\n" + 
			"  t_bill_detail.igst_rs,\n" + 
			"  t_bill_detail.cess_per,\n" + 
			"  t_bill_detail.cess_rs,\n" + 
			"  t_bill_detail.tax_amt,\n" + 
			"  t_bill_detail.grand_total,\n" + 
			"  t_bill_detail.base_rate,\n" + 
			"  t_bill_detail.item_uom,\n" + 
			"  t_bill_detail.disc_amt, \n" + 
			"  t_bill_header.taxable_amt as total_taxable_amt,\n" + 
			"  t_bill_header.tax_amt as total_tax_amt,\n" + 
			"  t_bill_header.grand_total as total_grand_amt,\n" + 
			"  t_bill_header.discount_amt as total_discount_amt,\n" + 
			"  t_bill_header.paid_amt as total_paid_amt,\n" + 
			"  t_bill_header.rem_amt as total_remaining_amt,\n" + 
			"  t_bill_header.bill_status,\n" + 
			"  t_bill_header.remark,\n" + 
			"  t_bill_header.expiry_date,\n" + 
			"  t_bill_header.cgst_rs as total_cgst,\n" + 
			"  t_bill_header.sgst_rs as total_sgst,\n" + 
			"  t_bill_header.igst_rs as total_igst,\n" + 
			"  t_bill_header.cess_rs as total_cess,\n" + 
			"   t_bill_header.discount_per as bill_discount_per from t_bill_header,t_bill_detail where  t_bill_header.bill_no=t_bill_detail.bill_no  and t_bill_header.is_tally_sync=0\n" + 
			"\n" + 
			"",nativeQuery=true)
	List<TallyBill> findByIsTallySync();

}
