package zj.goem2D;

public class Line {
	final static Line X_AXIS = new Line();
	final static Line Y_AXIS = new Line(new Point(), new Point(0, 1));
	Point from;
	Point to;

	public Line() {
		this(new Point(), new Point(1, 0));
	}

	public Line(Point from, Point to) {
		this.from = new Point(from);
		this.to = new Point(to);
	}
}
