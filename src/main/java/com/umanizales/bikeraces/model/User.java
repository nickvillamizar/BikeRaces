package com.umanizales.bikeraces.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private  String email;
    private String pasword;
    private Rol rol;



}