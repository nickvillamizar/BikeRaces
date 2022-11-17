package com.umanizales.bikeraces.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalTime;

@Data
@AllArgsConstructor



public class Bike {
    private String numberBike;
    private   String color;
    private String state;
    private String pilot;
    private LocalTime time=LocalTime.of(0,0,0);












    public Bike(String numberBike, String color, String state, String name, double time) {
    }


}






