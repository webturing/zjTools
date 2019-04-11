package zj.goem2D;

public class Rectangle extends Shape {
	protected Point left_top;
	protected Point right_bottom;

	double getWidth() {
		return right_bottom.y - left_top.y;
	}

	double getLength() {
		return left_top.x - right_bottom.x;
	}

	@Override
	double area() {
		return getWidth() * getLength();
	}

	@Override
	double perimeter() {
		return 2 * (getWidth() + getLength());
	}
}
