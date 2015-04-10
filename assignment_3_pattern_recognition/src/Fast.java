/**
 * Created by nantu on 15/4/9.
 */
public class Fast {
    public static void main(String args[]){
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] arr = new Point[N];
        for (int i = 0; i<N ;i++){
            Point p =new Point(in.readInt(),in.readInt());
            arr[i] = p;
           p.draw();
        }
        QuickSort.sort(arr);
        for (int i = 1;i<=1;i++){
            Point origin = arr[i];
            //得到斜率
            QuickSort.sort(arr, Point.SLOPE_ORDER);
            //double Comparable?
            Point[] n = new Point[N];
            for (int m = 0,ii=0;m <arr.length;m++){
                //斜率相等 并且 不等于origin元素。
                Double slopes = origin.slopeTo(arr[m]);
                try {
                    while(slopes.equals(origin.slopeTo(arr[m+1]))){
                        n[ii++] = arr[m];
                        m++;
                    }
                }catch (Exception e){
                    n[ii++]=arr[m];
                }
                if(ii==0) continue;
                String str = origin.toString();
                for (int q = 0 ;q<ii;q++){
                    origin.drawTo(n[q]);
                    str += "->"+n[q].toString();
                }
                StdOut.println(ii+":"+str);
            }
        }
        StdDraw.show(0);

    }
}
