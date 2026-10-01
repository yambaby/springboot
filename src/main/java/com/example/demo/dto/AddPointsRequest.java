package com.example.demo.dto;

import jakarta.validation.constraints.Min;

public class AddPointsRequest {

    @Min(value = 1, message = "Points must be 1 and above")
    private int addPoints;

    public int getAddPoints(){
        return addPoints;
    }

    public void setAddPoints(int addPoints){
        this.addPoints = addPoints;
    }
}
