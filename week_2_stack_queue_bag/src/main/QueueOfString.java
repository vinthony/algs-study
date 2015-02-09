package main;

/**
 * Created by nantu on 15/2/9.
 */
public class QueueOfString {

    private Node first,last;

    private class Node{
        Node next;
        String item;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void enqueue(String str){
        Node old = last;
        last = new Node();
        last.item = str;
        last.next = null;
        if(isEmpty()) first = last;
        else old.next = last;
    }
    public String dequeue(){
        //先进先出
        String item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item;
    }

}
