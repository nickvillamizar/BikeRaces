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



    //metodo el cual me devuelve la lista de bike
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
    public static String deletByPosition(int i){//se el ingresa de entrada la posicion del dato a eliminar
        //creamos un temporal de tipo NodeDE
        Node temp=this.head;//igualamos el temporal a la head
        int contador=1;//iniciamos el contador en uno
        if (i==1){//si la posicion ingresada es la primera
            head=temp.getNext();//la cabeza pasa a ser el siguiente del temporal
            head.setPrevius(null);//el anterior del head queda null
        }
        while (contador<i){//hace que llegue a una posicion antes de la indicada
            if (contador==i-1){
                temp.getNext().getNext().setPrevius(temp);//guardamos en el previo del siguiente siguiente al temporal

                temp.setNext(temp.getNext().getNext());//el siguente del temporal pasa a ser siguiente siguiente
            }
            temp=temp.getNext();//el temporal pasa a ser su siguiente
            contador=contador+1;//contador aumenta en uno

        }
        size--;//contrario al size++ en este caso el tamaño se reduce uno
        return "eliminado";
    }
    //metodo agregar por posicion
    // actualizar
    public String updateByPosition(BikePosition bikePosition)  {//de entrada se el manda un objeto de tipo bikedto
        Node temp=this.head;//creamos un temporal de nodeDE
        int contador=1;//iniciamos un contador en uno

        Bike newbike = bikePosition.getBike();

        if (bikePosition.getPosition() == 1) {//si la posicion del DTO es igual a 1 se ingresa de primero
            //igualamos
            temp.getData().setNumberBike(newbike.getNumberBike());
            temp.getData().setColor(newbike.getColor());
            temp.getData().setState(newbike.isState());
        }


        return "actualizado ";
    }
    //agregar conductor
    //necesito un bikeDTO



    //consultar informacion de bike
    public Bike consultInformationBike(int position){
        Node temp=this.head;
        int contador=1;
        if (position==1){
            return this.head.getData();
        }
        while (contador!=position){
            temp=temp.getNext();
            contador=contador+1;
        }
        return temp.getData();
    }

    //no esta la clase piloto
    //donde se programa la creacion de una carrera

    public static void addToStart(Bike bike){
        //guardamos la bike
        Node newNode=new Node(bike);
        //verificamos que la cabeza no este vacia
        // ya que en ese caso el nuevo ya llegaria a ser el primero
        if (this.head==null){
            //guardamos al nuevo nodoDE en la cabeza
            head=newNode;
        }else {
            //primero conectamos la cabeza con el siguiente
            newNode.setNext(this.head);
            //aseguramos que el nuevo tenga su previus
            newNode.setPrevius(null);
            //le decimo que el nuevo head va a se el nuevoNodeDE
            head=newNode;
        }
        //sumamos uno al tamaño


    }
    public String deletByPosition(Bike bike){//se el ingresa de entrada la posicion del dato a eliminar
        //creamos un temporal de tipo NodeDE
        Node temp=this.head;//igualamos el temporal a la head
        int contador=1;//iniciamos el contador en uno
        if (bike.getNumberBike().equals(temp.getData().getNumberBike())){//si el numero de la bike es igual al primero
            head=temp.getNext();//la cabeza pasa a ser el siguiente del temporal
            head.setPrevius(null);//el anterior del head queda null
        }
        while (temp!=null){//hace que rrecora toda la lista
            if (bike.getNumberBike().equals(temp.getData().getNumberBike())){
                temp.setNext(temp.getNext().getNext());//el siguente del temporal pasa a ser siguiente siguiente
                temp.getNext().getNext().setPrevius(temp);//guardamos en el previo del siguiente siguiente al temporal
            }
            temp=temp.getNext();//el temporal pasa a ser su siguiente
            contador=contador+1;//contador aumenta en uno

        }
        size--;//contrario al size++ en este caso el tamaño se reduce uno
        return "eliminado";
    }


    public Bike obtenerbike(String numberbike){//se el ingresa de entrada el numero de la bike que va a delantar
        //creamos un temporal de tipo NodeDE
        Node temp=this.head;//igualamos el temporal a la head
        int contador=1;//iniciamos el contador en uno
        if (numberbike==head.getData().getNumberBike()){//si la posicion ingresada es la primera
            return head.getData();//retornamos la bike
        }
        while (contador<size){//hace que recorra toda la lista
            if (temp.getData().getNumberBike().equals(numberbike)){
                return temp.getData();
            }
            temp=temp.getNext();//el temporal pasa a ser su siguiente
            contador=contador+1;//contador aumenta en uno

        }
        return temp.getData();
    }

    public String addByPosition(BikePosition bikePosition)  {
        Node temp=this.head;//creamos un temporal de nodeDE
        int contador=1;//iniciamos un contador en uno
        //creamos un kid de los datos del kidDTO
        Bike newbike=bikePosition.getBike();


        Node newKid = new Node(newbike);//ingresamos el kid en un nodoDE
        if (bikePosition.getPosition() == 1) {//si la posicion del DTO es igual a 1 se ingresa de primero
            newKid.setNext(temp);//guardamos al temporal en el set del nuevo nodo
            newKid.setPrevius(null);//le decimos que su previo es null
            head = newKid;//la nueva cabeza pasa a ser el nuevokid
        }
        while (contador < bikePosition.getPosition()) {//mientras el contador sea menor a la posicion ingresada
            //hace que se quede en una posicion antes

            if (contador == bikePosition.position - 1) {//contador igual a la posicion menos uno verifica que si este en una posicion antes
                newKid.setNext(temp.getNext());//gaurdamos en el siguente del nuevo al siguiente del temporal
                newKid.setPrevius(temp);//gardamos en el anterior del nuevo al temporal
                temp.setNext(newKid);//guarda al siguiente del temporal al nuevo
                temp.getNext().setPrevius(newKid);//guardamos al siguiente del temporal su previo el nuevo
            }
            temp = temp.getNext();//el temporal pasa a ser el siguiente
            contador = contador + 1;//contador aumenta en uno

        }

        return "agregado ";
    }

    public Node getHead() {
        return head;
    }
}


