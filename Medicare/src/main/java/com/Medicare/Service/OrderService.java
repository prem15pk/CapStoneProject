package com.Medicare.Service;

import java.util.List;

import com.Medicare.Entity.Orders;

public interface OrderService {

	public List<Orders> getAllOrders();

	public Orders insertOrders(Orders orders);

	public boolean deleteOrder(int id);
	
	public Orders updateOrders(Orders orders,int id);
}
