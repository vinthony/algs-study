package main;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by nantu on 15/2/23.
 */
public class Deque<Item> implements Iterable<Item>  {
    private int count = 0;
    private Node first;
    private Node last;
    public class Node{
        Item value;
        Node next;
        Node prev;
    }
    public Deque()                           // construct an empty deque
    {

    }
    public boolean isEmpty()                 // is the deque empty?
    {
        return count == 0;
    }
    public int size()                        // return the number of items on the deque
    {
        return count;
    }
    public void addFirst(Item item)          // add the item to the front
    {
        if(item == null) throw new NullPointerException("no such item"+item);
        Node old_first = first;
        first = new Node();
        first.value = item;
        if(isEmpty()) last = first;
        if(old_first!=null)
            old_first.prev = first;
        first.next = old_first;
        count++;

    }
    public void addLast(Item item)           // add the item to the end
    {
        if(item == null) throw new NullPointerException("no such item"+item);
        Node old_last = last;
        last = new Node();
        last.value = item;
        if(isEmpty()) first = last;
        if(old_last!=null)
            old_last.next = last;
        last.prev = old_last;
        count++;
    }
    public Item removeFirst()                // remove and return the item from the front
    {
        if(isEmpty()) throw new NoSuchElementException("queuq empty");
        Item outer = first.value;
        first = first.next;
        count--;
        return outer;
    }
    public Item removeLast()                 // remove and return the item from the end
    {
        if(isEmpty()) throw new NoSuchElementException("queuq empty");
        Item outer = last.value;
        last = last.prev;
        count--;
        return outer;

    }
    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<Item>{

        @Override
        public boolean hasNext() {
            return last.next != null;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException("no more elements");
            return removeLast();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("unsupport method");
        }
    }
    public static void main(String[] args)   // unit testing
    {

    }
}

