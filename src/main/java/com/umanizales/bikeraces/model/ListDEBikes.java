package com.umanizales.bikeraces.model;

import com.umanizales.bikeraces.service.ListDEBikesService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.springframework.http.RequestEntity.head;

@Data
@NoArgsConstructor


public class ListDEBikes {
    //head es el inicial de la lista, el primero
    private static Node head;

    //tamaño de la lista
    private int size;



    //metodo el cual me devuelve la lista de kid
    public static List<Bike> getList() {
        //creamos un ayudante de tipo NodeDE
        //igualamos el temp a la head
        Node temp = head;
        //creamos una lista que va a guardar objetos de tipo bike
        List<Bike> list = new ArrayList<>();
        //verificamos que la cabeza si contenga algo
        // ya que si es null no se hace nada
        //si la cabeza es diferente de null
        if (head != null) {
            //mientras el ayudante sea diferente de null
            while (temp != null) {
                //agregamos a la lista los datos que contiene el ayudante o temporal
                list.add(temp.getData());
                //el temporal pasa a ser su siguiente
                temp = temp.getNext();
            }


        }
        //retornamos la lista
        return list;
    }


    public static String add(Bike bike) {
        //si la lista esta vacia simplemente se agrega a la cabeza
        if (head == null) {
            //guardamos al bike en un nodo DE y lo guardamos en la head
            head = new Node(bike, null, null);
        } else {//en caso que la cabeza si contenga algo
            Node temp = head;//creamos un temporal y lo igualamos a la cabeza
            while (temp.getNext() != null) {//mientras que el siguiente del temporal sea diferente a null
                temp = temp.getNext();//temporal pasa a ser el seguiente

            }
            //Ayudante esta en el ultimo
            //guardamos al bike en un nodo DE
            Node newNode = new Node(bike, null, temp);
            //guardamos al nuevo nodo en el siguiente del temporal
            temp.setNext(newNode);



        }//retornamos un mensaje que nos dice que si se pudo añadir al bike
        return "la moto se agrego";
    }

    public static String addToStart(Bike bike) {
        //guardamos al bike en un nodo DE
        Node newNode = new Node(bike);
        //verificamos que la cabeza no este vacia
        // ya que en ese caso el nuevo ya llegaria a ser el primero
        if (head == null) {
            //guardamos al nuevo nodoDE en la cabeza
            head = newNode;
        } else {
            //primero conectamos la cabeza con el siguiente
            newNode.setNext(head);
            //aseguramos que el nuevo tenga su previus
            newNode.setPrevius(null);
            //le decimo que el nuevo head va a se el nuevoNodeDE
            head = newNode;
        }

        return ListDEBikes.getList().toString();


    }
    @PostMapping(path = "deletbyposition")//elimina por posicion
    //ingresamos la posicion del bike que queremos eliminar
    public static String deletByPosition(@RequestBody int i){
        return ListDEBikes.deletByPosition(i);
    }


    public String deletByData(String numberBike){
        Node temp=head;//creamos un temporal tipo NodeDE y lo igualamos a la head
        ListDEBikesService newlist=new ListDEBikesService();//creamos una nueva lista DE

        while (temp!=null) {//temporal debe recorrer toda la lista

            if (!Objects.equals(numberBike, temp.getData().getNumberBike())){//identificador diferente al que contiene el dato
                ListDEBikesService.add(temp.getData());//agregamos en la nueva lista

            }
            temp=temp.getNext();//temporal pasa a ser su siguiente

        }
        head=newlist.head;//head de la nueva lista pasa a ser la head de la princiapal
        return "eliminado";
    }
}

