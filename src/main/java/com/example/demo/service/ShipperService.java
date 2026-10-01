package com.example.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Shipper;
import com.example.demo.repository.ShipperRepository;

@Service
public class ShipperService {
    private final ShipperRepository shipperRepository;

    public ShipperService(ShipperRepository shipperRepository){
        this.shipperRepository = shipperRepository;
    }

    public List<Shipper> getAllShippers(){
        return shipperRepository.findAll();
    }

    public Shipper findShipperById(int shipperId){
        return shipperRepository.findById(shipperId).orElse(null);
    }

    public void deleteShipperById(int shipperId){
        shipperRepository.deleteById(shipperId);
    }

    public void createShipper(String name){
        Shipper shipper = new Shipper(name);

        shipperRepository.save(shipper);
    }

    public void updateShipper(int shipperId, String name){
        Shipper shipper = shipperRepository.findById(shipperId).orElseThrow(
            () -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, 
            "Shipper not found"
        ));

        shipper.setShipperName(name);
        shipperRepository.save(shipper);
    }
}
