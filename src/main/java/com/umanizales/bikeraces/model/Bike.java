package com.umanizales.bikeraces.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor



public class Bike {
    private String numberBike;
    private   String color;
    private boolean state;
    private String pilot;
    private double time;

   


 public Bike(String numberBike, String color, String state, String pilot, double time) {
 }


    public Bike(String id, String color, boolean state,String pilot,double time) {
    }

    public Bike(String s, String naranja, boolean b, String carlos_sainz) {
    }

    public Bike(String s, String blue, boolean b) {
    }
}
     










