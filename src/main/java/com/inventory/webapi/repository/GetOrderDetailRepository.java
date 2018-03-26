package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.GetOrderDetail;

@Repository
public interface GetOrderDetailRepository extends JpaRepository<GetOrderDetail, Integer>{

	@Query(value="select d.order_detail_id,d.order_date,d.order_id,d.item_id,i.item_name,i.uom_id,i.uom_name,i.weight,i.hsn_code,d.order_qty from t_order d,m_item i where  d.order_id=:orderId And d.item_id=i.item_id",nativeQuery=true)
	List<GetOrderDetail> findOrderDetails(@Param("orderId")int orderId);

}
