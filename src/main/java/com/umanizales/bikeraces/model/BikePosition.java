package com.umanizales.bikeraces.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BikePosition {
    public Bike bike;
    public double position;
}