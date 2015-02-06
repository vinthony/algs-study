package main;

import org.junit.Assert;
import org.junit.Test;

public class Binary_searchTest {

    @Test
    public void testFunc() throws Exception {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        Assert.assertEquals(Binary_search.func(arr, 4),3);
        //three sum problem;
        int[] a = {-40,-20,-10,0,5,10,30,40};
        int count = 0;
        //O(N*N*lgN)
        for (int i = 0;i< a.length ;i++){
            for (int j = 0;j<a.length;j++){
                if(Binary_search.func(a,-(a[i]+a[j])) > -1 && a[i] < a[j] ){
                    count++;
                }
            }
        }
        Assert.assertEquals(15,count);
    }
}