package zj.io;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ArrayPrinter {
	public static void print(char[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append("'" + a[i] + "',");
		s.setCharAt(s.length() - 1, '}');
		System.out.println(s);
	}

	public static void print(char[][] B) {
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < B[i].length; j++)
				System.out.print(B[i][j] + (j == B[i].length - 1 ? "\n" : " "));
	}

	public static void print(double[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append(a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		System.out.println(s);
	}

	public static void print(int[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append(a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		System.out.println(s);
	}

	public static void print(int[][] B) {
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < B[i].length; j++)
				System.out.print(B[i][j] + (j == B[i].length - 1 ? "\n" : " "));
		System.out.println();
	}

	public static void print(Object[] a) {
		print(System.out, a);
	}

	public static void print(PrintStream out, Object[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append(a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		out.println(s);
	}

	public static void print(String[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append(a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		System.out.println(s);
	}

	public static void printArr(boolean[] a) {
		printArr(a, System.out);
	}

	/**
	 * @param a
	 * @param out
	 */
	public static void printArr(boolean[] a, PrintStream out) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append(a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		out.println(s);
	}

	public static void printArr(boolean[][] B) {
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < B[i].length; j++)
				System.out.print(B[i][j] + (j == B[i].length - 1 ? "\n" : " "));
	}

	public static void printArr(char[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append(a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		System.out.println(s);
	}

	public static void printArr(char[][] B) {
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < B[i].length; j++)
				System.out.print(B[i][j] + (j == B[i].length - 1 ? "\n" : " "));
	}

	public static void printArr(double[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append(a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		System.out.println(s);
	}

	public static void printArr(double[][] B) {
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < B[i].length; j++)
				System.out.print(B[i][j] + (j == B[i].length - 1 ? "\n" : " "));
	}

	public static void printArr(float[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append(a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		System.out.println(s);
	}

	public static void printArr(float[][] B) {
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < B[i].length; j++)
				System.out.print(B[i][j] + (j == B[i].length - 1 ? "\n" : " "));
	}

	public static void printArr(int[][] B) {
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < B[i].length; j++)
				System.out.print(B[i][j] + (j == B[i].length - 1 ? "\n" : " "));
	}

	public static void printArr(long[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append(a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		System.out.println(s);
	}

	public static void printArr(long[][] B) {
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < B[i].length; j++)
				System.out.print(B[i][j] + (j == B[i].length - 1 ? "\n" : " "));
	}

	public static void printArr(short[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append(a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		System.out.println(s);
	}

	public static void printArr(short[][] B) {
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < B[i].length; j++)
				System.out.print(B[i][j] + (j == B[i].length - 1 ? "\n" : " "));
	}

	public static void print(double[] B, PrintWriter cout) {
		for (int i = 0; i < B.length; i++)
			cout.print(B[i] + (i == B.length - 1 ? "\n" : " "));
	}

	public static void print(boolean[][] B) {
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < B[i].length; j++)
				System.out.print(B[i][j] + (j == B[i].length - 1 ? "\n" : " "));
	}
}