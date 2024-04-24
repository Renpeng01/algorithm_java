package org.example.chapter1;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    public Bag(){}

    void add(Item item){}

    boolean isEmpty(){
        return false;
    }

    int size(){
        return 0;
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
