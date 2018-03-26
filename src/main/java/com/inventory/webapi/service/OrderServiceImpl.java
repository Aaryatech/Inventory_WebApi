package com.inventory.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.webapi.model.GetOrder;
import com.inventory.webapi.model.GetOrderDetail;
import com.inventory.webapi.model.Order;
import com.inventory.webapi.model.OrderDetail;
import com.inventory.webapi.repository.GetOrderDetailRepository;
import com.inventory.webapi.repository.GetOrderHeaderRepository;
import com.inventory.webapi.repository.OrderDetailRepository;
import com.inventory.webapi.repository.OrderHeaderRepository;
@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	OrderHeaderRepository orderHeaderRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	GetOrderHeaderRepository getOrderHeaderRepository;
	
	@Autowired
	GetOrderDetailRepository getOrderDetailRepository;
	
	@Override
	public Order placeOrder(Order orderJson) {
		
		Order orderRes=null;
 try {
		 orderRes=orderHeaderRepository.saveAndFlush(orderJson);
		if(orderRes!=null)
		{
		List<OrderDetail> orderDetailList=new ArrayList<OrderDetail>();
		for(OrderDetail orderDetail:orderRes.getOrderDetail())
		{
			orderDetail.setOrderId(orderRes.getOrderId());
			OrderDetail orderDetailRes=orderDetailRepository.saveAndFlush(orderDetail);
			orderDetailList.add(orderDetailRes);
		}
		orderRes.setOrderDetail(orderDetailList);
		orderRes.setError(false);
		orderRes.setMessage("Order Saved Successfully");
		}
		else
		{
			orderRes=new Order();
			orderRes.setError(false);
			orderRes.setMessage("Order Failed to Save");
		}
	}
	catch (Exception e) {
			e.printStackTrace();
			orderRes=new Order();
			orderRes.setError(false);
			orderRes.setMessage("Order Failed to Save:Exc");
	}
		return orderRes;
	}


	@Override
	public List<GetOrder> getOrderList(String fromDate, String toDate) {

		List<GetOrder> orderListRes=null;
		try {
			
			orderListRes=getOrderHeaderRepository.findAllBetweenDate(fromDate,toDate);
		}
		catch (Exception e) {
			
			orderListRes=new ArrayList<>();
		     e.printStackTrace();
		}
		
		return orderListRes;
	}


	@Override
	public List<GetOrder> getPendingOrderList() {
		List<GetOrder> orderListRes=null;
		try {
			
			orderListRes=getOrderHeaderRepository.findPendingOrders();
		}
		catch (Exception e) {
			
			orderListRes=new ArrayList<>();
		     e.printStackTrace();
		}
		
		return orderListRes;
	}


	@Override
	public List<GetOrderDetail> getOrderDetails(int orderId) {
		List<GetOrderDetail> orderDetailsRes=null;
		try {
			
			orderDetailsRes=getOrderDetailRepository.findOrderDetails(orderId);
		}
		catch (Exception e) {
			
			orderDetailsRes=new ArrayList<>();
		     e.printStackTrace();
		}
		
		return orderDetailsRes;
	}


	@Override
	public GetOrder getOrder(int orderId) {
		GetOrder orderRes=null;
		try {
			orderRes=getOrderHeaderRepository.findByOrderId(orderId);
		}
		catch (Exception e) {
			orderRes=new GetOrder();
			e.printStackTrace();
		}
		return orderRes;
	}

	
	
}
