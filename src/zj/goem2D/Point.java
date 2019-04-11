package zj.goem2D;

public class Point {
	public static final Point ZERO_POINT = new Point();
	public double x;
	public double y;

	public Point() {
		this(0.0);
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(double x) {
		this(x, 0.0);
	}

	public Point(Point that) {
		this(that.x, that.y);
	}

	public double getDistance(Point that) {
		return GeomtryTools.getDistance(this, that);
	}
}
