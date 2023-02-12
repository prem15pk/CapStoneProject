package com.Medicare.Service;

import java.util.List;

import com.Medicare.Entity.Cart;

public interface CartService {

	public List<Cart> getAll();
	public boolean delete(int id);
	
}
