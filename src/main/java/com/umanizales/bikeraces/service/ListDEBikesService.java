package com.umanizales.bikeraces.service;


import com.umanizales.bikeraces.model.Bike;
import com.umanizales.bikeraces.model.ListDEBikes;
import com.umanizales.bikeraces.model.Node;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;
import java.util.List;




public class ListDEBikesService {

    public static ListDEBikes listDEBikes;
    public Node head;

    public ListDEBikesService() {
        listDEBikes = new ListDEBikes();
        listDEBikes.add(new Bike("001", "azul","true","checo perez",5.6));
        listDEBikes.add(new Bike("002", "rojo","true","charles lecrec",3.8));
        listDEBikes.add(new Bike("003", "naranja","true","carlos sainz",2.9));
        listDEBikes.add(new Bike("004", "verde","true","marx verstappen",1.8));
        listDEBikes.add(new Bike("005", "negro","true","juan pablo montoya",6.5));
    }

    public List<Bike> getList(){
        ListDEBikes DEBikes = new ListDEBikes();
        listDEBikes.add(new Bike());

        return ListDEBikes.getList();


    }
    public String addToStart(Bike bike){
        ListDEBikes.addToStart(bike);
        return "Se agrego";
    }

    public static String deletByPosition(int i){
        return ListDEBikes.deletByPosition(i);
    }

    public static String deletByData(String numberBike){
        return listDEBikes.deletByData(numberBike);
    }








    public static String add(Bike bike){
        return ListDEBikes.add(bike);
    }
}













