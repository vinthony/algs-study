/**
 * Created by nantu on 15/2/17.
 */
package main;

import java.util.Random;

public class PercolationStats {
    private int num;
    private int count;
    private double[] times;
    private Percolation p;
    public PercolationStats(int N,int T){
        if( N<=0 || T <=0 ) throw new IllegalArgumentException("<0");
        num = N;
        count = T;
        times = new double[T];
        for (int i=0;i<count;i++){
            int mmm = 0;
            p = new Percolation(num);
            while(!p.percolates()){
                p.open(getRandomInt(),getRandomInt());
                mmm++;
            }
            times[i] = (double)mmm/(double)(num*num);
        }
    }
    public double mean(){
        double x=0.0;
        for (int i = 0;i<count;i++){
            x += times[i];
        }
        return x/count;
    }
    public double stddev(){
        double standard = 0.0;
        double mean = mean();
        for (int i = 0;i<count;i++){
            standard += (times[i]-mean)*(times[i]-mean);
        }
        return Math.sqrt(standard/(count-1));
    }
    public double confidenceLo(){
        double mean = mean();
        double standard = stddev();
        return mean - 1.96*standard/(Math.sqrt(count));
    }
    public double confidenceHi(){
        double mean = mean();
        double standard = stddev();
        return mean + 1.96*standard/(Math.sqrt(count));
    }
    private int getRandomInt(){
        Random random = new Random();
        return random.nextInt(count)+1;
    }
    public static void main(String[] args){
        int N=Integer.parseInt("200");
        int T=Integer.parseInt("100");
        PercolationStats s = new PercolationStats(N,T);
        System.out.println("mean\t\t\t= " + s.mean());
        System.out.println("stddev\t\t\t= " + s.stddev());
        System.out.println("95% confidence interval\t= " + s.confidenceLo() + "," + s.confidenceHi());
    }
}
