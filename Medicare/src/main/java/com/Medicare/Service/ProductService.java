package com.Medicare.Service;

import java.util.List;

import com.Medicare.Entity.Products;

public interface ProductService {

	public List<Products> getAllProduct();

	public Products insertProduct(Products products);

	public boolean deleteProduct(int id);
	
	public Products updateProduct(Products products,int id);
}
