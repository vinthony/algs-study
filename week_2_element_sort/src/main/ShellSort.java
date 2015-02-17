package main;

/**
 * Created by nantu on 15/2/16.
 */
public class ShellSort {
    public static Comparable[] sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h+1;
        while (h >= 1){
            for (int i = h ;i < N;i++){
                for (int j = i; j >= h && Utils.less(a[j],a[j-h]);j-=h){
                  Utils.exchange(a,j,j-h);
                }
            }
            h/=3;
        }
        return a;
    }
}
