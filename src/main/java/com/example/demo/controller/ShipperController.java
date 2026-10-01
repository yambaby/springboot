package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Shipper;
import com.example.demo.service.ShipperService;

@RequestMapping ("/shippers")
@RestController 
public class ShipperController {
    private final ShipperService shipperService;

    public ShipperController(ShipperService shipperService){
        this.shipperService = shipperService;
    }

    @GetMapping 
    public List<Shipper> getAllShippers(){
        return shipperService.getAllShippers();
    }

    @GetMapping ("/{id}")
    public Shipper getShipperById(@PathVariable int id){
        return shipperService.findShipperById(id);
    }

    @DeleteMapping ("/{id}")
    public void deleteShipperById(@PathVariable int id){
        shipperService.deleteShipperById(id);
    }

    @PostMapping
    public void createShipper(@RequestBody Shipper shipper){
        shipperService.createShipper(
            shipper.getShipperName()
        );
    }

    @PutMapping ("/{id}")
    public void updateShipper(@PathVariable int id, @RequestBody Shipper shipper){
        shipperService.updateShipper(
            id,
            shipper.getShipperName()
        );
    }

}
