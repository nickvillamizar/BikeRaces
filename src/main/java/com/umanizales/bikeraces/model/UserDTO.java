package com.umanizales.bikeraces.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDTO {
    private User user;
    private Bike bike;
}