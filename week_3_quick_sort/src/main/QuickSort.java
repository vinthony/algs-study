package main;

import java.util.Arrays;

/**
 * Created by nantu on 15/3/30.
 */
public class QuickSort {
    public static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private static int partition(Comparable[] a,int lo,int hi){
        //确定边界
        int i = lo; int j = hi+1;
        while(true){
            while(less(a[++i],a[lo])) if(i == hi) break;//找到最大的
            while(less(a[lo],a[--j])) if(j == lo) break;//找到最小的
            if(i >= j) break;
            System.out.println(i+" "+j);
            exch(a, i, j);
        }
        System.out.println(lo+" "+j);
        exch(a,lo,j);
        return j;
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable a[],int i ,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String args[]){
        String[] a = {"1","6","8","5","4"};
        QuickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
