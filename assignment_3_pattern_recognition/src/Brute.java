/**
 * Created by nantu on 15/4/8.
 */
public class Brute {
    public static void main(String[] args){
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        for (int i = 0 ; i < N;i ++){
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x,y);
            System.out.println(p.toString());
            p.draw();
        }
        StdDraw.show(0);
    }
}
