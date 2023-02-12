package com.Medicare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Medicare.Entity.Products;
import com.Medicare.ServiceImple.ProductServiceImple;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductServiceImple productServiceImple;
	
	@GetMapping("")
	public List<Products> getAllOrders() {
		return productServiceImple.getAllProduct();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> insertOrder(@RequestBody Products products) {
		Products p = productServiceImple.insertProduct(products);
		if (p != null) {
			return new ResponseEntity<>(p, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error while creating object", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteOrders(@PathVariable int id) {
		if (productServiceImple.deleteProduct(id)) {
			return new ResponseEntity<>("user Deleted successfully", HttpStatus.OK);
		} else
			return new ResponseEntity<>("no user available to delete", HttpStatus.NOT_FOUND);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateOrders(@PathVariable int id, @RequestBody Products products) {
		Products p = productServiceImple.updateProduct(products, id);

		if (p != null) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		} else
			return new ResponseEntity<>("no user available to delete", HttpStatus.NOT_FOUND);
	}
}
