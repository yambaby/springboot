package com.example.demo.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GetOrder;
import com.example.demo.dto.OrderRequest;
import com.example.demo.service.OrderService;

@Validated 
@RestController 
@RequestMapping ("/orders")
public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping 
    public List<GetOrder> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public GetOrder getOrder(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrderById(id);
    }

    @PostMapping
    public void createOrder(@RequestBody OrderRequest orderRequest){
        orderService.createOrder(
            orderRequest.getCustomerId(),
            orderRequest.getOrderDate(),
            orderRequest.getStatusId(),
            orderRequest.getComments(),
            orderRequest.getShippedDate(),
            orderRequest.getShipperId()
        );
    }

    @PutMapping ("/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody OrderRequest orderRequest){
        orderService.updateOrder(
            id,
            orderRequest.getCustomerId(),
            orderRequest.getOrderDate(),
            orderRequest.getStatusId(),
            orderRequest.getComments(),
            orderRequest.getShippedDate(),
            orderRequest.getShipperId()
        );
    }
}
