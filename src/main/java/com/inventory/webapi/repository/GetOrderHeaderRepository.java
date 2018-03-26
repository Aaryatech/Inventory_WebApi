package com.inventory.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inventory.webapi.model.GetOrder;

@Repository
public interface GetOrderHeaderRepository extends JpaRepository<GetOrder, Integer>{

	@Query(value="select h.order_id,h.order_date,h.cust_id,c.is_same_state,c.cust_name,c.gstin,c.address,c.mobile,c.credit_days,h.cust_type,h.order_type,h.order_sub_type,h.order_status,h.order_datetime,h.delivery_date,h.user_id,u.user_name,h.is_bill_generated from t_order_header h,s_customer c,m_user u where h.cust_id=c.cust_id And h.user_id=u.user_id And h.order_date between :fromDate And :toDate",nativeQuery=true)
	List<GetOrder> findAllBetweenDate(@Param("fromDate")String fromDate,@Param("toDate") String toDate);

	@Query(value="select h.order_id,h.order_date,h.cust_id,c.is_same_state,c.cust_name,c.gstin,c.address,c.mobile,c.credit_days,h.cust_type,h.order_type,h.order_sub_type,h.order_status,h.order_datetime,h.delivery_date,h.user_id,u.user_name,h.is_bill_generated from t_order_header h,s_customer c,m_user u where h.cust_id=c.cust_id And h.user_id=u.user_id And h.order_status=1",nativeQuery=true)
	List<GetOrder> findPendingOrders();

	@Query(value="select h.order_id,h.order_date,h.cust_id,c.is_same_state,c.cust_name,c.is_same_state,c.gstin,c.address,c.mobile,c.credit_days,h.cust_type,h.order_type,h.order_sub_type,h.order_status,h.order_datetime,h.delivery_date,h.user_id,u.user_name,h.is_bill_generated from t_order_header h,s_customer c,m_user u where h.cust_id=c.cust_id And h.user_id=u.user_id And h.order_id=:orderId",nativeQuery=true)
	GetOrder findByOrderId(@Param("orderId")int orderId);

}
