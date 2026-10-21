package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OrderStatus;

/**
 * OrderStatusRepository
 */
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
}
