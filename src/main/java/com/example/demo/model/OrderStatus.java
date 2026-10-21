package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "order_statuses")
public class OrderStatus {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "order_status_id")
    private int orderStatusId;

    @Column (name="name")
    private String statusName;

    public OrderStatus(){

    }

    public OrderStatus(String statusName) {
        this.statusName = statusName;
    }

    public OrderStatus(int orderStatusId, String statusName){
        this.orderStatusId = orderStatusId;
        this.statusName = statusName;
    }

    public int getOrderStatusId(){
        return orderStatusId;
    }

    public String getStatusName(){
        return statusName;
    }

    public void setStatusName(String statusName){
        this.statusName = statusName;
    }

}
