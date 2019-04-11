package zj.math;

import java.util.Arrays;

public class BoolTools {
	public static boolean and(boolean p, boolean q) {
		return p && q;
	}

	public static boolean or(boolean p, boolean q) {
		return p || q;
	}

	public static boolean not(boolean p) {
		return !p;
	}

	public static boolean xor(boolean p, boolean q) {
		return p != q;
	}

	/**
	 * p->q=!p||q
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean imply(boolean p, boolean q) {
		return !p || q;
	}

	/**
	 * for any B[i] then B[i]=true;
	 * 
	 * @param B
	 * @return
	 */
	public static boolean allTrue(boolean[] B) {
		for (boolean t : B)
			if (!t)
				return false;
		return true;
	}

	/**
	 * p==q
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean equal(boolean p, boolean q) {
		return p == q;
	}

	/**
	 * for any i,j(i!=j) then a[i]!=a[j]
	 * 
	 * @param a
	 * @return
	 */
	public static boolean differAll(int[] a) {
		int b[] = a.clone();
		Arrays.sort(b);
		for (int i = 0; i < a.length - 1; i++)
			if (b[i] == b[i + 1])
				return false;
		return true;
	}

	public static int booleanAsInteger(boolean p) {
		return p ? 1 : 0;
	}

	public static boolean integerAsBoolean(int a) {
		return a != 0;
	}

	public static boolean allSame(int[] b) {
		for (int i = 0; i < b.length - 1; i++)
			if (b[i] != b[i + 1])
				return false;
		return true;
	}
}
