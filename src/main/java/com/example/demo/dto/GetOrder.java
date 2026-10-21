package com.example.demo.dto;

import java.time.LocalDate;

public class GetOrder {
    private int orderId;
    private int customerId;
    private LocalDate orderDate;
    private int statusId;
    private String comments;
    private LocalDate shippedDate;
    private Integer shipperId;

    public GetOrder(){

    }
    
    public GetOrder(int orderId, int customerId, 
                        LocalDate orderDate, 
                        int statusId,
                        String comments,
                        LocalDate shippedDate,
                        Integer shipperId
    ){
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.statusId = statusId;
        this.comments = comments;
        this.shippedDate = shippedDate;
        this.shipperId = shipperId;
    }

    public int getOrderId(){
        return orderId;
    }

    public int getCustomerId(){
        return customerId;
    }

    public LocalDate getOrderDate(){
        return orderDate;
    }

    public int getStatusId(){
        return statusId;
    }

    public String getComments(){
        return comments;
    }

    public LocalDate getShippedDate(){
        return shippedDate;
    }

    public Integer getShipperId(){
        return shipperId;
    }

    //setters

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public void setOrderDate(LocalDate orderDate){
        this.orderDate = orderDate;
    }

    public void setStatusId(int statusId){
        this.statusId = statusId;
    }

    public void setComments(String comments){
        this.comments = comments;
    }

    public void setShippedDate(LocalDate shippedDate){
        this.shippedDate = shippedDate;
    }

    public void setShipperId(Integer shipperId){
        this.shipperId = shipperId;
    }
}
