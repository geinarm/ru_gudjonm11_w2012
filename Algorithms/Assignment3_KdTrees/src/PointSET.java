/****************************************************************************
  *  Compilation:  javac PointSET.java
  *  Execution:    
  *  Dependencies:
  *  Author:
  *  Date:
  *
  *  Data structure for maintaining a set of 2-D points, 
  *    including rectangle and nearest-neighbor queries
  *
  *************************************************************************/

import java.awt.Point;
import java.util.Arrays;

public class PointSET {
    // Your code here
	
	public PointSET()
	{
		
	}
	
	public boolean isEmpty()
	{
		return true;
	}
	
	public int size()
	{
		return 0;
	}
	
	public void insert(Point2D p)
	{
		
	}
	
	public boolean contains(Point2D p)
	{
		return false;
	}
	
	public void draw()
	{
		
	}
	
	public Iterable<Point2D> range(RectHV rect)
	{
		return null;
	}
	
   	public Point2D nearest(Point2D p)
   	{
   		return new Point2D(0.0, 0.0);
   	}

   
   	//Test
    public static void main(String[] args) { 
        int nrOfRecangles = StdIn.readInt();
        int nrOfPointsCont = StdIn.readInt();
        int nrOfPointsNear = StdIn.readInt();
        RectHV[] rectangles = new RectHV[nrOfRecangles];
        Point2D[] pointsCont = new Point2D[nrOfPointsCont];
        Point2D[] pointsNear = new Point2D[nrOfPointsNear];
        
        for(int i = 0; i < nrOfRecangles; i++)
        {
            rectangles[i] = new RectHV(StdIn.readDouble(),StdIn.readDouble(),StdIn.readDouble(),StdIn.readDouble());
        }
        
        for(int i = 0; i < nrOfPointsCont; i++)
        {
            pointsCont[i] = new Point2D(StdIn.readDouble(),StdIn.readDouble());
        }
        
        for(int i = 0; i < nrOfPointsNear; i++)
        {
            pointsNear[i] = new Point2D(StdIn.readDouble(),StdIn.readDouble());
        }
        
        PointSET set = new PointSET();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            double x = StdIn.readDouble(), y = StdIn.readDouble();
            set.insert(new Point2D(x,y));
        }
        
        for(int i = 0; i < nrOfRecangles; i++)
        {
		    // Query on rectangle i, sort the result, and print
		    Iterable<Point2D> ptset = set.range(rectangles[i]);
		    int ptcount=0;
		    for (Point2D p : ptset)
		    	ptcount++;
    		
		    Point2D[] ptarr = new Point2D[ptcount];
		    int j=0;
		    for (Point2D p : ptset) {
		    	ptarr[j] = p;
		    	j++;
		    }
		    
		    Arrays.sort(ptarr);
            StdOut.println("Inside rectangle " + (i + 1) + ":"); 
            for (j=0; j < ptcount; j++)
                StdOut.println(ptarr[j]);
        }
        
        StdOut.println("Contain test:");
        for(int i = 0; i < nrOfPointsCont; i++)
        {
            StdOut.println((i+1) + ": " + set.contains(pointsCont[i]));
        }
        
        StdOut.println("Nearest test:");
        for(int i = 0; i < nrOfPointsNear; i++)
        {
            StdOut.println((i+1) + ": " + set.nearest(pointsNear[i]));
        }
        
        StdOut.println();
    }

}
