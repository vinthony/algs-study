package main;

/**
 * Created by nantu on 15/2/16.
 */
public class SelectSort {
    public static Comparable[] sort_my(Comparable[] a){
        int j,i;
        for (i = 0 ; i < a.length ; i++){
            for (j = i; j < a.length ; j++)
                if(Utils.less(a[j],a[i])) Utils.exchange(a,i,j);
        }
        return a;
    }
    public static Comparable[] sort(Comparable[] a){/* a more fast way */
        int j,i,min;
        for (i = 0 ; i < a.length ; i++){
            min = i;
            for (j = min+1 ; j < a.length ; j++)
                if(Utils.less(a[j],a[min])) min = j;
            Utils.exchange(a,i,min);
        }
        return a;
    }
}
