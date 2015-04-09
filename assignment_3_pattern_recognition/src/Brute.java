/**
 * Created by nantu on 15/4/8.
 */
public class Brute {
    public static void main(String[] args){
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
        for (int i = 0;i<N;i++){
            Point p1 = arr[i];
            for (int j = 0 ; j<N;j++){
                Point p2 = arr[j];
                for (int k = 0; k<N;k++){
                    Point p3 = arr[k];
                    for(int m = 0;m<N;m++) {
                        Point p4 = arr[m];
                        if (p1.compareTo(p2) < 0 && p2.compareTo(p3) <0 && p3.compareTo(p4)<0) {
                            if (p1.slopeTo(p2) == p1.slopeTo(p3) && p1.slopeTo(p2) == p1.slopeTo(p4))
                                p1.drawTo(p2);
                                p2.drawTo(p3);
                                p3.drawTo(p4);
                                StdOut.println(p1.toString() + "->" + p2.toString() + "->" + p3.toString() + "->" + p4.toString());
                        }
                    }
                }
            }
        }
        StdDraw.show(0);
        StdDraw.setPenRadius();
    }
}
