package com.inventory.webapi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.inventory.webapi.common.Common;
import com.inventory.webapi.model.GetOrder;
import com.inventory.webapi.model.GetOrderDetail;
import com.inventory.webapi.model.Info;
import com.inventory.webapi.model.Order;
import com.inventory.webapi.repository.OrderHeaderRepository;
import com.inventory.webapi.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	OrderService orderService;
	@Autowired
	OrderHeaderRepository orderHeaderRepository;
	//------------------------- Place Item Order---------------------------------
	@RequestMapping(value = { "/placeOrder" }, method = RequestMethod.POST)
	public @ResponseBody Order placeItemOrder(@RequestBody Order orderJson)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		Order jsonResult = orderService.placeOrder(orderJson);

		return jsonResult;
	}
	//-----------------------------END-------------------------------------------
    //-----------------------------Get All Order Headers Between Dates-----------
	@RequestMapping(value = { "/getOrderList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrder> getOrderList(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetOrder> orderList = orderService.getOrderList(fromDate,toDate);

		return orderList;

	}
	//----------------------------------END--------------------------------------
	//-------------------------Get Pending Orders--------------------------------
		@RequestMapping(value = { "/getPendingOrderList" }, method = RequestMethod.GET)
		public @ResponseBody List<GetOrder> getPendingOrderList() {

			List<GetOrder> orderList = orderService.getPendingOrderList();

			return orderList;

		}
	//-------------------------------------END------------------------------------
	// -------------------------Get Order By Id--------------------------------
	@RequestMapping(value = { "/getOrder" }, method = RequestMethod.POST)
	public @ResponseBody GetOrder getOrder(@RequestParam("orderId")int orderId) {

		GetOrder orderRes= orderService.getOrder(orderId);

		return orderRes;

	}

	// -------------------------------------END------------------------------------
	//-------------------------Get Order Details By OrderId-----------------------
	@RequestMapping(value = { "/getOrderDetails" }, method = RequestMethod.POST)
	public @ResponseBody List<GetOrderDetail> getOrderDetails(@RequestParam("orderId")int orderId) {

		List<GetOrderDetail> orderList = orderService.getOrderDetails(orderId);

		return orderList;

	}
	//-------------------------------------END------------------------------------
	@RequestMapping(value = { "/updateOrderStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateOrderStatus(@RequestParam("orderId") int orderId) {
		
		Info info=new Info();
		try {
			
			int isUpdated=orderHeaderRepository.updateOrderStatus(orderId);
			
			if(isUpdated>=1)
			{
				info.setError(false);
				info.setMessage("Order Status updated");
			}
			else
			{
				info.setError(true);
				info.setMessage("Order Status updation Failed");
			}
		}
		catch (Exception e) {
			info.setError(true);
			info.setMessage("Order Status updation Failed");
			e.printStackTrace();
		}
		return null;
	}
}
