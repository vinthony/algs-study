package main;

/**
 * Created by nantu on 15/2/1.
 */
public class QuickUnion implements UFModule {
    private int[] arr;
    private int[] size;

    public QuickUnion(int num){
        arr = new int[num];
        size = new int[num];
        for (int i = 0 ; i < num ;i++ ){
            arr[i] = i;
        }
    }
    @Override
    public void union(int a, int b) {
        int a1 = findRoot(a);
        int a2 = findRoot(b);

        //old step

        //arr[a1] = arr[a2];

        // improvement avoid tall tree
        if(a1 == a2) return;
        if( size[a1] < size[a2] ){
            arr[a1] = a2; size[a1]++;
        }else{
            arr[a2] = a1; size[a2]++;
        }
    }

    @Override
    public boolean connected(int a, int b) {
        // has the same root or not
        if(findRoot(a) == findRoot(b)) return true;
        return false;
    }
    private int findRoot(int i){
        if(arr[i] != i )
            //impovement path compression
            return findRoot(arr[i]);
          //  return findRoot(findRoot(arr[i]));
        else
            return arr[i];
    }
    public String getArray(){
        String str="";
        for (int i = 0;i<arr.length;i++){
            str += arr[i]+" ";
        }
        return str;
    }
}
