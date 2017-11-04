package work3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by starsea on 17-11-3.
 */
public class BruteCollinearPoints {

    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points){
        checkPoints(points);
        ArrayList<LineSegment> foundSegments = new ArrayList<>();
        int length = points.length;
        Point[]  pointsCopy = Arrays.copyOf(points,length);
        Arrays.sort(pointsCopy);
        for (int p = 0; p<length - 3; p++){
            for(int q = p+1; q<length-2; q++){
                for(int r = q+1; r<length-1; r++){
                    for(int s=r+1; s<length; s++){
                        if(pointsCopy[p].slopeTo(pointsCopy[q]) ==
                                pointsCopy[p].slopeTo(pointsCopy[r]) &&
                                pointsCopy[p].slopeTo(pointsCopy[q])==
                                pointsCopy[p].slopeTo(pointsCopy[s])){
                            foundSegments.add(new LineSegment(pointsCopy[p],pointsCopy[s]));
                        }
                    }
                }
            }
        }
        segments = foundSegments.toArray(new LineSegment[foundSegments.size()]);
    }

    public int numberOfSegments(){
        return this.segments.length;
    }

    public LineSegment[] segments(){
        return Arrays.copyOf(segments,numberOfSegments());
    }
    private void checkPoints(Point[] points){
        if(points.length == 0)
            throw new IllegalArgumentException("The numbers of points is ZEROS or NULL.");
        for(int i = 0; i<points.length; i++){
            for(int j = i+1; j<points.length; j++){
                if(points[i].compareTo(points[j]) == 0){
                    throw new IllegalArgumentException("Duplicated entries in given points.");
                }
            }
        }
    }
}
