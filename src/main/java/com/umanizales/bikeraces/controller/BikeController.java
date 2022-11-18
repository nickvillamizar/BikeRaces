package com.umanizales.bikeraces.controller;

import com.umanizales.bikeraces.model.Bike;
import com.umanizales.bikeraces.model.ListDEBikes;
import com.umanizales.bikeraces.service.ListDEBikesService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.*;
import java.util.List;

@SpringBootApplication
@Controller
@Component








@RestController
@RequestMapping(path = "BikeRaces")
public class BikeController {
    @Autowired
    private ListDEBikesService listDEBikesService;
    @GetMapping(path="showbikes")//vamos a pedir la lista de niños por el get
  //no se puede obtener las bikes de la misma forma que en DE
    //ya que entrariamos en un bucle por lo que toca sacar la informacion de cada bike
    //y pasarlo a una lista y esta es la que se muestra
    public List<Bike> getList() {

        return  listDEBikesService.getList();

    }



    @PostMapping(path = "addDE")//agregar bikes en DE
    public String add(@RequestBody Bike bike) {
        return ListDEBikesService.add(bike);
    }


    @PostMapping(path = "addToStart")//agregar al inicion en DE
    //igualmente se envia un bike por el body del post
    public String addToStart(@RequestBody Bike bike) {
        return ListDEBikes.addToStart(bike);
    }
    @PostMapping(path = "deletbyposition")//elimina por posicion
    //ingresamos la posicion del bike que queremos eliminar
    public  String deletByPosition(@RequestBody int i){
        return ListDEBikesService.deletByPosition(i);
    }
    @PostMapping(path = "deletbydata")
    public String deletByData(@RequestBody String numberBike){
        return ListDEBikesService.deletByData(numberBike);
    }
}

