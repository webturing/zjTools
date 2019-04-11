package zj.math;

public class Util {
	private final static double EPS = 1E-3;
	private final static double LOG2 = Math.log(2);

	public static int compare(double x) {
		if (x > EPS)
			return 1;
		if (x < EPS)
			return -1;
		return 0;
	}

	public static int compare(double a, double b) {
		return compare(a - b);
	}

	public static double lb(double n) {
		return Math.log(n) / LOG2;
	}
	
}
