package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.GetOrder;
import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import com.example.demo.model.Shipper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.OrderStatusRepository;
import com.example.demo.repository.ShipperRepository;

@Service 
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final ShipperRepository shipperRepository;

    public OrderService(OrderRepository orderRepository, 
                        CustomerRepository customerRepository, 
                        OrderStatusRepository orderStatusRepository, 
                        ShipperRepository shipperRepository
    ){
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.shipperRepository = shipperRepository;
    }

    public List<GetOrder> getAllOrders(){
        return orderRepository.findAll().stream().map(order -> {
            Shipper shipper = order.getShipper();

            return new GetOrder(
            order.getOrderId(),
            order.getCustomer().getCustomerId(),
            order.getOrderDate(),
            order.getStatus().getOrderStatusId(),
            order.getComments(),
            order.getShippedDate(),
            shipper != null 
                ? Integer.valueOf(shipper.getShipperId())
                : null
            );
    }).toList();
    }

    public GetOrder getOrderById(int id){
        return orderRepository.findById(id).map(order -> {
            Shipper shipper = order.getShipper();

            return new GetOrder(
            order.getOrderId(),
            order.getCustomer().getCustomerId(),
            order.getOrderDate(),
            order.getStatus().getOrderStatusId(),
            order.getComments(),
            order.getShippedDate(),
            shipper != null 
                ? Integer.valueOf(shipper.getShipperId())
                : null
            );
    }).orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, 
            "Order not found"
        ));
    }

    public void deleteOrderById(int id){
        if (!orderRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }

        orderRepository.deleteById(id);
    }

    public void createOrder(int customerId, 
                            LocalDate orderDate, 
                            int statusId,  
                            String comments,
                            LocalDate shippedDate,
                            int shipperId
    ){
        Customer customer = customerRepository.findById(customerId).orElseThrow(
            () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Customer not found"
        ));

        OrderStatus status = orderStatusRepository.findById(statusId).orElseThrow(
            () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Status not found"
        ));

        Shipper shipper = shipperRepository.findById(shipperId).orElseThrow(
            () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Shipper not found"
        ));

        Order order = new Order(customer, orderDate, status, comments, shippedDate, shipper);

        orderRepository.save(order);
    }

    public void updateOrder(int orderId,
                            int customerId, 
                            LocalDate orderDate, 
                            int statusId,  
                            String comments,
                            LocalDate shippedDate,
                            int shipperId
    ){
        Order order = orderRepository.findById(orderId).orElseThrow(
            () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, 
            "Order not found"
        ));

        Customer customer = customerRepository.findById(customerId).orElseThrow(
            () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Customer not found"
        ));

        OrderStatus status = orderStatusRepository.findById(statusId).orElseThrow(
            () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Status not found"
        ));

        Shipper shipper = shipperRepository.findById(shipperId).orElseThrow(
            () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Shipper not found"
        ));

        order.setCustomer(customer);
        order.setOrderDate(orderDate);
        order.setStatus(status);
        order.setComments(comments);
        order.setShippedDate(shippedDate);
        order.setShipper(shipper);

        orderRepository.save(order);
    }

}
