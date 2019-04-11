/**
 * ��������
 */
package zj.ds.list;

/**
 * @author ZHAO Jing
 */
public class SeqList<T> {
	class Node<T> {
		public T info;
		public Node<T> next;

		public Node(T info) {
			this(info, null);
		}

		public Node(T info, Node<T> next) {
			this.info = info;
			this.next = next;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			if (this == null)
				return "null";
			if (next == null)
				return hashCode() + ":" + info + "-->null";
			return hashCode() + ":" + info + "-->" + next.hashCode();
		}
	}
	public Node<T> head;
	public Node<T> tail;
	int size;

	public SeqList() {
		head = tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void append(T e) {
		Node<T> node = new Node<T>(e);
		if (size++ == 0) {
			head = tail = node;
			head.next = null;
			return;
		}
		if (size++ == 1) {
			tail = node;
			head.next = tail;
			tail.next = null;
			return;
		}
		tail.next = node;
		tail = node;
		size++;
		return;
	}

	public void printAll() {
		for (Node<T> tmp = head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.info + "->");
		System.out.println();
	}

	@Override
	public String toString() {
		StringBuffer ans = new StringBuffer("[");
		for (Node<T> node = head; node != null; node = node.next)
			ans.append(node.info + ",");
		ans.setCharAt(ans.length() - 1, ']');
		return ans.toString();
	}

	public static void main(String[] args) {
		SeqList<Integer> list = new SeqList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.append(i);
			// System.out.println(list);
			list.printAll();
		}
	}

	public boolean find(Node<T> node) {
		for (Node<T> pNode = head; pNode != tail; pNode = pNode.next)
			if (pNode.info.equals(node.info))
				return true;
		return false;
	}
}
