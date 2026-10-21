package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.OrderStatus;
import com.example.demo.repository.OrderStatusRepository;

@Service 
public class OrderStatusService {
    
    OrderStatusRepository orderStatusRepository;

    public OrderStatusService(OrderStatusRepository orderStatusRepository){
        this.orderStatusRepository = orderStatusRepository;
    }
    public OrderStatus getOrderStatusById(int id){
        return orderStatusRepository.findById(id).orElse(null);
    }

    public List<OrderStatus> getAllOrderStatus(){
        return orderStatusRepository.findAll();
    }

}
