package zj.goem2D;

public class Triangle extends Shape {
	Point A, B, C;

	public Triangle() {
		this(Point.ZERO_POINT, new Point(1, 1), new Point(2, 3));
	}

	public Triangle(Point A, Point B, Point C) {
		this.A = new Point(A);
		this.B = new Point(B);
		this.C = new Point(C);
	}

	@Override
	double area() {
		return GeomtryTools.getArea(A, B, C);
	}

	@Override
	double perimeter() {
		return B.getDistance(C) + C.getDistance(A) + A.getDistance(B);
	}
}
