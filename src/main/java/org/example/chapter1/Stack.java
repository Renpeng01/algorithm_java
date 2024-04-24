package org.example.chapter1;

import org.w3c.dom.Node;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;


    private class Node{
        Item item;
        Node next;
    }

    public Stack(){}

    public int size(){return N;}

    public void push(Item item)  {
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        first.item = item;
        N++;
    }
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
