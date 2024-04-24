package org.example.chapter1;

import org.w3c.dom.Node;

import java.util.Iterator;

public class Queue <Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public Queue(){}

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
        }else{
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue(){
        if (isEmpty()){
            return null;
        }
        Item item = first.item;
        first = first.next;
        // 这里容易遗漏
        if (isEmpty()){
            last = null;
        }
        N--;
        return item;
    }

    public int size(){return N;}

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
