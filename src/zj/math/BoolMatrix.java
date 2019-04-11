/**
 * 
 */
package zj.math;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author ZHAO Jing
 * 
 */
public class BoolMatrix {
	

	static Random r = new Random();

	public static BoolMatrix IdentMatrix(int n) {
		BoolMatrix ansBoolMatrix = new BoolMatrix(n);
		for (int i = 0; i < n; i++)
			ansBoolMatrix.data[i][i] = true;
		return ansBoolMatrix;
	}

	public static BoolMatrix oneMatrix(int n) {
		return new BoolMatrix(n).not();
	}

	static BoolMatrix randBoolMatrix() {
		return randBoolMatrix(2, 0.5);
	}

	public static BoolMatrix randBoolMatrix(int size, double prob) {
		BoolMatrix boolMatrix = new BoolMatrix(size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (r.nextDouble() > prob)
					boolMatrix.data[i][j] = true;
			}
		}
		return boolMatrix;
	}

	public static BoolMatrix zeroMatrix(int n) {
		return new BoolMatrix(n);
	}

	int size;
	boolean data[][];

	/**
  * 
  */
	public BoolMatrix() {
		this(2);
	}

	public BoolMatrix(BoolMatrix that) {
		this.size = that.size;
		this.data = that.data.clone();
	}

	public BoolMatrix(int n) {
		this.size = n;
		data = new boolean[n][n];
	}

	public BoolMatrix and(BoolMatrix other) {
		if (this.size != other.size)
			throw new IllegalArgumentException();
		BoolMatrix ansBoolMatrix = new BoolMatrix(this.size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				ansBoolMatrix.data[i][j] = this.data[i][j] && other.data[i][j];
			}
		}
		return ansBoolMatrix;
	}

	private boolean checkRange(int k) {
		return k >= 0 && k < size;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BoolMatrix))
			return false;
		BoolMatrix boolMatrix = (BoolMatrix) obj;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				if (this.data[i][j] != boolMatrix.data[i][j])
					return false;
			}
		return true;
	}

	boolean get(int r, int c) {
		if (checkRange(r) && checkRange(c))
			return data[r][c];
		throw new IllegalArgumentException("Imcompatible dimensions!");
	}

	public boolean isZeros() {
		return equals(zeroMatrix(size));
	}

	public BoolMatrix mul(BoolMatrix inc) {
		if (this.size != inc.size)
			throw new IllegalArgumentException();
		BoolMatrix ansBoolMatrix = new BoolMatrix(this.size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (ansBoolMatrix.data[i][j])
						break;
					else
						ansBoolMatrix.data[i][j] = this.data[i][k]
								&& inc.data[k][j];
				}
			}
		}
		return ansBoolMatrix;
	}

	BoolMatrix not() {
		BoolMatrix ansBoolMatrix = new BoolMatrix(this.size);
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				ansBoolMatrix.data[i][j] = !this.data[i][j];
		return ansBoolMatrix;
	}

	BoolMatrix or(BoolMatrix other) {
		if (this.size != other.size)
			throw new IllegalArgumentException();
		BoolMatrix ansBoolMatrix = new BoolMatrix(this.size);
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				ansBoolMatrix.data[i][j] = this.data[i][j] || other.data[i][j];
		return ansBoolMatrix;
	}

	BoolMatrix pow(int times) {
		if (isZeros() || times == 1)
			return this;
		if (times == 0)
			return BoolMatrix.IdentMatrix(size);
		else if (times % 2 == 0)
			return square().pow(times / 2);
		return square().pow(times / 2).mul(this);
	}

	/**
	 * Warshall:算法O(n^3)
	 * 
	 * @return
	 */
	public BoolMatrix quickTrans() {
		BoolMatrix A = new BoolMatrix(this);
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (A.get(j, i))
					for (int k = 0; k < size; k++)
						A.data[j][k] = A.data[j][k] || A.data[i][k];
		return A;
	}

	boolean reset(int r, int c) {
		if (checkRange(r) && checkRange(c)) {
			data[r][c] = false;
			return true;
		}
		return false;
	}

	boolean set(int r, int c) {
		if (checkRange(r) && checkRange(c)) {
			data[r][c] = true;
			return true;
		}
		return false;
	}

	public BoolMatrix square() {
		return this.mul(this);
	}

	@Override
	public String toString() {
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				ans.append(data[i][j] ? '1' : '0');
			}
			ans.append('\n');
		}
		return new String(ans);
	}

	BoolMatrix trans() {
		BoolMatrix ansBoolMatrix = new BoolMatrix(size);
		for (int i = 1; i <= size; i++)
			ansBoolMatrix = ansBoolMatrix.or(pow(i));
		return ansBoolMatrix;
	}
}
