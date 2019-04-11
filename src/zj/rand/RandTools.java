package zj.rand;

import java.util.Random;


import zj.io.ArrayPrinter;

public class RandTools {
	static Random random = new Random();

	public static int doss(int start, int end) {
		return random.nextInt(end - start + 1) + start;
	}

	public static int[] doss(int size, int start, int end) {
		int[] A = new int[size];
		randFill(A, start, end);
		return A;
	}

	public static void randFill(int[] a, int start, int end) {
		for (int i = 0; i < a.length; i++)
			a[i] = doss(start, end);

	}

	public static int[] randBinaryArray(int size) {
		return doss(size, 0, 1);
	}

	public static double[] randReal(int size, double start, double end) {
		double[] A = new double[size];
		for (int i = 0; i < A.length; i++)
			A[i] = Math.random() * (end - start) + start;
		return A;
	}

	public static double[][] randReal(int r, int c, double start, double end) {
		double[][] A = new double[r][c];
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < A[i].length; i++)
				A[i][j] = Math.random() * (end - start) + start;
		return A;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[] a={123,123,1,23,12,3,12,3,123};
		ArrayPrinter.print(randSubSet(a));
;
	}

	public static void randFill(int[][] a, int start, int end) {
		for (int i = 0; i < a.length; i++)
			randFill(a[i], start, end);

	}

	public static Object[] randSubSet(Object set[]) {
		int[] flag = randBinaryArray(set.length);
		int n = zj.math.ArrayTools.count(set, 1);
		if (n == 0)
			return null;
		Object ans[] = new Object[n];
		int j = 0;
		for (int f : flag)
			if (f == 1)
				ans[j++] = f;
		return ans;
	}

}
