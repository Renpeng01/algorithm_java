package org.example.chapter1;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private class Node{
        Item item;
        Node next;
    }

    private Node first;
    private int N;

    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }
}
