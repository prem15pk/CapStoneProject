package com.Medicare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Medicare.Entity.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {

}
