package main;

/**
 * Created by nantu on 15/2/16.
 */
public  class Utils {
    public static boolean less(Comparable v,Comparable w){
//        判断大小
        return v.compareTo(w) < 0 ;
    }
    public static void exchange(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static boolean isSorted(Comparable[] a){
        for (int i = 0 ; i < a.length ; i++ )
            if(less(a[i],a[i-1])) return false;
        return true;
    }
}
