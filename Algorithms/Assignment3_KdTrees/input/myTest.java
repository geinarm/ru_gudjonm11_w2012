    /*******************************************************************************
      * My Test client
      ******************************************************************************/
    
   	/*
   	public static void main(String[] args) { 
    	
    	
    	KdTree set = new KdTree();    	
    	int pointCount = StdIn.readInt();
    	RectHV rect = new RectHV(0.5, 0.1, 0.8, 0.9);
    	Point2D point = new Point2D(0.4, 0.5);
    	
    	StdDraw.show(0);
    	StdDraw.clear();
    	
    	for(int i=0; i < pointCount; i++){
            double x = StdIn.readDouble(), y = StdIn.readDouble();
            set.insert(new Point2D(x,y));
            StdDraw.filledCircle(x, y, 0.01);
    	}
    	
    	StdOut.println(set.isEmpty());
    	
    	StdOut.println(set.contains(new Point2D(0.5, 0.5)));
    	
    	Iterable<Point2D> inRect = set.range(rect);
    	for(Point2D p : inRect){
    		StdOut.println(p);
    		StdDraw.setPenColor(StdDraw.GREEN);
    		StdDraw.filledCircle(p.x(), p.y(), 0.01);
    		StdDraw.setPenColor();
    	}
    	
    	Point2D closest = set.nearest(point);
    	
    	rect.draw();
    	StdDraw.setPenColor(StdDraw.RED);
    	StdDraw.filledCircle(point.x(), point.y(), 0.01);
    	StdDraw.setPenColor();
    	if(closest != null){
    		StdDraw.line(point.x(), point.y(), closest.x(), closest.y());
    		StdDraw.filledCircle(closest.x(), closest.y(), 0.02);
    	}
    	
    	StdDraw.show(50);
    	
        
    }*/
   	/*
    public static void main(String[] args) {
    	int nrOfPoints = StdIn.readInt();
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
        for (int i = 0; i < nrOfPoints; i++) {
            double x = StdIn.readDouble(), y = StdIn.readDouble();
            set.insert(new Point2D(x,y));
            StdDraw.filledCircle(x, y, 0.01);
        }

        for(int i = 0; i < nrOfRecangles; i++){
		    // Query on rectangle i, sort the result, and print
		    Iterable<Point2D> ptset = set.range(rectangles[i]);
		    int ptcount=0;
		    for (Point2D p : ptset){
		    	ptcount++;
		    	StdDraw.setPenColor(StdDraw.RED);
		    	StdDraw.filledCircle(p.x(), p.y(), 0.01);
		    	StdDraw.setPenColor();
		    }
		    
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
            
            rectangles[i].draw();
        }
        
        StdOut.println("Contain test:");
        for(int i = 0; i < nrOfPointsCont; i++)
        {
            StdOut.println((i+1) + ": " + set.contains(pointsCont[i]));
        }
        
        StdOut.println("Nearest test:");
        for(int i = 0; i < nrOfPointsNear; i++)
        {
        	Point2D p = pointsNear[i];
        	Point2D near = set.nearest(p);
	    	StdDraw.setPenColor(StdDraw.YELLOW);
	    	StdDraw.filledCircle(p.x(), p.y(), 0.01);
	    	StdDraw.line(p.x(), p.y(), near.x(), near.y());
	    	StdDraw.setPenColor();
            StdOut.println((i+1) + ": " + near);
        }
        
        StdOut.println();
        StdDraw.show(50);
    }
    */