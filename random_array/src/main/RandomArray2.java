package main;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by nantu on 15/2/22.
 */
public class RandomArray2 {
    private int min;
    private int max;
    private int[] collec;
    private int count;
    public RandomArray2(int min ,int max){
        if (min > max || min == max) throw new IllegalArgumentException("bad arguments");
        min = min;
        max = max;
        count = max - min + 1;
        collec = new int[count];
            /* 生成序列 O(n)*/
        for (int i = min; i <= max; i++) {
            collec[i - min] = i;
        }
        for (int i = 1;i <= max-min;i++){
            Random r = new Random();
            int ex = r.nextInt(i);
            exchange(ex,i);
        }
    }
    public String getArray(){
        System.out.println(collec.length);
        return Arrays.toString(collec);}
    private void exchange(int i,int j){
        int temp = collec[i];
        collec[i] = collec[j];
        collec[j] = temp;
    }
    public static void main(String[] strings){
        RandomArray2 ra2 = new RandomArray2(0,10000);
        System.out.println(ra2.getArray());
    }
}
