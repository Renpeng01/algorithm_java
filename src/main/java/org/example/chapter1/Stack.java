package org.example.chapter1;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    public Stack(){}

    void push(Item item) {}

    public Item pop() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
