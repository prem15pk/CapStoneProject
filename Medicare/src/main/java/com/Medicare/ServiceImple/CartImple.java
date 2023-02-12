package com.Medicare.ServiceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Medicare.Entity.Cart;
import com.Medicare.Repository.CartRepository;
import com.Medicare.Service.CartService;

@Service
public class CartImple implements CartService {

	@Autowired
	CartRepository cartRepository;
	@Override
	public List<Cart> getAll() {
		
		return cartRepository.findAll() ;
	}

	@Override
	public boolean delete(int id) {
		Cart c = cartRepository.getById(id);
		cartRepository.delete(c);
		return true;
		
	}

}
