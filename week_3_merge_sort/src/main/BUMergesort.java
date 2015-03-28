package main;

import java.util.Arrays;

/**
 * Created by nantu on 15/3/28.
 */
public class BUMergesort {
    public static void merge(Comparable a[],Comparable aux[],int lo,int mid,int hi){
        //copy to aux
        for (int i = lo; i <=hi;i++ ){
            aux[i] = a[i];
        }
        System.out.println(lo+","+mid+","+hi);
        //定义两部分最小值
        int i = lo;int j = mid+1;
        for (int k = lo;k <= hi;k++){
            if(i > mid)  a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(aux[i],aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
    private static boolean less(Comparable v,Comparable t){
        return v.compareTo(t) < 0;
    }
    private static void sort(Comparable a[]){
        int N = a.length;
        Comparable aux[] = new Comparable[N];
        for (int sz=1 ; sz<N;sz=sz+sz){//logN
            for (int lo = 0;lo<N-sz;lo += sz+sz)//logN
                merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
        }
    }
    public static void main(String args[]){
        String[] x = {"1","6","5","7","8","2","3","9"};
        BUMergesort.sort(x);
        System.out.println(Arrays.toString(x));
    }
}
