package main;

/**
 * Created by nantu on 15/2/17.
 */
public class WeightedQuickUnionUF {
    private int[] arr;
    private int[] count;
    public WeightedQuickUnionUF(int n){
        arr = new int[n+2];
        count = new int[n+2];
        for (int i = 0 ; i < n;i++){
            arr[i] = i;
        }
    }
    public void union(int i,int j){
        int ri = findroot(i);
        int rj = findroot(j);
        if( ri == rj) return;
        if(count[ri] < count[rj]){
            arr[ri] = rj;
            count[ri]++;
        }else{
            arr[rj] = ri;
            count[rj]++;
        }
    }
    public boolean connected(int a,int b){
        return findroot(a)==findroot(b);
    }
    private int findroot(int a){
        while(arr[a] != a){
            a = arr[a];
        }
        return a;
    }
}
