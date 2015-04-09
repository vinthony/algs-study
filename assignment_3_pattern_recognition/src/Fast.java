import java.util.Arrays;

/**
 * Created by nantu on 15/4/9.
 */
public class Fast {
    public static void main(String args[]){
//        StdDraw.setXscale(0, 32768);
//        StdDraw.setYscale(0, 32768);
//        StdDraw.show(0);
//        StdDraw.setPenRadius(0.01);
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] arr = new Point[N];
        for (int i = 0; i<N ;i++){
            Point p =new Point(in.readInt(),in.readInt());
            arr[i] = p;
           // p.draw();
        }
        QuickSort.sort(arr);
//        System.out.println(Arrays.toString(arr));
        for (int i = 0;i<arr.length;i++){
            Point origin = arr[i];
            //得到斜率
            Comparable[] slopes = new Comparable[N];
            for (int k = 0;k<arr.length;k++){
                slopes[k] = origin.slopeTo(arr[k]);
            }
//            System.out.println(Arrays.toString(slopes));
            QuickSort.sort(slopes);
            System.out.println(Arrays.toString(slopes));
            //double Comparable?
            Point[] n = new Point[N];
            Comparable current = 0.0;
            for (int m = 0,ii=0;m <slopes.length;m++){
//                System.out.println(Arrays.toString(slopes));
                if(slopes[m].equals(current)&&origin.compareTo(arr[m])!=0){
                    n[ii] = arr[m];
                    if(n[ii].compareTo(arr[m])>0){
                        ii = 0;
                        current = slopes[m];
                    }else{
                        ii++;
                    }
                }else{
                    if(ii==0) continue;
                    String str = origin.toString();
//                    System.out.println(Arrays.toString(n));
                    for (int q = 0 ;q<ii;q++){
                        str += "->"+n[q].toString();
                    }
                    ii = 0;
                    current = slopes[m];
//                    StdOut.println(str);
                }
            }
        }

    }
}
