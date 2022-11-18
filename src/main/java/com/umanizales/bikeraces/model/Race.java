package com.umanizales.bikeraces.model;



import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data

public class Race {
    private Clasification clasification;
    private String state;
    private ListDEBikes listDEBikes;

    public Race() {

    }

    //me dice si el usuario si tiene los permisos o no
    public String makerace(User user){
        if(user.getRol().getCode().equals("001")){

            return this.state="carrera creada";
        }
        return "no tiene los permisos";
    }


    public List<Bike> obtenerlista(){
        //me da la lista de los corredores
        for (int i = 0; i < clasification.getGrill().size()-1; i++) {
            System.out.println(listDEBikes.add(clasification.getGrill().get(i).getBike()));
            listDEBikes.add(clasification.getGrill().get(i).getBike());

        }
        return listDEBikes.getList();

    }
    public List<Bike> adelantarPosicion(BikePosition bikePosition){//ingreso bikedto
        Node temp=listDEBikes.getHead();
        //contador es el numero de la posicion en la que se encuentra la bike
        //por el momento se le da uno para iniciarla mas adelante el for le da la verdadera posicion
        int contador=1;
        //
        if(bikePosition.position>=listDEBikes.getSize()){//si las posiciones a adelatar son mayores o iguales a la lista queda de prumero

            Bike guardabike=listDEBikes.obtenerbike(bikePosition.bike.getNumberBike());
            listDEBikes.deletByPosition(bikePosition.bike);
            listDEBikes.addToStart(guardabike);
        }else {

            while (temp.getData().getNumberBike().equals(bikePosition.bike.getNumberBike())!=false){
                contador=contador+1;
                temp=temp.getNext();
            }
            Bike guardabike=listDEBikes.obtenerbike(bikePosition.bike.getNumberBike());
            listDEBikes.deletByPosition(bikePosition.bike);
            listDEBikes.addByPosition(new BikePosition(guardabike,contador- bikePosition.position));
            contador=contador-1;

        }

        return listDEBikes.getList();
    }


}
