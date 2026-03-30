package com.gm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gm.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
