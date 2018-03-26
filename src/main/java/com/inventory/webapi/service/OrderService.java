package com.inventory.webapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventory.webapi.model.GetOrder;
import com.inventory.webapi.model.GetOrderDetail;
import com.inventory.webapi.model.Order;

@Service
public interface OrderService {

	Order placeOrder(Order orderJson);

	List<GetOrder> getOrderList(String fromDate, String toDate);

	List<GetOrder> getPendingOrderList();

	List<GetOrderDetail> getOrderDetails(int orderId);

	GetOrder getOrder(int orderId);

}
