/**
 * Created by nantu on 15/2/6.
 */
package main;

public class Binary_search {
    public static int func(int[] arr,int key){
        int starter = 0;
        int ender = arr.length-1;
        while(starter <= ender) {
            int mid = starter + (ender - starter) / 2;
            if (key < arr[mid]) ender = mid - 1;
            else if (key > arr[mid]) starter = mid + 1;
            else return mid;
        }
        return -1;
    }
}
