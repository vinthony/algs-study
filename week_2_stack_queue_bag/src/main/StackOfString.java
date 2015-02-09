package main;

/**
 * Created by nantu on 15/2/9.
 */
public class StackOfString {

    private Node first = null;

    private class Node{
        Node next;
        String item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String str){
        Node old = first;
        first = new Node();
        first.item = str;
        first.next = old;
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }
}
