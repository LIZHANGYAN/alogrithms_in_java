package work3;
import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Created by starsea on 17-11-2.
 */
public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void draw(){
        StdDraw.point(x,y);
        StdDraw.circle(x,y,200);
    }
    public void drawTo(Point that){

        StdDraw.line(this.x,this.y,that.x,that.y);
    }

    public int compareTo(Point that){
        int diff = this.y - that.y;
        if(diff == 0)
            diff = this.x - that.x;
        return diff;
    }


    public double slopeTo(Point that){
        if(this.y - that.y == 0) {
            if (this.x - that.x == 0)
                return Double.NEGATIVE_INFINITY;
            return 0;
        }else if(this.x - that.x == 0)
            return Double.POSITIVE_INFINITY;
        return (that.y - this.y) /(double)(that.x - this.x);
    }

    public Comparator<Point> slopeOrder(){
        return new Comparator<Point>(){

            @Override
            public int compare(Point p1, Point p2) {
                double slopeDiff = slopeTo(p1) - slopeTo(p2);
                if(slopeDiff > 0)
                    return 1;
                else if (slopeDiff < 0)
                    return -1;
                else
                    return 0;
            }
        };
    }

    public String toString(){
        return "("+this.x+","+this.y+")";
    }

//    public static void main(String[] args){
//        System.out.println("Hello");
//        Point p1 = new Point(1,2);
//        p1.toString();
//        p1.draw();
//        Point p2 = new Point(5,6);
//        p2.draw();
//        p1.drawTo(p2);
//
//    }
}
