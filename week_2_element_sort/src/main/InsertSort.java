package main;

/**
 * Created by nantu on 15/2/16.
 */
public class InsertSort {
    public static Comparable[] sort(Comparable[] a){
        for (int i = 0 ; i < a.length ; i++){
           for (int j = i;j > 0 ; j--){
               if(Utils.less(a[j],a[j-1])) Utils.exchange(a,j-1,j);
               else break;
           }
        }
        return a;
    }
}
