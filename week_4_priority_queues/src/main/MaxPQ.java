package main;

import java.util.Arrays;

/**
 * Created by nantu on 15/4/17.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key data[];
    private int N =0; // N is the number of whole heap
    public MaxPQ(){}
    public MaxPQ(int capacity){
        data = (Key []) new Comparable[capacity+1]; //start 1
    }
    public void insert(Key v){
        data[++N] = v;
        swim(N);
    }
    public Key delMax(){
//        del the max of the heap
        Key te = data[1];
        exch(N--,1);
        sink(1);
        data[N+1] = null;
        return te;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public Key max(){
        return data[1];
    }
    public Key[] getHeap(){
        return data;
    }
    public int size(){
        return N;
    }
    private void swim(int k){
//        swim to the top
//        compare k with the father and if not stable compare with father's father and so on..
        while(k > 1 && less(k/2,k)){ // children node
            exch(k,k/2);
            k = k/2;
        }
    }
    private void sink(int k){
//        sink to the suitable place
//        check the current node is stable ,if not exchange it with the larger child node
        while( 2*k <= N ){ //current node's children small than the length of heap
            int j = 2*k;
            if(j < N && less(j,j+1)) j++;   //choose the bigger child in children and make sure legal
            if(!less(k,j)) break; //node k is stable
            exch(j,k);
            k = j;
        }
    }

    private boolean less(int i,int j){
        return data[i].compareTo(data[j]) < 0;
    }
    private void exch(int i,int j){
        Key t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

}
