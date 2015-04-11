import java.util.Arrays;

/**
 * Created by nantu on 15/4/9.
 */
public class Fast {
    public static void main(String args[]){
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] arr = new Point[N];
        for (int i = 0; i<N ;i++){
            Point p =new Point(in.readInt(),in.readInt());
            arr[i] = p;
           p.draw();
        }
        for (Point origin : arr) {
            //按斜率排序
            QuickSort.sort(arr, origin.SLOPE_ORDER);
            Point[] n = new Point[N];
            Double last_slopes = null;
            int alignedPoints = 0;
            for (Point point : arr) {
                if (point == origin) continue;
                Double s = origin.slopeTo(point); //计算出斜率
                if (s.equals(last_slopes)) { // 如果和上次的斜率相等
                    n[alignedPoints++] = point; //放入collection
                } else {
                    if (alignedPoints >=3) {//不相等，如果有三个炼成直线
                        showLines(origin, n, alignedPoints);//打印
                    }
                    alignedPoints = 1;
                    n[0] = point;
                }
                last_slopes = s;
            }
            if (alignedPoints >= 3) {
                showLines(origin,n,alignedPoints);
            }
        }
        StdDraw.show(0);
    }
    public static void showLines(Point origin,Point[] n,int size){
        String str = origin.toString();
        Arrays.sort(n, 0, size);
        if(origin.compareTo(n[0])>0) return;
        for (int q = 0; q < size; q++) {
            origin.drawTo(n[q]);
            str += "->" + n[q].toString();
        }
        StdOut.println((size + 1) + ":" + str);
    }

}
