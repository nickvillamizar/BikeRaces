package com.umanizales.bikeraces.controller;

import com.umanizales.bikeraces.model.*;
import com.umanizales.bikeraces.service.RaceService;
import com.umanizales.bikeraces.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "races")
public class RaceController {
    @Autowired
    private RaceService raceService;
    @Autowired
    private UserService userService;




    @PostMapping(path = "grill")
    public List<BikeClaificationDTO> makeGrill(){
        return raceService.makeGrill();
    }

    @PostMapping(path = "therace")
    public Race makerace(@RequestBody User user){
        return raceService.makerace(user);
    }
    @PostMapping(path = "Clasification")
    public String toassignClasifiction(){
        return raceService.toassignClasifiction();
    }
    @PostMapping(path = "getlist")
    public List<Bike> obtenerlista(){
        return raceService.obtenerlista();
    }
    @PostMapping(path = "advance")
    public List<Bike>advance(@RequestBody BikePosition bikePosition){return raceService.advance(bikePosition);}


}
