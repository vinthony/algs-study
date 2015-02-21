/**
 * Created by nantu on 15/2/17.
 */
package main;

public class PercolationStats {
    private int num; // 数组的大小
    private int count; // 次数
    private double[] times;
    private int[] status;
    private Percolation p;
    public PercolationStats(int N,int T){
        if( N<=0 || T <=0 ) throw new IllegalArgumentException("<0");
        num = N;
        count = T;
        times = new double[T];
        for (int i=0;i<count;i++){
            p = new Percolation(num);
            while(p.percolates() != true){
              //  System.out.println("random integer:" + x+","+y);
                p.openRandomPos();
            }
            int mmm = p.getOpendCount();
            times[i] = (double)mmm/(double)(num*num);
            System.out.println(times[i]+","+mmm+","+num*num);
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
        System.out.println(mean);
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
    public static void main(String[] args){
        int N=Integer.parseInt("200");
        int T=Integer.parseInt("100");
        PercolationStats s = new PercolationStats(N,T);
        System.out.println("mean\t\t\t= " + s.mean());
        System.out.println("stddev\t\t\t= " + s.stddev());
        System.out.println("95% confidence interval\t= " + s.confidenceLo() + "," + s.confidenceHi());
    }
}
