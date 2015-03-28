package main;

/**
 * Created by nantu on 15/3/4.
 */
public class MergeSort {
    // merge sort
    // 传入一个a[]
    public static void merge(Comparable a[],Comparable aux[],int lo,int mid,int hi){
        // 首先复制数组
        for(int i = lo;i<hi;i++){
            aux[i] = a[i];
        }
        // 定义两部分的最小值
        int i = lo , j = mid+1;
        for (int k = lo;k<=hi;k++){
            if (i>mid)      a[k] = aux[j++];//记录索引，如果超出低部分则直接从高的部分取
            else if(j>hi)   a[k] = aux[i++];//如果超过高的部分，则直接从低得部分加
            else if(less(aux[j],aux[i])) a[k] = aux[j++];//将小得数放在a[k]中
            else a[k] = aux[i++];
        }

    }
    public static void sort(Comparable a[],Comparable aux[],int lo,int hi){
        if(hi<=lo) return;
        int mid = lo +(hi-lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }
    public static void sort(Comparable a[]){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }
    private boolean isSorted(Comparable a[]){
        for (int i = 0 ; i < a.length ; i++){
            if(!less(a[i],a[i+1]))
                return false;
        }
        return true;
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0 ;
    }
}
