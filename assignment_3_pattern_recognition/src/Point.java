/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public static final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
        @Override
        public int compare(Point t1, Point t2) {
            Point t0 = new Point(0,0);
            if (t0.slopeTo(t1) < t0.slopeTo(t2)) {
                return -1;
            } else if(t0.slopeTo(t1) == t0.slopeTo(t2)) {
                return 0;
            }else{
                return 1;
            }
        }
    };       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate
    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        if(that.x - this.x == 0 && that.y - this.y == 0) return -Double.MAX_VALUE;
        else if(that.x - this.x == 0) // 垂直的线
            return Double.MAX_VALUE;
        else if (that.y - this.y == 0){
            return +0.0;
        }
        else{
            return (that.y - this.y) / (double)(that.x - this.x);

        }
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        if((that.y<this.y) ||((that.y==this.y)&&(that.x<this.x))){
            return 1;
        }else if(that.y == this.y && this.x == that.x){
            return 0;
        }else{
            return -1;
        }
    }
    public Comparator<Point> compareBySlope(){
        return SLOPE_ORDER;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}