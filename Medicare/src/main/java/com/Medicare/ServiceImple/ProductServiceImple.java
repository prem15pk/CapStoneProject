package com.Medicare.ServiceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Medicare.Entity.Products;
import com.Medicare.Repository.ProductRepository;
import com.Medicare.Service.ProductService;

@Service
public class ProductServiceImple implements ProductService {
    @Autowired
	ProductRepository productRepository;

	@Override
	public List<Products> getAllProduct() {
		
		return productRepository.findAll();
	}

	@Override
	public Products insertProduct(Products products) {
		
		return productRepository.save(products) ;
	}

	@Override
	public boolean deleteProduct(int id) {
		if (productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Products updateProduct(Products products, int id) {
		
		if(productRepository.findById(id).isPresent()) {
			Products p = productRepository.findById(id).get();
			p.setProductAmount(products.getProductAmount());
			p.setProductName(products.getProductName());
			p.setProductCategory(products.getProductCategory());
			p.setProductDescription(products.getProductDescription());
			
			return productRepository.save(p);
		}
		else {
			return null;
		}
	}
	
}
