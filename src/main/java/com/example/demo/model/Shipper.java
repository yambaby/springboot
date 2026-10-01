package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name="shippers")
public class Shipper {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "shipper_id")
    private int shipperId;

    @Column(name = "name")
    private String name;

    public Shipper(){

    }

    public Shipper(int shipperId, String name){
        this.shipperId = shipperId;
        this.name = name;
    }

    public Shipper(String name){
        this.name = name;
    }

    //Setter

    public void setShipperName(String name){
        this.name = name;
    }

    //Getter 

    public String getShipperName(){
        return name;
    }
}
