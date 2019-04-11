package zj.iox;

import java.io.PrintStream;

public class ArrayPrinter<T> {
	public void print(T[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append( a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		System.out.println(s);
	}

	public void print(PrintStream out, T[] a) {
		StringBuffer s = new StringBuffer("{");
		for (int i = 0; i < a.length; i++)
			s.append(a[i] + ",");
		s.setCharAt(s.length() - 1, '}');
		out.println(s);
	}

	public void print(T[][] B) {
		print(B, System.out);
	}

	public void print(T[][] B, PrintStream out) {
		for (int i = 0; i < B.length; i++)
			for (int j = 0; j < B[i].length; j++)
				System.out.print(B[i][j] + (j == B[i].length - 1 ? "\n" : " "));
	}
}