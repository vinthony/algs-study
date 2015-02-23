package main;

import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by nantu on 15/2/23.
 */
@SuppressWarnings("unchecked")
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int count = 0;
    private Object[] collect;
    public RandomizedQueue()                 // construct an empty randomized queue
    {
        collect = new Object[1];
    }
    public boolean isEmpty()                 // is the queue empty?
    {
        return count==0;
    }
    public int size()                        // return the number of items on the queue
    {
        return count;
    }
    public void enqueue(Item item)           // add the item
    {
        if(item == null) throw new NullPointerException("no such item"+item);
        if(collect.length <= count ) resize(count *2);
        collect[count++] = item;
        Random random = new Random(new Date().getTime());
        int x = random.nextInt(count);
        swap(x,count-1);
    }
    public Item dequeue()                    // remove and return a random item
    {
        if(isEmpty()) throw new NoSuchElementException("queuq empty");
        if(collect.length > 0 && collect.length < count/4 ) resize(count/2);
        Object o = collect[--count];
        collect[count] = null;
        return (Item)o;
    }
    public Item sample()                     // return (but do not remove) a random item
    {
        if(isEmpty()) throw new NoSuchElementException("queuq empty");
        Random random = new Random();
        int x = random.nextInt(count);
        return (Item)collect[x];

    }
    private void swap(int x,int y){
        Object temp = collect[x];
        collect[x] = collect[y];
        collect[y] = temp;
    }
    private void resize(int n){
        Object[] temp = new Object[n];
        for (int i = 0 ; i<count;i++){
            temp[i] = collect[i];
        }
        collect = temp;
    }
    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
        return new myIterator();
    }
    private class myIterator implements Iterator<Item>{
        private int my_count = 0;
        private Object[] my_collect;
        public myIterator(){
            my_collect = new Object[count];
            System.arraycopy(collect,0,my_collect,0,count);
            // generating a random order;
            for (int i = 0;i<count;i++){
                Random random = new Random(new Date().getTime());
                int x = random.nextInt(count);
                swap(x,i);
            }
        }
        @Override
        public boolean hasNext() {
            return my_count != count;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException("no more items");
            return (Item)my_collect[my_count++];
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
