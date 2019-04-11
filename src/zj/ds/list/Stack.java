package zj.ds.list;

/**
 * ����汾��ͨ������ջʵ�֣�֧���ڴ涯̬����
 * 
 * @author ZHAO Jing
 */
public class Stack<T> {
	final static int DEFAULT_SIZE = 64;
	protected int size;

	public int getSize() {
		return size;
	}

	T[] data;

	public Stack() {
		size = 0;
		data = (T[])new Object[DEFAULT_SIZE];
	}

	public void push(T o) {
		if (size == data.length - 1) {
			T[] dataCopy = (T[])new Object[data.length * 2];
			System.arraycopy(data, 0, dataCopy, 0, data.length);
			data = dataCopy;
		}
		data[size++] = o;
	}

	public T pop() {
		if (!isEmpty())
			return data[--size];
		return null;
	}

	public Object top() {
		if (!isEmpty())
			return data[size - 1];
		return null;
	}

	public void printAll() {
		for (int i = 0; i < size; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < 100; i++) {
			stack.push(i);
			System.out.println(stack);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		StringBuffer ans = new StringBuffer("[");
		for (int i = 0; i < +size; i++)
			ans.append(data[i] + ",");
		ans.setCharAt(ans.length() - 1, ']');
		return ans.toString();
	}
}
