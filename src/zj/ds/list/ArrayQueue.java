package zj.ds.list;

/**
 * ������е�ʵ�֣�֧�ֶ�̬�ڴ淭������
 * 
 * @author Administrator
 */
public class ArrayQueue<T> {
	private static final int DEFAUL_SIZE = 64;
	int startPos = 0;
	int size;
	Object[] data;

	public ArrayQueue() {
		data = new Object[DEFAUL_SIZE];
		size = startPos = 0;
	}

	public void enQueue(Object o) {
		if (startPos + size == data.length - 1) {
			Object[] temp = new Object[size * 2];
			System.arraycopy(data, startPos, temp, 0, size);
			data = temp;
			startPos = 0;
		}
		data[startPos + size++] = o;
	}

	public Object deQueue() {
		size--;
		return data[startPos++];
	}

	public void printAll() {
		for (int i = startPos; i < startPos + size; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
		for (int i = 0; i < 100; i++)
			queue.enQueue(i);
		System.out.println(queue);
		for (int i = 0; i < 100; i++)
			System.out.print(queue.deQueue()+" ");
	}

	@Override
	public String toString() {
		StringBuffer ans = new StringBuffer("[");
		for (int i = startPos; i < startPos + size; i++)
			ans.append(data[i] + ",");
		ans.setCharAt(ans.length() - 1, ']');
		return ans.toString();
	}
}
