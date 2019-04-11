package zj.goem2D;

public class Circle extends Shape {
	Point center;
	double radius;

	@Override
	double area() {
		return Math.PI * radius * radius;
	}

	@Override
	double perimeter() {
		return Math.PI * radius * 2;
	}
}
