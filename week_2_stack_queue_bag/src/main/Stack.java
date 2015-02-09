package main;

import java.util.Iterator;

/**
 * Created by nantu on 15/2/9.
 */
public class Stack<Item> implements Iterable<Item> {

    private Node first = null;

    private class Node{
        Node next;
        Item item;
    }
    public Iterator<Item> iterator() { return new ListIterator(); }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){ return current != null; }
        public void remove(){/* not use*/}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    public boolean isEmpty(){
        return first == null;
    }

    public void push(Item str){
        Node old = first;
        first = new Node();
        first.item = str;
        first.next = old;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        return item;
    }
}
