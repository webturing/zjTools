package zj.ds.tree;

import zj.ds.sort.Sorter;
import zj.io.ArrayPrinter;

/**
 * 最大堆的java实现
 * 
 * @author Administrator
 * 
 */
public class Heap<T extends Comparable<T>> {
	private static final int DEFAULT_SIZE = 64;
	T[] A;
	int size;

	/**
	 * 初始化堆
	 */
	public Heap() {
		size = 0;
		A = (T[])new Object[DEFAULT_SIZE];
	}

	private void maxHeapify(int i) {
		int l = 2 * i, r = 2 * i + 1;
		int largest;
		if (l <= size && A[l] .compareTo(A[i])>0)
			largest = l;
		else
			largest = i;
		if (r <= size && A[r].compareTo(A[largest])>0)
			largest = r;
		if (largest != i) {
			Sorter.swap(A, i, largest);
			maxHeapify(largest);
		}
	}

	/**
	 * 入堆
	 * 
	 * @param e
	 */
	public void enqueue(T e) {
		ensureSpace();
		// 把e先插在最外面的节点 并调整保持堆的平衡性（通过交换该节点和父节点，对数时间可以完成）
		A[++size] = e;
		for (int curPos = size; curPos != 1 && A[curPos] .compareTo(A[curPos / 2])>0; curPos /= 2)
			Sorter.swap(A, curPos, curPos / 2);
	}

	/**
	 * 
	 */
	private void ensureSpace() {
		if (size == DEFAULT_SIZE) {// 支持空间动态翻倍
			T buffer[] =(T[]) new  Object[A.length * 2];
			System.arraycopy(A, 0, buffer, 0, A.length);
			A = buffer;
		}
	}

	/**
	 * 岀堆
	 * 
	 * @return
	 */
	public T dequeue() {
		if (isEmpty())
			throw new IllegalArgumentException();
		T root = A[1];// 记住根节点
		// 把最后的叶子节点移动到树根处，并调整保持堆的平衡性(对数时间可以完成）
		A[1] = A[size--];
		for (int curPos = 1; curPos <= size / 2;) {
			int newPos = (A[curPos * 2].compareTo( A[curPos * 2 + 1]))>0 ? curPos * 2
					: curPos * 2 + 1;
			Sorter.swap(A, curPos, newPos);
			curPos = newPos;
		}
		A[size + 1] = root;// 可以实现原地排序
		return root;
	}

	private boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 堆排序
	 * 
	 * @param a
	 */
	void sort(T[] a) {
		while (!isEmpty())
			dequeue();// 逐个岀堆即可
		System.arraycopy(A, 1, a, 0, a.length);
	}

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<Integer>();
		Integer a[] = { 12, 3, 123, 1, 23, 12, 3, 12, 3, 12, 3123, };
		heap.buildMaxHeap(a);
		heap.sort(a);
		ArrayPrinter.print(a);
	}

	@SuppressWarnings("unchecked")
	private void buildMaxHeap(T[] a) {
		A =(T[]) new Object[a.length + 1];
		System.arraycopy(a, 0, A, 1, a.length);
		size = a.length;
		for (int i = (size + 1) / 2; i >= 1; i--)
			maxHeapify(i);
	}

}
