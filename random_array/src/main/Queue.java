package main;

/**
 * Created by nantu on 15/2/21.
 */
public class Queue {
    private int[] array;
    private int N = 0;
    public Queue(){
        array = new int[1];
    }
    public void enqueue(int i){
        if(N == array.length) resize( array.length * 2 );
        array[N++] = i;
    }
    public int dequeue(){
        int re = array[--N];
        if(N>0 && N == array.length/4) resize( array.length / 2);
        return re;
    }
    public void resize(int n){
        int[] temp = new int[n];
        for (int i = 0 ; i < N ; i++){
            temp[i] = array[i];
        }
        array = temp;
    }
}

