package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.PurchaseBill;
@Repository
public interface TallyPurchaseBillRepository extends JpaRepository<PurchaseBill, Integer>{

	@Query(value="select \n" + 
			"  t_purchase_detail.pur_detail_id,\n" + 
			" t_purchase_header.purchase_id,\n" + 
			" t_purchase_header.purchase_no,\n" + 
			" t_purchase_header.date,\n" + 
			" t_purchase_header.time,\n" + 
			" t_purchase_header.vehicle_no,\n" + 
			" t_purchase_header.supp_id,\n" + 
			" supplier.supp_name,\n" + 
			" t_purchase_header.invoice_no,\n" + 
			" t_purchase_header.inv_date,\n" + 
			"t_purchase_detail.item_id,\n" + 
			"  t_purchase_detail.item_name,\n" + 
			"  t_purchase_detail.item_uom,\n" + 
			"  t_purchase_detail.rec_qty,\n" + 
			"  t_purchase_detail.rate,\n" + 
			"  t_purchase_detail.base_rate,\n" + 
			"  t_purchase_detail.value,\n" + 
			"  t_purchase_detail.disc_per,\n" + 
			"  t_purchase_detail.disc_amt,\n" + 
			"  t_purchase_detail.freight_amt,\n" + 
			"  t_purchase_detail.insu_amt,\n" + 
			"  t_purchase_detail.cgst_per,\n" + 
			"  t_purchase_detail.cgst_rs,\n" + 
			"  t_purchase_detail.sgst_per,\n" + 
			"  t_purchase_detail.sgst_rs,\n" + 
			"  t_purchase_detail.igst_per,\n" + 
			"  t_purchase_detail.igst_rs,\n" + 
			"  t_purchase_detail.cess_per,\n" + 
			"  t_purchase_detail.cess_rs,\n" + 
			"  t_purchase_detail.taxable_amt,\n" + 
			"  t_purchase_detail.total,\n" + 
			"  t_purchase_detail.round_off,\n" + 
			"  t_purchase_detail.disc_on_bill,\n" + 
			"  t_purchase_detail.other_extra,\n" + 
			"  t_purchase_detail.batch_no,\n" + 
			"  t_purchase_detail.sell_qty,\n" + 
			"  t_purchase_detail.balance,\n" + 
			"  t_purchase_detail.rate_without_tax,\n" + 
			"  t_purchase_detail.rate_with_tax,\n" + 
			"  t_purchase_detail.wholesale_rate,\n" + 
			"  t_purchase_detail.retail_rate,\n" + 
			"  t_purchase_detail.is_grn,\n" + 
			"  t_purchase_detail.expiry_date,\n" + 
			"t_purchase_detail.replace_qty,\n" + 
			" t_purchase_header.basic_value as total_value,\n" + 
			" t_purchase_header.disc_per as total_disc_per,\n" + 
			" t_purchase_header.disc_amt as total_disc_amt,\n" + 
			" t_purchase_header.disc_amt2 as total_disc_amt2,\n" + 
			" t_purchase_header.freight_amt as total_freight_amt,\n" + 
			" t_purchase_header.insurance_amt as total_insurance_amt,\n" + 
			" t_purchase_header.cgst as total_cgst,\n" + 
			" t_purchase_header.sgst as total_sgst,\n" + 
			" t_purchase_header.igst as total_igst,\n" + 
			" t_purchase_header.cess as total_cess,\n" + 
			" t_purchase_header.taxable_amt as total_taxable_amt, \n" + 
			" t_purchase_header.bill_amt as total_bill_amt,\n" + 
			" t_purchase_header.round_off as total_round_off,\n" + 
			" t_purchase_header.other_extra as total_other_extra,\n" + 
			" t_purchase_header.cd_date1 as pay_deadline1,\n" + 
			" t_purchase_header.cd_date2 as pay_deadline2,\n" + 
			" t_purchase_header.cd_date3 as pay_deadline3,\n" + 
			" t_purchase_header.cd_date4 as pay_deadline4,\n" + 
			" t_purchase_header.is_paid as is_bill_paid\n" + 
			" from  t_purchase_header,t_purchase_detail,supplier where t_purchase_header.supp_id=supplier.supp_id and  t_purchase_header.purchase_id=t_purchase_detail.purchase_id and t_purchase_header.is_tally_sync=0 and t_purchase_header.del_status=0",nativeQuery=true)
	List<PurchaseBill> findByIsTallySync();

}
