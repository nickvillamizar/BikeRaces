package com.umanizales.bikeraces.controller;

import com.umanizales.bikeraces.model.Bike;
import com.umanizales.bikeraces.model.ListDEBikes;
import com.umanizales.bikeraces.service.ListDEBikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping(path = "BikeRaces")
public class BikeController {
    @Autowired
    private ListDEBikesService listDEBikesService;
    @GetMapping(path="showbikes")//vamos a pedir la lista de niños por el get
  //no se puede obtener los niños de la misma forma que en DE
    //ya que entrariamos en un bucle por lo que toca sacar la informacion de cada niño
    //y pasarlo a una lista y esta es la que se muestra
    public List<Bike> getList() {
        System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaa");
        return  listDEBikesService.getList();

    }



    @PostMapping(path = "addDE")//agregar niños en DE
    public String add(@RequestBody Bike bike) {
        return ListDEBikesService.add(bike);
    }
}

