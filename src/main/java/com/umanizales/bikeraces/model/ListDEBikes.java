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
    private static Node head;

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








    public static String add(Bike bike) {
        //si la lista esta vacia simplemente se agrega a la cabeza
        if (head == null) {
            //guardamos al kid en un nodo DE y lo guardamos en la head
            head = new Node(bike, null, null);
        } else {//en caso que la cabeza si contenga alfo
            Node temp = head;//creamos un temporal y lo igualamos a la cabeza
            while (temp.getNext() != null) {//mientras que el siguiente del temporal sea diferente a null
                temp = temp.getNext();//temporal pasa a ser el seguiente

            }
            //Ayudante esta en el ultimo
            //guardamos al kid en un nodo DE
            Node newNode = new Node(bike, null, temp);
            //guardamos al nuevo nodo en el siguiente del temporal
            temp.setNext(newNode);
            //le sumamos uno al tamaño de la lista por el nuevo que se añadio



        }//retornamos un mensaje que nos dice que si se pudo añadir al niño
        return "la moto se agrego";
    }


}
