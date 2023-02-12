package com.Medicare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Medicare.Entity.Orders;
import com.Medicare.ServiceImple.OrdersImple;


@RestController

public class OrdersController {

	@Autowired
	OrdersImple ordersImple;

	@PostMapping("/insertOrder")
	public ResponseEntity<Object> insertOrder(@RequestBody Orders orders) {
		Orders o = ordersImple.insertOrders(orders);
		if (o != null) {
			return new ResponseEntity<>(o, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error while creating object", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<Object> deleteOrders(@PathVariable int id) {
		if (ordersImple.deleteOrder(id)) {
			return new ResponseEntity<>("user Deleted successfully", HttpStatus.OK);
		} else
			return new ResponseEntity<>("no user available to delete", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAllOrders")
	public List<Orders> getAllOrders() {
		return ordersImple.getAllOrders();
	}

	@PutMapping("/insertorder/{id}")
	public ResponseEntity<Object> updateOrders(@PathVariable int id, @RequestBody Orders orders) {
		Orders o = ordersImple.updateOrders(orders, id);

		if (o != null) {
			return new ResponseEntity<>(o, HttpStatus.OK);
		} else
			return new ResponseEntity<>("no user available to delete", HttpStatus.NOT_FOUND);
	}

}
