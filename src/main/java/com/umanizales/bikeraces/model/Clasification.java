package com.umanizales.bikeraces.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Clasification {
    private String description;
    private List<BikeClaificationDTO> grill;
    @Autowired
    private boolean state;

    public Clasification(){
        this.state=true; //iniciamos la clasificacion en true
        this.grill=new ArrayList<>();
        //agrega unas bikes y sus tiempos  en este caso estan desorganizados
        grill.add(new BikeClaificationDTO(new Bike("003","naranja",true,"carlos sainz"),2));
        grill.add(new BikeClaificationDTO(new Bike("005","green",true),3));
        grill.add(new BikeClaificationDTO(new Bike("0044","blue",true),2));
    }


    public Clasification(List<BikeClaificationDTO> grill){
        this.state=true;
        this.grill=grill;
    }

    public String addBiker(BikeClaificationDTO baikeClasifDTO){
        grill.add(baikeClasifDTO);
        return "se agrego ";
    }

    //este metodo organiza la grill en orden segun el menor tiempo
    public List<BikeClaificationDTO> sortGrill() {
        //va a ir comparando cual es el mayor y organiza la grilla dejando de primero
        //al bike que tiene el menor tiempo
        for (int i=0;i<=this.grill.size()-1;i++){

            for (int k=0;k<=this.grill.size()-1;k++){
                System.out.println(grill.get(k).getTime());
                if (k<grill.size()-1){
                    if(grill.get(k).getTime() > grill.get(k+1).getTime()){
                        BikeClaificationDTO aux=grill.get(k);
                        System.out.println("este es el aux"+aux);
                        grill.set(k,grill.get(k+1));
                        grill.set(k+1,aux);
                    }
                }
            }
        }

        return grill ;
    }


    public List<BikeClaificationDTO> getGrill() {
        return sortGrill();
    }


}