package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.webapi.model.PurchaseDetail;

public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, Integer>{
 

	List<PurchaseDetail> findByPurchaseIdAndDelStatus(int purchaseId, int delStatus);

	@Transactional
	@Modifying
	@Query(" UPDATE PurchaseDetail SET is_grn=1 where batch_no=:batchNo")
	int updateIsGrnInPurchaseDetail(@Param("batchNo")String batchNo);

	List<PurchaseDetail> save(List<PurchaseDetail> purchaseDetailList);

	@Query(value="select pur_detail_id, purchase_id, item_id, item_name, item_uom, rec_qty, rate,base_rate, value, disc_per, disc_amt, freight_amt, insu_amt, cgst_per, cgst_rs, sgst_per, sgst_rs, igst_per, igst_rs, cess_per, cess_rs, taxable_amt, total, round_off, del_status, disc_on_bill, other_extra, batch_no, sell_qty, balance, rate_without_tax, rate_with_tax, wholesale_rate, retail_rate,expiry_date from t_purchase_detail where balance>0 and is_grn=0",nativeQuery=true)
	List<PurchaseDetail> findBatchesOfItem();

	PurchaseDetail findByBatchNoAndDelStatus(String batchNo, int delStatus);

	@Transactional
	@Modifying
	@Query(" UPDATE PurchaseDetail SET replace_qty=:totalReplaceQty where batch_no=:batchNo")
	int updateReplaceQtyInPurchaseBill(@Param("batchNo")String batchNo,@Param("totalReplaceQty") int totalReplaceQty);

	 

}
