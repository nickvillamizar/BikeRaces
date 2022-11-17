package com.umanizales.bikeraces.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.RequestEntity.head;

@Data
@NoArgsConstructor


public class ListDEBikes {
    //head es el inicial de la lista, el primero
    private Node head;

    //tamaño de la lista
    private int size;


    //metodo el cual me devuelve la lista de kid
    public List<Bike> getList() {
        //creamos un ayudante de tipo NodeDE
        //igualamos el temp a la head
        Node temp = head;
        //creamos una lista que va a guardar objetos de tipo kid
        List<Bike> lista = new ArrayList<>();
        //verificamos que la cabeza si contenga algo
        // ya que si es null no se hace nada
        //si la cabeza es diferente de null
        if (head != null) {
            //mientras el ayudante sea diferente de null
            while (temp != null) {
                //agregamos a la lista los datos que contiene el ayudante o temporal
                lista.add(temp.getData());
                //el temporal pasa a ser su siguiente
                temp = temp.getNext();
            }


        }
        //retornamos la lista
        return lista;
    }






    public String add(Bike bike) {
                return "bike añadida";
        }

}
