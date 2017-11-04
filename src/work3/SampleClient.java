package work3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by starsea on 17-11-4.
 */
public class SampleClient {
    public static void main(String[] args){
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for(int i=0; i<n; i++){
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x,y);
            StdOut.println(points[i]);
        }
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0,32768);
        StdDraw.setYscale(0, 32768);
        for(Point p:points){
            p.draw();
        }
        StdDraw.show();
//        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        StdOut.println(collinear.numberOfSegments());
        for(LineSegment segment:collinear.segments()){
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
