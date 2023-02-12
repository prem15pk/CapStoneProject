package com.Medicare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Medicare.Entity.Products;
@Repository
public interface ProductRepository 
        extends JpaRepository<Products, Integer> {

}
