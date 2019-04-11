/**
 * 
 */
package zj.math;

import zj.ds.sort.Sorter;

/**
 * @author Administrator
 */
public class ComposeMath {
	final static int FACTOR[] = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320,
			362880, 3628800, 39916800, 479001600 };
	final static int DEFAULT_SIZE = 101;
	static int Q[][];
	static {
		Q = new int[DEFAULT_SIZE][DEFAULT_SIZE];
	}

	static int binormial(int n, int r) {
		if (Q[n][r] != 0)
			return Q[n][r];
		if (n == r || r == 0)
			return Q[n][r] = 1;
		return Q[n][r] = binormial(n - 1, r - 1) + binormial(n - 1, r);
	}

	/**
	 * ��������P(n,r)��ö���㷨
	 * 
	 * @param n
	 * @param r
	 * @return
	 */
	public static int[][] pnr(int n, int r) {
		int s = 1;
		for (int i = n; i >= n - r + 1; i--)
			s *= i;
		int[][] ans = new int[s][n];
		int kind = 0;
		int total = (int) (Math.pow(n, r) + .5);
		int[] B = new int[r];
		for (int i = 0; i < total; i++) {
			int ci = i;
			for (int j = 0; j < B.length; j++) {
				B[j] = ci % n;
				ci /= n;
			}
			if (BoolTools.differAll(B)) {
				for (int k = 0; k < B.length; k++)
					ans[kind][k] = B[k];
				kind++;
			}
		}
		return ans;
	}

	/**
	 * ���������n��Ԫ������ѡr�����ķǵݹ��㷨�������ƿռ��ʾ��ö��ɸѡ�� ���ӶȽϸ� 2^n
	 * 
	 * @author ZHAO Jing
	 * @version 2012.9.26
	 */
	public static int[][] simpleCnr(int n, int r) {
		int[][] ans = new int[binormial(n, r)][r];
		int kind = 0;
		int B[] = new int[n];
		for (int i = 0; i < (1 << n); i++) {
			int ci = i;// �����α�i
			for (int j = n - 1; j >= 0; j--) {
				B[j] = ci & 1;
				ci >>= 1;
			}
			int ones = 0;
			for (int j = 0; j < n; j++) {
				if (B[j] == 1)
					ones++;
			}
			if (ones == r) {
				int m = 0;
				for (int j = 0; j < n; j++)
					if (B[j] == 1)
						ans[kind][m++] = j;
				kind++;
			}
		}
		return ans;
	}

	public static int[][] pnr(int n) {
		if (n >= FACTOR.length)
			throw new IllegalArgumentException("�������");
		int ans[][] = new int[FACTOR[n]][n];
		int A[] = new int[n];
		for (int i = 0; i < A.length; i++)
			A[i] = i + 1;
		for (int i = 0; i < FACTOR[n]; i++) {
			System.arraycopy(A, 0, ans[i], 0, n);
			next_permutation(A);
		}
		return ans;
	}

	public static boolean next_permutation(char[] t) {
		int n = t.length;
		int i = 0;
		for (i = n - 1; i >= 1; i--)
			if (t[i - 1] < t[i])
				break;
		if (i == 0)
			return false;
		int j = i;
		for (j = n - 1; j >= i; j--)
			if (t[i - 1] < t[j])
				break;
		Sorter.swap(t, i - 1, j);
		for (int k = i, cnt = 0; cnt < (n - i) / 2; k++, cnt++)
			Sorter.swap(t, k, n - 1 - cnt);
		return true;
	}

	public static boolean next_permutation(short[] t) {
		int n = t.length;
		int i = 0;
		for (i = n - 1; i >= 1; i--)
			if (t[i - 1] < t[i])
				break;
		if (i == 0)
			return false;
		int j = i;
		for (j = n - 1; j >= i; j--)
			if (t[i - 1] < t[j])
				break;
		Sorter.swap(t, i - 1, j);
		for (int k = i, cnt = 0; cnt < (n - i) / 2; k++, cnt++)
			Sorter.swap(t, k, n - 1 - cnt);
		return true;
	}

	public static boolean next_permutation(int[] t) {
		int n = t.length;
		int i = 0;
		for (i = n - 1; i >= 1; i--)
			if (t[i - 1] < t[i])
				break;
		if (i == 0)
			return false;
		int j = i;
		for (j = n - 1; j >= i; j--)
			if (t[i - 1] < t[j])
				break;
		Sorter.swap(t, i - 1, j);
		for (int k = i, cnt = 0; cnt < (n - i) / 2; k++, cnt++)
			Sorter.swap(t, k, n - 1 - cnt);
		return true;
	}

	public static boolean next_permutation(long[] t) {
		int n = t.length;
		int i = 0;
		for (i = n - 1; i >= 1; i--)
			if (t[i - 1] < t[i])
				break;
		if (i == 0)
			return false;
		int j = i;
		for (j = n - 1; j >= i; j--)
			if (t[i - 1] < t[j])
				break;
		Sorter.swap(t, i - 1, j);
		for (int k = i, cnt = 0; cnt < (n - i) / 2; k++, cnt++)
			Sorter.swap(t, k, n - 1 - cnt);
		return true;
	}

	public static boolean next_permutation(float[] t) {
		int n = t.length;
		int i = 0;
		for (i = n - 1; i >= 1; i--)
			if (t[i - 1] < t[i])
				break;
		if (i == 0)
			return false;
		int j = i;
		for (j = n - 1; j >= i; j--)
			if (t[i - 1] < t[j])
				break;
		Sorter.swap(t, i - 1, j);
		for (int k = i, cnt = 0; cnt < (n - i) / 2; k++, cnt++)
			Sorter.swap(t, k, n - 1 - cnt);
		return true;
	}

	public static boolean next_permutation(double[] t) {
		int n = t.length;
		int i = 0;
		for (i = n - 1; i >= 1; i--)
			if (t[i - 1] < t[i])
				break;
		if (i == 0)
			return false;
		int j = i;
		for (j = n - 1; j >= i; j--)
			if (t[i - 1] < t[j])
				break;
		Sorter.swap(t, i - 1, j);
		for (int k = i, cnt = 0; cnt < (n - i) / 2; k++, cnt++)
			Sorter.swap(t, k, n - 1 - cnt);
		return true;
	}

	/*
	 * BUG Fixed
	 */
	// TODO
	public static boolean next_permutation(Comparable[] t) {
		int n = t.length;
		int i = 0;
		for (i = n - 1; i >= 1; i--)
			if (t[i - 1].compareTo(t[i]) < 0)
				break;
		if (i == 0)
			return false;
		int j = i;
		for (j = n - 1; j >= i; j--)
			if (t[i - 1].compareTo(t[j]) < 0)
				break;
		Sorter.swap(t, i - 1, j);
		for (int k = i, cnt = 0; cnt < (n - i) / 2; k++, cnt++)
			Sorter.swap(t, k, n - 1 - cnt);
		return true;
	}

	/**
	 * ����C(n r)��ϵ��㷨 ��1~n��Ԫ����ѡ��r��Ԫ��A[i] �赱ǰ���ΪA[1],A[2],...,A[r];
	 * ����һ�����Ϊ�� S1.���ʹA[j]<n-r+j������±�i,��i=max{j|A[j]<n-r+j} S2.
	 * A[i]=A[i]+1; S3. A[j]=A[j-1]+1,j=i+1,i+2,...,r ע�⵽
	 * ��ʼ���ΪA[]={1,2,3,...,r}; //S0 �������ΪA[]={n-r+1,n-r+2,.....n} //S_END *
	 * 
	 * @param n
	 * @param r
	 *            �ο���������ѧ��֮�����������㷨
	 */
	public static int[][] genCnr(int n, int r) {
		if (r == 0)
			return null;
		int[][] ans = new int[binormial(n, r)][r];
		int cnt = 0;
		Integer[] A = new Integer[r + 1];// Ϊ�˺��㷨α�����±�һ��
		// S0����ʼ���
		for (int i = 0; i < A.length; i++)
			A[i] = i;
		while (A[1] <= n - r + 1) {// ���һ�����Ϊ�˳�����S_END
			for (int i = 1; i < A.length; i++)
				ans[cnt][i - 1] = A[i];
			cnt++;
			// S1. ���ʹA[j]<n-r+j������±�i,��i=max{j|A[j]<n-r+j}
			int i = 1;
			for (int j = 1; j <= r; j++)
				if (A[j] < n - r + j)
					if (j > i)
						i = j;
			// END S1
			++A[i];// S2
			// S3
			for (int j = i + 1; j <= r; j++)
				A[j] = A[j - 1] + 1;
			// END S3
		}// END_while
		return ans;
	}// END_genCnr
}
