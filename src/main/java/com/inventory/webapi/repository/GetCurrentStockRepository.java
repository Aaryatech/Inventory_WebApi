package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.GetCurrentStock; 

public interface GetCurrentStockRepository extends JpaRepository<GetCurrentStock, Integer>{
	
	@Query(value=" SELECT m_item.item_id, m_item.item_name, coalesce((Select t_stock_detail.opening_stock  FROM t_stock_detail, "
			+ "t_stock_header where t_stock_header.date=:date AND t_stock_header.stock_id=t_stock_detail.stock_id "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) AS opening_stock, coalesce((Select SUM(t_purchase_detail.rec_qty) "
			+ "FROM t_purchase_detail, t_purchase_header where t_purchase_header.date=:date AND t_purchase_header.purchase_id=t_purchase_detail.purchase_id "
			+ " AND m_item.item_id=t_purchase_detail.item_id), 0) AS total_purchase, coalesce((Select SUM( t_bill_detail.bill_qty) "
			+ "FROM t_bill_header, t_bill_detail  WHERE t_bill_header.invoice_date =:date  AND t_bill_header.bill_no=t_bill_detail.bill_no"
			+ " AND m_item.item_id=t_bill_detail.item_id),  0) AS total_sale, coalesce((Select SUM( grn_gvn_detail.qty) FROM "
			+ "grn_gvn_detail, grn_gvn WHERE grn_gvn.date=:date  AND grn_gvn.grn_id=grn_gvn_detail.grn_id  AND m_item.item_id=grn_gvn_detail.item_id),"
			+ " 0)  AS total_grn , coalesce((Select t_stock_detail.closing_stock  FROM t_stock_detail, t_stock_header where "
			+ "t_stock_header.date=:date AND t_stock_header.stock_id=t_stock_detail.stock_id  AND m_item.item_id=t_stock_detail.item_id),"
			+ " 0) AS closing_stock, coalesce((Select t_stock_detail.last_purchase_rate FROM t_stock_detail, t_stock_header where"
			+ " t_stock_header.date=:date   AND t_stock_header.stock_id=t_stock_detail.stock_id   AND m_item.item_id=t_stock_detail.item_id),"
			+ " 0) as last_purchase_rate, coalesce((Select t_stock_detail.last_wholesale_rate  FROM t_stock_detail, t_stock_header  "
			+ "where t_stock_header.date=:date  AND t_stock_header.stock_id=t_stock_detail.stock_id   AND m_item.item_id=t_stock_detail.item_id),"
			+ " 0) as last_wholesale_rate, coalesce((Select t_stock_detail.last_retail_rate  FROM t_stock_detail, t_stock_header "
			+ "where t_stock_header.date=:date  AND t_stock_header.stock_id=t_stock_detail.stock_id  AND m_item.item_id=t_stock_detail.item_id), 0) as last_retail_rate"
			+ " FROM m_item where m_item.del_status=0 ",nativeQuery=true)
	List<GetCurrentStock> getCurrentStock(@Param("date")String date);

	@Query(value="SELECT  m_item.item_id, m_item.item_name, coalesce((Select SUM( t_stock_detail.opening_stock ) FROM t_stock_detail,"
			+ " t_stock_header where t_stock_header.date=:fromDate   AND t_stock_header.stock_id=t_stock_detail.stock_id  "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) AS opening_stock, coalesce((Select SUM( t_stock_detail.total_purchase ) FROM"
			+ " t_stock_detail, t_stock_header  where t_stock_header.date between :fromDate and :toDate  AND t_stock_header.stock_id=t_stock_detail.stock_id  "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) AS total_purchase, coalesce((Select SUM( t_stock_detail.total_sale ) FROM t_stock_detail, "
			+ "t_stock_header  where t_stock_header.date between :fromDate and :toDate  AND t_stock_header.stock_id=t_stock_detail.stock_id "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) AS total_sale, coalesce((Select SUM( t_stock_detail.grn ) FROM t_stock_detail, "
			+ "t_stock_header where t_stock_header.date between :fromDate and :toDate  AND t_stock_header.stock_id=t_stock_detail.stock_id "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0)  AS total_grn , coalesce((Select SUM( t_stock_detail.closing_stock ) "
			+ "FROM t_stock_detail, t_stock_header where t_stock_header.date = :toDate AND t_stock_header.stock_id=t_stock_detail.stock_id  "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0)  AS closing_stock , coalesce((Select t_stock_detail.last_purchase_rate  "
			+ "FROM t_stock_detail, t_stock_header  where t_stock_header.date =:toDate  AND t_stock_header.stock_id=t_stock_detail.stock_id  "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) as last_purchase_rate, coalesce((Select t_stock_detail.last_wholesale_rate"
			+ "  FROM t_stock_detail, t_stock_header where t_stock_header.date=:toDate  AND t_stock_header.stock_id=t_stock_detail.stock_id "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) as last_wholesale_rate, coalesce((Select t_stock_detail.last_retail_rate FROM"
			+ " t_stock_detail, t_stock_header  where t_stock_header.date=:toDate   AND t_stock_header.stock_id=t_stock_detail.stock_id  "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) as last_retail_rate  FROM m_item  where m_item.del_status=0  "
			+ "and m_item.cat_id=:catId",nativeQuery=true)
	List<GetCurrentStock> getStockBetween(@Param("fromDate")String fromDate, @Param("toDate")String toDate,@Param("catId")int catId);

	
	@Query(value="SELECT m_item.item_id, m_item.item_name, coalesce((Select SUM( t_stock_detail.opening_stock ) FROM t_stock_detail,"
			+ " t_stock_header where t_stock_header.date=:fromDate AND t_stock_header.stock_id=t_stock_detail.stock_id "
			+ " AND m_item.item_id=t_stock_detail.item_id), 0) AS opening_stock, coalesce((Select SUM( t_stock_detail.total_purchase )"
			+ " FROM t_stock_detail, t_stock_header  where t_stock_header.date between :fromDate and :toDate  AND t_stock_header.stock_id=t_stock_detail.stock_id  "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) AS total_purchase, coalesce((Select SUM( t_stock_detail.total_sale ) FROM t_stock_detail, "
			+ "t_stock_header where t_stock_header.date between :fromDate and :toDate AND t_stock_header.stock_id=t_stock_detail.stock_id  "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) AS total_sale, coalesce((Select SUM( t_stock_detail.grn ) FROM t_stock_detail,"
			+ " t_stock_header  where t_stock_header.date between :fromDate and :toDate AND t_stock_header.stock_id=t_stock_detail.stock_id  "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0)  AS total_grn , coalesce((Select SUM( t_stock_detail.closing_stock ) FROM "
			+ "t_stock_detail, t_stock_header  where t_stock_header.date = :toDate AND t_stock_header.stock_id=t_stock_detail.stock_id  "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0)  AS closing_stock , coalesce((Select t_stock_detail.last_purchase_rate  "
			+ "FROM t_stock_detail, t_stock_header where t_stock_header.date =:toDate AND t_stock_header.stock_id=t_stock_detail.stock_id "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) as last_purchase_rate, coalesce((Select t_stock_detail.last_wholesale_rate  "
			+ "FROM t_stock_detail, t_stock_header  where t_stock_header.date=:toDate   AND t_stock_header.stock_id=t_stock_detail.stock_id  "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) as last_wholesale_rate, coalesce((Select t_stock_detail.last_retail_rate  "
			+ "FROM t_stock_detail, t_stock_header where t_stock_header.date=:toDate  AND t_stock_header.stock_id=t_stock_detail.stock_id  "
			+ "AND m_item.item_id=t_stock_detail.item_id), 0) as last_retail_rate FROM m_item  where  m_item.del_status=0 ",nativeQuery=true)
	List<GetCurrentStock> getStockBetween(@Param("fromDate")String fromDate, @Param("toDate")String toDate);

}
