package zj.ds.list;

/**
 * ���е�����ʵ��
 * 
 * @author ZHAO Jing
 */
public class LinkQueue<T> {
	DoubleList<T> list;

	public LinkQueue() {
		list = new DoubleList<T>();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void enQueue(T o) {
		list.append(o);
	}

	public T deQueue() {
		return list.popFirst();
	}

	public int getSize() {
		return list.getSize();
	}

	public void printAll() {
		list.printAll();
	}

	public static void main(String[] args) {
		LinkQueue<Integer> queue = new LinkQueue<Integer>();
		for (int i = 0; i < 10; i++)
			queue.enQueue(i);
		System.out.println(queue);
		while (!queue.isEmpty())
			System.out.println(queue.deQueue());
	}

	@Override
	public String toString() {
		return list.toString();
	}
}
