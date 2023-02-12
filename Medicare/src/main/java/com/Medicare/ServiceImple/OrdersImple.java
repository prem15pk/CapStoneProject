package com.Medicare.ServiceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Medicare.Entity.Orders;
import com.Medicare.Repository.OrderRepo;
import com.Medicare.Service.OrderService;

@Service
public class OrdersImple implements OrderService {

	@Autowired
	OrderRepo orderRepo;

	@Override
	public List<Orders> getAllOrders() {

		return orderRepo.findAll();
	}

	@Override
	public Orders insertOrders(Orders orders) {

		return orderRepo.save(orders);
	}

	@Override
	public boolean deleteOrder(int id) {

		if (orderRepo.findById(id).isPresent()) {
			orderRepo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Orders updateOrders(Orders orders, int id) {

		if (orderRepo.findById(id).isPresent()) {
			Orders o = orderRepo.findById(id).get();
			o.setOrderName(orders.getOrderName());
			o.setOrderPrice(orders.getOrderPrice());
			o.setOrderQuandity(orders.getOrderQuandity());
			return o;
		} else
			return null;
	}

}
