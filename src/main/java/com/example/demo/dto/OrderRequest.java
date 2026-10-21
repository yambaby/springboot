package com.example.demo.dto;

import java.time.LocalDate;

public class OrderRequest {

    private int customerId;
    private LocalDate orderDate;
    private int statusId;
    private String comments;
    private LocalDate shippedDate;
    private int shipperId;

    public OrderRequest(){

    }
    
    public OrderRequest(int customerId, 
                        LocalDate orderDate, 
                        int statusId,
                        String comments,
                        LocalDate shippedDate,
                        int shipperId
    ){
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.statusId = statusId;
        this.comments = comments;
        this.shippedDate = shippedDate;
        this.shipperId = shipperId;
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

    public int getShipperId(){
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

    public void setShipperId(int shipperId){
        this.shipperId = shipperId;
    }

}
