package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name="orders")
public class Order {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="order_id")
    private int orderId;

    @ManyToOne(optional = false)
    @JoinColumn (name="customer_id", nullable = false)
    private Customer customer;

    @Column (name="order_date")
    private LocalDate orderDate;

    @ManyToOne (optional = false)
    @JoinColumn (name="status", nullable = false)
    private OrderStatus status;

    @Column (name="comments")
    private String comments;

    @Column (name="shipped_date")
    private LocalDate shippedDate;

    @ManyToOne 
    @JoinColumn (name="shipper_id")
    private Shipper shipper;

    public Order(){

    }

    public Order(Customer customer, LocalDate orderDate, OrderStatus status, String comments, LocalDate shippedDate, Shipper shipper){
        this.customer = customer;
        this.orderDate = orderDate;
        this.status = status;
        this.comments = comments;
        this.shippedDate = shippedDate;
        this.shipper = shipper;
    }

    //getters

    public int getOrderId(){
        return orderId;
    }

    public Customer getCustomer(){
        return customer;
    }

    public LocalDate getOrderDate(){
        return orderDate;
    }

    public OrderStatus getStatus(){
        return status;
    }

    public String getComments(){
        return comments;
    }

    public LocalDate getShippedDate(){
        return shippedDate;
    }

    public Shipper getShipper(){
        return shipper;
    }

    //setters

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public void setOrderDate(LocalDate orderDate){
        this.orderDate = orderDate;
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    public void setComments(String comments){
        this.comments = comments;
    }

    public void setShippedDate(LocalDate shippedDate){
        this.shippedDate = shippedDate;
    }

    public void setShipper(Shipper shipper){
        this.shipper = shipper;
    }
}
