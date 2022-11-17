package com.umanizales.bikeraces.model;

import lombok.Data;

@Data
public class Node {
    private Bike data;
    private Node next;
    private Node previous;





    public Node(Bike data) {
        this.data = data;
    }


    public Node(Bike bike, Object o, Node temp) {
    }

    public void setPrevius(Object o) {
    }
}
