package zj.ds.sort;

import java.util.Random;
import zj.io.ArrayPrinter;
import zj.math.ComposeMath;

public class Sorter {
	static Random random = new Random();

	public static void main(String[] args) {
		char cs[] = "abcd".toCharArray();
		shuffle(cs);
		ArrayPrinter.print(cs);
		quickSort(cs);
		ArrayPrinter.print(cs);
		ComposeMath.next_permutation(cs);
		ArrayPrinter.print(cs);
		ComposeMath.next_permutation(cs);
	}

	public static void quickSort(Comparable a[]) {
		quickSort(a, 0, a.length - 1);
	}

	public static void quickSort(Comparable[] a, int b, int e) {
		ArrayPrinter.print(a);
		int i = b, j = e;
		Object x = a[(b + e) >> 1];
		do {
			while (a[i].compareTo(x) < 0)
				i++;
			while (a[j].compareTo(x) > 0)
				j--;
			if (i <= j)
				swap(a, i++, j--);
		} while (i < j);
		if (i < e)
			quickSort(a, i, e);
		if (j > b)
			quickSort(a, b, j);
	}

	public static void quickSort(double a[]) {
		quickSort(a, 0, a.length - 1);
	}

	public static void quickSort(double a[], int b, int e) {
		int i = b, j = e;
		double x = a[(b + e) >> 1];
		do {
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			if (i <= j)
				swap(a, i++, j--);
		} while (i < j);
		if (i < e)
			quickSort(a, i, e);
		if (j > b)
			quickSort(a, b, j);
	}

	public static void quickSort(char a[], int b, int e) {
		int i = b, j = e;
		double x = a[(b + e) >> 1];
		do {
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			if (i <= j)
				swap(a, i++, j--);
		} while (i < j);
		if (i < e)
			quickSort(a, i, e);
		if (j > b)
			quickSort(a, b, j);
	}

	public static void quickSort(float a[]) {
		quickSort(a, 0, a.length - 1);
	}

	public static void quickSort(float a[], int b, int e) {
		int i = b, j = e;
		float x = a[(b + e) >> 1];
		do {
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			if (i <= j)
				swap(a, i++, j--);
		} while (i < j);
		if (i < e)
			quickSort(a, i, e);
		if (j > b)
			quickSort(a, b, j);
	}

	public static void quickSort(int a[]) {
		quickSort(a, 0, a.length - 1);
	}

	public static void quickSort(int a[], int b, int e) {
		int i = b, j = e;
		double x = a[(b + e) >> 1];
		do {
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			if (i <= j)
				swap(a, i++, j--);
		} while (i < j);
		if (i < e)
			quickSort(a, i, e);
		if (j > b)
			quickSort(a, b, j);
	}

	public static void quickSort(long a[]) {
		quickSort(a, 0, a.length - 1);
	}

	public static void quickSort(long a[], int b, int e) {
		int i = b, j = e;
		long x = a[(b + e) >> 1];
		do {
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			if (i <= j)
				swap(a, i++, j--);
		} while (i < j);
		if (i < e)
			quickSort(a, i, e);
		if (j > b)
			quickSort(a, b, j);
	}

	public static void quickSort(short a[]) {
		quickSort(a, 0, a.length - 1);
	}

	public static void quickSort(short a[], int b, int e) {
		int i = b, j = e, x = a[(b + e) >> 1];
		do {
			while (a[i] < x)
				i++;
			while (a[j] > x)
				j--;
			if (i <= j)
				swap(a, i++, j--);
		} while (i < j);
		if (i < e)
			quickSort(a, i, e);
		if (j > b)
			quickSort(a, b, j);
	}

	public static void shuffle(boolean[] c) {
		for (int i = 0; i < c.length; i++) {
			swap(c, i, random.nextInt(c.length - i) + i);
		}
	}

	public static void shuffle(char[] c) {
		for (int i = 0; i < c.length; i++) {
			swap(c, i, random.nextInt(c.length - i) + i);
		}
	}

	public static void shuffle(double[] c) {
		for (int i = 0; i < c.length; i++) {
			swap(c, i, random.nextInt(c.length - i) + i);
		}
	}

	public static void shuffle(float[] c) {
		for (int i = 0; i < c.length; i++) {
			swap(c, i, random.nextInt(c.length - i) + i);
		}
	}

	public static void shuffle(int[] c) {
		for (int i = 0; i < c.length; i++) {
			swap(c, i, random.nextInt(c.length - i) + i);
		}
	}

	public static void shuffle(long[] c) {
		for (int i = 0; i < c.length; i++) {
			swap(c, i, random.nextInt(c.length - i) + i);
		}
	}

	public static void shuffle(Object[] c) {
		for (int i = 0; i < c.length; i++) {
			swap(c, i, random.nextInt(c.length - i) + i);
		}
	}

	public static void shuffle(short[] c) {
		for (int i = 0; i < c.length; i++) {
			swap(c, i, random.nextInt(c.length));
		}
	}

	public static void swap(boolean[] a, int i, int j) {
		boolean t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void swap(char[] a, int i, int j) {
		char t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void swap(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void swap(double[] a, int i, int j) {
		double t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void swap(float[] a, int i, int j) {
		float t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void swap(long[] a, int i, int j) {
		long t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void swap(Object[] a, int i, int j) {
		Object t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void swap(short[] a, int i, int j) {
		short t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void quickSort(char a[]) {
		quickSort(a, 0, a.length - 1);
	}
}
