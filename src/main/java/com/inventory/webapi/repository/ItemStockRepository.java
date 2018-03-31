package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventory.webapi.model.ItemStock;

public interface ItemStockRepository extends JpaRepository<ItemStock, Integer>{
	
	@Query(value="SELECT m_item.item_id, m_item.item_name, coalesce(t.wholesale_rate, 0)as wholesale_rate ,"
			+ " coalesce(t.retail_rate,0)as retail_rate, coalesce(t.rate_with_tax, 0) as rate_with_tax  FROM m_item "
			+ "LEFT JOIN ( select t.item_id, t.item_name, t.wholesale_rate, t.retail_rate, t.rate_with_tax "
			+ "from t_purchase_detail t inner join ( select item_id, max(pur_detail_id) as pur_detail_id, item_name,"
			+ "wholesale_rate, retail_rate, rate_with_tax  from t_purchase_detail group by item_id  ) tm "
			+ " on t.item_id = tm.item_id  and t.pur_detail_id = tm.pur_detail_id ) t  ON m_item.item_id = t.item_id  "
			+ "where m_item.del_status=0 group by m_item.item_id;",nativeQuery=true)
	List<ItemStock> getFirstTimeItemStock();

	
	@Query(value="select t.item_id, t.item_name, t.wholesale_rate, t.retail_rate, t.rate_with_tax from t_purchase_detail t \r\n" + 
			"            inner join\r\n" + 
			"                (\r\n" + 
			"                    select\r\n" + 
			"                        item_id,\r\n" + 
			"                        max(pur_detail_id) as pur_detail_id,\r\n" + 
			"                        item_name,\r\n" + 
			"                        wholesale_rate,\r\n" + 
			"                        retail_rate,\r\n" + 
			"                        rate_with_tax  \r\n" + 
			"                    from\r\n" + 
			"                        t_purchase_detail \r\n" + 
			"                    group by\r\n" + 
			"                        item_id  \r\n" + 
			"                ) tm  \r\n" + 
			"                    on t.item_id = tm.item_id  \r\n" + 
			"                    where\r\n" + 
			"                    t.pur_detail_id = tm.pur_detail_id\r\n" + 
			"                    and t.del_status=0 \r\n" + 
			"                and t.item_name LIKE :itemName \r\n" + 
			"            group by\r\n" + 
			"                t.item_id;",nativeQuery=true)
	List<ItemStock> getLastRateByItemName(@Param("itemName")String itemName);

}
