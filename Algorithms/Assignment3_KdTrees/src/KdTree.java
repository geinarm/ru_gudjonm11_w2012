/*************************************************************************
  *************************************************************************/

import java.util.Arrays;

public class KdTree {
    Node root = null;
    
    private class Node
    {
    	public Point2D value;
    	public Node left, right;
    	
    	public Node(Point2D p)
    	{
    		this.value = p;
    	}
    }
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public int size()
	{
		return 0;
	}
	
	public void insert(Point2D p)
	{
		if(!contains(p)){
			if(root == null) root = new Node(p);
			else insertAt(root, p, p.x());
		}
	}
	
	private void insertAt(Node n, Point2D p, double key)
	{
		if(key == p.x()){
			if(key < n.value.x()){
				if(n.left == null) n.left = new Node(p);
				else insertAt(n.left, p, p.y());
			}
			else{
				if(n.right == null) n.right = new Node(p);
				else insertAt(n.right, p, p.y());
			}
		}
		else{
			if(key < n.value.y()){
				if(n.left == null) n.left = new Node(p);
				else insertAt(n.left, p, p.x());
			}
			else{
				if(n.right == null) n.right = new Node(p);
				else insertAt(n.right, p, p.x());
			}
		}
	}
	
	public boolean contains(Point2D p)
	{
		return findAt(root, p, p.x());
	}
	
	private boolean findAt(Node n, Point2D p, double key)
	{

		if(n == null)
		{
			return false;
		}
		else if(n.value.equals(p))
		{
			return true;
		}
		else if(key == p.x())
		{
			if(key < n.value.x())
				return findAt(n.left, p, p.y());
			else
				return findAt(n.right, p, p.y());
		}
		else
		{
			if(key < n.value.y())
				return findAt(n.left, p, p.x());
			else
				return findAt(n.left, p, p.x());
		}
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
    
    /*******************************************************************************
      *  Test client
      ******************************************************************************/
    public static void main(String[] args) { 
    	
    	KdTree set = new KdTree();    	
    	int pointCount = StdIn.readInt();
    	RectHV rect = new RectHV(0.5, 0.1, 0.8, 0.9);
    	Point2D point = new Point2D(0.6, 0.7);
    	
    	for(int i=0; i < pointCount; i++){
            double x = StdIn.readDouble(), y = StdIn.readDouble();
            set.insert(new Point2D(x,y));
            //StdDraw.filledCircle(x, y, 0.01);
    	}
    	
    	StdOut.println(set.isEmpty());
    	
    	StdOut.println(set.contains(new Point2D(0.5, 0.5)));
    	
    	/*Iterable<Point2D> inRect = set.range(rect);
    	for(Point2D p : inRect){
    		StdOut.println(p);
    		StdDraw.filledCircle(p.x(), p.y(), 0.02);
    	}*/
    	
    	//Point2D closest = set.nearest(point);

    	
    	/*
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
        
        KdTree set = new KdTree();
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
        */
    }
   
}
