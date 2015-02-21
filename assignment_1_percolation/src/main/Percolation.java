//import main.WeightedQuickUnionUF;
package main;

import java.util.Random;

/**
 * Created by nantu on 15/2/17.
 */
public class Percolation {
    private int[] state;
    private int virtualTop;
    private int virtualBottom;
    WeightedQuickUnionUF wq;
    private int count;
    private int open_count=0;
    private int opend= -2;
    private int layer;
    public Percolation(int N){
//        创建一个N*N的全部点block的矩阵
        if(N<=0) throw new IllegalArgumentException("illegal arugment");
        count = N*N;
        layer = N;
        state = new int[count];
        //包含virtualTop 和virtualBottom 和 opend
        wq = new WeightedQuickUnionUF(count+2);
        for(int i=0;i<count;i++){
            state[i] = -1;
        }
        virtualTop = count;
        virtualBottom = count+1;
    }
    public void open(int i,int j){
//        将(i,j)点变成unblock状态 相当于连接(j,i)周围四个点
//        特殊点【四个角，四条边】
        if(i<=0||j<=0||i>layer||j>layer) throw new IndexOutOfBoundsException("out of array");
        if(isOpen(i,j)) return;
        int pointW = getPosByXY(i,j);
        state[pointW] = opend;
        open_count++;
        if(i == 1){ // 第一层
            wq.union(pointW,virtualTop);//连接天
            reunion(i,j,1,0);//下一层
            if(j != 1)reunion(i,j,0,-1);//连接左右
            if(j != layer) reunion(i,j,0,1);
        }else if(i == layer) //最后一层
        {
            // wq.union(pointW,virtualBottom);
            reunion(i,j,-1,0);//上一层
            if(j != 1) reunion(i,j,0,-1);
            if(j != layer) reunion(i,j,0,1);
        }else if(j == 1) //第一列
        {
            reunion(i,j,-1,0);
            reunion(i,j,1,0);
            reunion(i,j,0,1);
        }else if( j == layer){ //最后一列
            reunion(i,j,-1,0);
            reunion(i,j,1,0);
            reunion(i,j,0,-1);
        }else{ //正常情况
            reunion(i,j,-1,0);
            reunion(i,j,1,0);
            reunion(i,j,0,1);
            reunion(i,j,0,-1);
        }
    }
    public boolean isOpen(int i,int j){
//        (i,j)点是否unblock
        if(i<=0||j<=0||i>layer||j>layer) throw new IndexOutOfBoundsException("out of array");
        int pointW = getPosByXY(i,j);
        return state[pointW] == opend;//没open
    }
    public boolean isFull(int i,int j){
//        (i,j)点是否为上下路径上的点
        if(i<=0||j<=0||i>layer||j>layer) throw new IndexOutOfBoundsException("out of array");
        int pointW = getPosByXY(i,j);
        return wq.connected(pointW,virtualTop);
    }
    public boolean percolates(){
//        该图是否满足percolate
        for(int i=1;i<=layer;i++){
            int pointW=getPosByXY(layer,i);
            if(wq.connected(pointW,virtualTop))
                return true;
        }
        return false;
    }
    public void openRandomPos(){
        Random random= new Random();
        int n=random.nextInt(count);
        while(state[n] == -2){
            n = random.nextInt(count);
        }
        int i = n/layer + 1;
        int j = n%layer + 1;
        open(i,j);
    }
    public int getOpendCount(){
        return open_count;
    }
    private int getPosByXY(int i,int j){
        return (i-1)*layer + j-1;
    }
    private void reunion(int i,int j,int offsetI,int offsetJ){
        int pos = getPosByXY(i,j);
        int offset = offsetI*layer+offsetJ;
        if(isOpen(i+offsetI,j+offsetJ))
            wq.union(pos,pos+offset);
    }
    public static void main(String[] args){
//        test client
        Percolation p = new Percolation(100);
        for (int i = 1;i<=100;i++ ){
            p.open(i,10);
        }
        System.out.println(p.isOpen(50, 10));
        System.out.println(p.percolates());
    }
}
