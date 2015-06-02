package main;

import java.util.Arrays;

/**
 * Created by nantu on 15/4/17.
 */
public class HeapSort {
    public static void sort(String s[]){
        int N = s.length;
        MaxPQ<String>pq = new MaxPQ<String>(N);
        for (int i = 0;i < N; i++){
            pq.insert(s[i]);
        }
        for (int i = N -1 ; i >= 0;i--){
            s[i] = pq.delMax();
        }
    }
}
