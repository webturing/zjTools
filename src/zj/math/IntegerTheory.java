package zj.math;

public class IntegerTheory {
	/**
	 * 二分法
	 * 
	 * @param base
	 * @param times
	 * @return
	 */
	public static int power(int base, int times) {
		return powerMod(base, times, Integer.MAX_VALUE);
	}

	/**
	 * 二分法
	 * 
	 * @param a
	 * @param n
	 * @return
	 */
	static int powerMod(int a, int n, int M) {
		if (M < 2)
			return 0;
		if (a == 0 || n == 1)
			return mod(a, M);
		if (n == 0)
			return mod(1, M);
		if (n % 2 == 0)
			return powerMod(mod(a * a, M), n / 2, M);
		return mod(a * powerMod(mod(a * a, M), n / 2, M), M);
	}

	static long mod(long x, long y) {
		return x < 0 ? x % y + y : x % y;
	}

	static int mod(int x, int y) {
		if (y == 1)
			return 0;
		return x < 0 ? x % y + y : x % y;
	}

	/**
	 * շת�����������ӣ��ǵݹ�ʵ��
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int gcd(int x, int y) {
		int t, r;
		if (x < y) {
			t = x;
			x = y;
			y = t;
		}
		while (y != 0) {
			r = mod(x, y);
			x = y;
			y = r;
		}
		return x;
	}
	/**
	 * շת�����������ӣ��ǵݹ�ʵ��
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static long gcd(long x, long y) {
		long t, r;
		if (x < y) {
			t = x;
			x = y;
			y = t;
		}
		while (y != 0) {
			r = mod(x, y);
			x = y;
			y = r;
		}
		return x;
	}
	public static boolean isPrime(int n) {
		if (n < 0)
			n = -n;
		if (n == 2)
			return true;
		if (n < 2 || (n & 1) == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2)
			if (mod(n, i) == 0)
				return false;
		return true;
	}

	public static int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}

	public static int digitLength(int n) {
		return digitLength(n, 10);
	}

	public static int digitLength(int n, int base) {
		if (n < 0)
			n = -n;
		// return n < 10 ? 1 : digitLength(n / 10);//rec version
		return (n == 0) ? 1 : (int) (Math.log(n) / Math.log(base) + 1);
	}

	public static int digitReverse(int n) {
		return digitReverse(n, 10);
	}

	public static int digitReverse(int n, int base) {
		int s;
		for (s = 0; n != 0; n /= base)
			s = base * s + mod(n,base);
		return s;
	}

	/**
	 * Count all factors of n in range[1,n]
	 * 
	 * @param n
	 * @return
	 */
	public static int countFactors(int n) {
		int s = 2, i;
		for (i = 2; i * i < n; i++)
			if (n % i == 0)
				s += 2;
		if (i * i == n)
			s++;
		return s;
	}

	/**
	 * Sum up all factors of n in range[1,n]
	 * 
	 * @param n
	 * @return
	 */
	public static int sumFactors(int n) {
		int s = 1 + n, i;
		for (i = 2; i * i < n; i++)
			if (n % i == 0)
				s += i + n / i;
		if (i * i == n)
			s += i;
		return s;
	}

	/**
	 * @param n
	 * @return n��������ĸ�λ��֮�ͣ������Ƿ��
	 */
	public static int digitSum(int n) {
		
		return digitSum(n,10);
	}
	public static int digitSum(int n,int base) {
		int s;
		for (s = 0; n > 0; n /= base)
			s += n % base;
		return s;
	}
	/**
	 * @param n
	 * @return array A[] where A[i]=d(i,a);
	 */
	public static int[] digitArray(int n) {
		return digitArray(n,10);
	}
	/**
	 * divide n'=n(base) to an array
	 * @param n
	 * @param base
	 * @return
	 */
	public static int[] digitArray(int n,int base) {

		int[] result = new int[digitLength(n,base)];
		if (n < 0)
			n = -n;
		for (int i = result.length - 1; n > 0; n /= base)
			result[i--] = n % base;
		return result;
	}
}
