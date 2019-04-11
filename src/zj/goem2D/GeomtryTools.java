/**
 * 
 */
package zj.goem2D;

/**
 * @author ZHAO Jing
 * 
 */
public class GeomtryTools {
	private static final double MIN_PRECISION = 1.0E-8;

	/**
	 * 两点之间的距�?
	 * 
	 * @param from
	 * @param to
	 * @return distance of from line
	 */
	public static double getDistance(Point from, Point to) {
		double dx = from.x - to.x;
		double dy = from.y - to.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	/**
	 * 三角形pqr的面�?
	 * 
	 * @para p
	 * @para q
	 * @para r
	 * @retur 面积
	 */
	public static double getArea(Point p, Point q, Point r) {
		double a = getDistance(p, q);
		double b = getDistance(q, r);
		double c = getDistance(r, p);
		double s = (a + b + c) / 2;
		return Math.sqrt(s * (s - a) * (s - c) * (s - b));
	}

	/**
	 * 判断三点是否共线
	 * 
	 * @param p
	 * @param q
	 * @param r
	 * @return p q r 是否共线
	 */
	public static boolean isSameLine(Point p, Point q, Point r) {
		return getArea(p, q, r) <= MIN_PRECISION;
	}

	/**
	 * 计算点到直线距离
	 * 
	 * @param p
	 * @param ln
	 * @return
	 */
	public static double getDistance(Point p, Line ln) {
		double area = getArea(p, ln.from, ln.to);
		double side = getDistance(ln.from, ln.to);
		return 2 * area / side;
	}

	public static double getAngel(Line ln) {
		double dx = ln.from.x - ln.to.x;
		double dy = ln.from.y - ln.to.y;
		return Math.atan(dy / dx);
	}

	/**
	 * 计算夹角
	 * 
	 * @param la
	 * @param lb
	 * @return
	 */
	public static double getAngel(Line la, Line lb) {
		double angelA = getAngel(la);
		double angelB = getAngel(lb);
		return (angelB - angelA + Math.PI) % Math.PI;
	}
}
