package zj.math;

/**
 * �������ʵ�֣���Լ����
 * 
 * @author Administrator
 * 
 */
public class Fractor {
	public int up;
	public int down;

	public Fractor() {
		this(0, 1);
	}

	public Fractor(int up, int down) {
		int gcd = zj.math.IntegerTheory.gcd(up, down);
		up /= gcd;
		down /= gcd;
		this.up = up;
		this.down = down;
	}

	@Override
	public String toString() {
		return up + "/" + down;
	}
}
