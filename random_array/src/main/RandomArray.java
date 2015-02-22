package main;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by nantu on 15/2/21.
 */
class RandomArray {
    private int min;
    private int max;
    private int[] collec;
    private int count;
    private int N;
    private int range;
    private Queue q;
    public RandomArray(int min,int max) {
        if (min > max || min == max) throw new IllegalArgumentException("bad arguments");
        count = max - min + 1;
        N = count;
        collec = new int[count];
            /* 生成序列 O(n)*/
        for (int i = min; i <= max; i++) {
            collec[i - min] = i;
        }
        range = min - 1;
        q = new Queue();
        // shuffling
        while(count>0){
            Random r  = new Random();
            int d = r.nextInt(max+1)+min;
            if(collec[d] == range) continue;
            q.enqueue(collec[d]);
            collec[d] = range;
            count--;
        }
    }
    public String getArray(){
        return Arrays.toString(collec);
    }
    public int next(){
        N--;
        return q.dequeue();
    }
    public boolean hasNext(){
        return N!=0;
    }
    public static void main(String[] args) {
        RandomArray ra = new RandomArray(0,10000);
        while(ra.hasNext()){
            System.out.println(ra.next());
        }
    }
}
