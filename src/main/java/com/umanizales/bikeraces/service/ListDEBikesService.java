package com.umanizales.bikeraces.service;


import com.umanizales.bikeraces.model.Bike;
import com.umanizales.bikeraces.model.ListDEBikes;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service



public class ListDEBikesService {
    public ListDEBikes listDEBikes;
    public ListDEBikesService() {
        listDEBikes = new ListDEBikes();
        listDEBikes.add(new Bike("001", "azul","true","checo perez",5.6));
        listDEBikes.add(new Bike("002", "rojo","true","charles lecrec",3.8));
        listDEBikes.add(new Bike("003", "naranja","true","carlos sainz",2.9));
        listDEBikes.add(new Bike("004", "verde","true","marx verstappen",1.8));
        listDEBikes.add(new Bike("005", "negro","true","juan pablo montoya",6.5));
    }

    public List<Bike> getList(){
        listDEBikes = new ListDEBikes();
        listDEBikes.add(new Bike());

        return listDEBikes.getList();
    }








    public static String add(Bike bike){
        return ListDEBikes.add(bike);
    }
}













