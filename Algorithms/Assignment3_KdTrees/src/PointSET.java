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
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Arrays;

public class PointSET {
    // Your code here
	TreeSet<Point2D> bst;
	
	public PointSET()
	{
		bst = new TreeSet<Point2D>();
	}
	
	public boolean isEmpty()
	{
		return bst.isEmpty();
	}
	
	public int size()
	{
		return bst.size();
	}
	
	// add the point p to the set (if it is not already in the set)
	public void insert(Point2D p)
	{
		if(!bst.contains(p))
			bst.add(p);
	}
	
	// does the set contain the point p?
	public boolean contains(Point2D p)
	{
		return bst.contains(p);
	}
	
	// draw all of the points to standard draw
	public void draw()
	{
		for(Point2D p : bst){
			StdDraw.filledCircle(p.x() * 512, p.y() * 512, 5);
		}
	}
	
	// all points in the set that are inside the rectangle
	public Iterable<Point2D> range(RectHV rect)
	{
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		
		for(Point2D p : bst)
		{
			if(rect.contains(p))
				points.add(p);
		}
		return points;
	}
	
	// a nearest neighbor in the set to p; null if set is empty
   	public Point2D nearest(Point2D p)
   	{
   		if(isEmpty())
   			return null;
   		
   		Point2D best = bst.first();
   		double distance = p.distanceTo(best);
   		
   		for(Point2D point : bst)
   		{
   			double d = p.distanceTo(point); 
   			if(d < distance){
   				best = point;
   				distance = d;
   			}
   		}
   		
   		return best;
   	}

   
   	//Test
    public static void main(String[] args) {
    	
    	/*
    	PointSET set = new PointSET();
    	int pointCount = StdIn.readInt();
    	RectHV rect = new RectHV(0.5, 0.1, 0.8, 0.9);
    	Point2D point = new Point2D(0.6, 0.7);

    	StdDraw.show(0);
    	StdDraw.clear();
    	
    	for(int i=0; i < pointCount; i++){
            double x = StdIn.readDouble(), y = StdIn.readDouble();
            set.insert(new Point2D(x,y));
            StdDraw.filledCircle(x, y, 0.01);
    	}
    	
    	Iterable<Point2D> inRect = set.range(rect);
    	for(Point2D p : inRect){
    		StdOut.println(p);
    		StdDraw.filledCircle(p.x(), p.y(), 0.02);
    	}
    	
    	Point2D closest = set.nearest(point);
    	
    	
    	rect.draw();
    	StdDraw.setPenColor(StdDraw.RED);
    	StdDraw.filledCircle(point.x(), point.y(), 0.01);
    	StdDraw.setPenColor();
    	StdDraw.line(point.x(), point.y(), closest.x(), closest.y());
    	StdDraw.filledCircle(closest.x(), closest.y(), 0.02);
    	
    	//StdDraw.filledCircle(0.5, 0.5, 0.1);
    	
    	StdDraw.show(50);
    	*/
    	
    	
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
