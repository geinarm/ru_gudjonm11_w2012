/*************************************************************************
  *************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;

public class KdTree {
    Node root = null;
    
    private class Node
    {
    	public Point2D value;
    	public double key;
    	public Node left, right;
    	
    	public Node(Point2D p, double key)
    	{
    		this.value = p;
    		this.key = key;
    		this.left = null;
    		this.right = null;
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
			if(root == null) root = new Node(p, p.x());
			else insertAt(root, p);
		}
	}
	
	private void insertAt(Node n, Point2D p)
	{
		if(n.key == n.value.x()){
			if(p.x() < n.value.x()){
				if(n.left == null) n.left = new Node(p, p.y());
				else insertAt(n.left, p);
			}
			else{
				if(n.right == null) n.right = new Node(p, p.y());
				else insertAt(n.right, p);
			}
		}
		else{
			if(p.y() < n.value.y()){
				if(n.left == null) n.left = new Node(p, p.x());
				else insertAt(n.left, p);
			}
			else{
				if(n.right == null) n.right = new Node(p, p.x());
				else insertAt(n.right, p);
			}
		}
	}
	
	public boolean contains(Point2D p)
	{
		return findAt(root, p);
	}
	
	private boolean findAt(Node n, Point2D p)
	{

		if(n == null){
			return false;
		}
		if(n.value.equals(p)){
			return true;
		}
		
		if(n.key == n.value.x())
		{
			if(p.x() < n.value.x())
				return findAt(n.left, p);
			else
				return findAt(n.right, p);
		}
		else
		{
			if(p.y() < n.value.y())
				return findAt(n.left, p);
			else
				return findAt(n.right, p);
		}
	}
	
	public void draw()
	{
		
	}
	
	public Iterable<Point2D> range(RectHV rect)
	{
		return rangeAt(root, rect, new RectHV(0.0, 0.0, 1.0, 1.0));
	}
	
	private ArrayList<Point2D> rangeAt(Node n, RectHV rect, RectHV searchRect)
	{
		ArrayList<Point2D> points = new ArrayList<Point2D>();
		if(n == null)
			return points;
		
		if(rect.contains(n.value))
			points.add(n.value);
		
		if(n.key == n.value.x())
		{
			//Vertical
			RectHV left = new RectHV(searchRect.xmin(), searchRect.ymin(), n.key, searchRect.ymax());
			RectHV right = new RectHV(n.key, searchRect.ymin(), searchRect.xmax(), searchRect.ymax());
			
			if(rect.intersects(left)){
				points.addAll(rangeAt(n.left, rect, left));
			}
			if(rect.intersects(right)){
				points.addAll(rangeAt(n.right, rect, right));
			}
		}
		else
		{
			//Horizontal
			RectHV top = new RectHV(searchRect.xmin(), n.key, searchRect.xmax(), searchRect.ymax());
			RectHV bottom = new RectHV(searchRect.xmin(), searchRect.ymin(), searchRect.xmax(), n.key);
			
			if(rect.intersects(bottom)){
				points.addAll(rangeAt(n.left, rect, bottom));
			}
			if(rect.intersects(top)){
				points.addAll(rangeAt(n.right, rect, top));
			}
		}
		
		return points;
	}
	
   	public Point2D nearest(Point2D p)
   	{
   		if(root != null)
   			return nearestAt(root, p, root.value);
   		else
   			return null;
   	}
   	
   	private Point2D nearestAt(Node n, Point2D p, Point2D best)
   	{
   		if(n == null)
   			return best;
   		
   		if(p.distanceTo(n.value) < p.distanceTo(best))
   			best = n.value;
   		
   		if(n.key == n.value.x()){
   			if(p.x() < n.key){
   				best = nearestAt(n.left, p, best);
   				if(p.distanceTo(best) > Math.abs(n.key - p.x()))
   					best = nearestAt(n.right, p, best);
   			}
   			else{
   				best = 	nearestAt(n.right, p, best);
   				if(p.distanceTo(best) > Math.abs(n.key - p.x()))
   					best = nearestAt(n.left, p, best);
   			}
   		}
   		else{
   			if(p.y() < n.key){
   				best = nearestAt(n.left, p, best);
   				if(p.distanceTo(best) > Math.abs(n.key - p.y()))
   					best = nearestAt(n.right, p, best);
   			}
   			else{
   				best = 	nearestAt(n.right, p, best);
   				if(p.distanceTo(best) > Math.abs(n.key - p.y()))
   					best = nearestAt(n.left, p, best);
   			}
   		}
   		
   		return best;
   	}
    
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
        KdTree set = new KdTree();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            double x = StdIn.readDouble(), y = StdIn.readDouble();
            set.insert(new Point2D(x,y));
        }
        for(int i = 0; i < nrOfRecangles; i++){
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
