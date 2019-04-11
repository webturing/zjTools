package zj.math;

public class Matrix {
	public static Matrix identityMatrix(int size) {
		Matrix ansMatrix = new Matrix(size);
		for (int i = 0; i < size; i++)
			ansMatrix.data[i][i] = 1;
		return ansMatrix;
	}
	public static Matrix randMatrix(int size) {
		return randMatrix(size, size);
	}

	public static Matrix randMatrix(int row, int col) {
		Matrix ansMatrix = new Matrix(row, col);
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				ansMatrix.data[i][j] = Math.random();
		return ansMatrix;
	}

	public static Matrix zeroMatrix(int size) {
		return zeroMatrix(size, size);
	}

	public static Matrix zeroMatrix(int row, int col) {
		return new Matrix(row, col);
	}
	protected int row;
	protected int col;
	protected double[][] data;

	public Matrix() {
		this(2);
	}

	public Matrix(double[][] a) {
		this(a.length, a[0].length);
		data = a.clone();
	}
	public Matrix(int n) {
		this(n, n);
	}

	public Matrix(int row, int col) {
		this.row = row;
		this.col = col;
		data = new double[row][col];
	}

	public Matrix(Matrix matrix) {
		this(matrix.data);
	}

	public Matrix(int[][] b) {
		data = new double[b.length][b.length];
		for (int i = 0; i < b.length; i++)
			for (int j = 0; j < b.length; j++) {
				data[i][j] = b[i][j];
			}
		row = col = b.length;
	}

	public Matrix(float[][] b) {
		data = new double[b.length][b.length];
		for (int i = 0; i < b.length; i++)
			for (int j = 0; j < b.length; j++) {
				data[i][j] = b[i][j];
			}
		row = col = b.length;
	}

	public Matrix(long[][] b) {
		data = new double[b.length][b.length];
		for (int i = 0; i < b.length; i++)
			for (int j = 0; j < b.length; j++) {
				data[i][j] = b[i][j];
			}
		row = col = b.length;
	}

	public Matrix add(Matrix that) {
		if (this.row != that.row || this.col != that.col)
			throw new IllegalArgumentException("Incompatiable dimensions!");
		Matrix answer = new Matrix(this);
		for (int i = 0; i < answer.row; i++)
			for (int j = 0; j < answer.col; j++)
				answer.data[i][j] += that.data[i][j];
		return answer;
	}

	private Matrix algebraRemainMatrix(int x, int y) {
		Matrix answer = new Matrix(row - 1, col - 1);
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++)
				answer.data[i][j] = data[i][j];
		for (int i = x; i < answer.row; i++)
			for (int j = 0; j < y; j++)
				answer.data[i][j] = data[i + 1][j];
		for (int i = 0; i < x; i++)
			for (int j = y; j < answer.col; j++)
				answer.data[i][j] = data[i][j + 1];
		for (int i = x; i < answer.row; i++)
			for (int j = y; j < answer.col; j++)
				answer.data[i][j] = data[i + 1][j + 1];
		return answer;
	}
	public double det() {
		if (!isSquareMatrix())
			throw new IllegalArgumentException();
		if (row == 0)
			return 0;
		if (this.row == 1)
			return data[0][0];
		if (row == 2)
			return data[0][0] * data[1][1] - data[0][1] * data[1][0];
		double sum = 0;
		for (int i = 0; i < row; i++)
			sum += (1 - (i & 1)) * data[0][i] * algebraRemainMatrix(0, i).det();
		return sum;
	}

	public boolean equals(Matrix that) {
		if (this.row != that.row || this.col != that.col)
			return false;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (this.data[i][j] != that.data[i][j])
					return false;
		return true;
	}

	private Matrix getUnitMatrix() {
		if (!this.isSquareMatrix())
			throw new IllegalArgumentException();
		Matrix ans = new Matrix(this.row, this.col);
		for (int i = 0; i < row; i++)
			ans.data[i][i] = 1;
		return ans;
	}

	public boolean isSquareMatrix() {
		return this.row == col;
	}

	public boolean isUnitMatrix() {
		if (!isSquareMatrix())
			return false;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (!(i == j && data[i][j] == 1 || i != j && data[i][j] == 0))
					return false;
		return true;
	}
	public boolean isZeroMatrix() {
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				if (data[i][j] != 0)
					return false;
		return true;
	}

	public Matrix multiply(double ratio) {
		Matrix answer = new Matrix(this);
		for (int i = 0; i < answer.row; i++)
			for (int j = 0; j < answer.col; j++)
				answer.data[i][j] *= ratio;
		return answer;
	}
	public Matrix multiply(Matrix that) {
		if (this.col != that.row)
			throw new IllegalArgumentException();
		Matrix answer = new Matrix(this.row, that.col);
		for (int i = 0; i < answer.row; i++)
			for (int j = 0; j < answer.col; j++)
				for (int k = 0; k < this.col; k++)
					answer.data[i][j] += this.data[i][k] * that.data[k][j];
		return answer;
	}

	public Matrix power(int times) {
		if (!this.isSquareMatrix())
			throw new IllegalArgumentException();
		if (this.isZeroMatrix() || this.isUnitMatrix() || times == 1)
			return new Matrix(this);
		if (times == 0)
			return getUnitMatrix();
		if (times % 2 == 0)
			return this.square().power(times / 2);
		return this.square().power(times / 2).multiply(this);
	}

	public Matrix square() {
		return this.multiply(this);
	}

	public Matrix substract(Matrix that) {
		if (this.row != that.row || this.col != that.col)
			throw new IllegalArgumentException("Incompatiable dimensions!");
		Matrix answer = new Matrix(this);
		for (int i = 0; i < answer.row; i++)
			for (int j = 0; j < answer.col; j++)
				answer.data[i][j] -= that.data[i][j];
		return answer;
	}

	@Override
	public String toString() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("size:" + row + "X" + col + "\n");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				sBuffer.append(data[i][j] + " ");
			sBuffer.append('\n');
		}
		return sBuffer.toString();
	}

	public Matrix transpose() {
		Matrix answer = new Matrix(col, row);
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				answer.data[j][i] = data[i][j];
		return answer;
	}
}
