package main;

/**
 * Created by nantu on 15/2/1.
 */

public class QuickFind implements UFModule {

    private int[] arr;

    public QuickFind(int num){
        arr = new int[num];
        for (int i = 0 ; i < num ;i++ ){
            arr[i] = i;
        }
    }
    @Override
    public void union(int a, int b) {
        int a1 = arr[a];
        int a2 = arr[b];
        for (int i = 0 ;i < arr.length ; i++ ) {
            if (a2 == arr[i]) {
                arr[i] = a1;
            }
        }

    }

    @Override
    public boolean connected(int a, int b) {
        return arr[a] == arr[b];
    }
}
