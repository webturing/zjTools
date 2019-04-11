package zj.ds.list;

/**
 * ѭ��˫�����ʵ��
 * 
 * @author ZHAO Jing
 */
public class CycList<T> {
	 @SuppressWarnings("hiding")
	class Node <T>{
			public T info;
			public Node<T> pre, next;

			public Node(T info) {
				this(info, null, null);
			}

			public Node(T info, Node<T> pre, Node<T> next) {
				this.info = info;
				this.pre = pre;
				this.next = next;
			}

			@Override
			public String toString() {
				if (pre == null && next == null)
					return hashCode() + ":" + "null-->" + info + "-->null";
				if (pre == null)
					return hashCode() + ":" + "null-->" + info + "-->"
							+ next.hashCode();
				if (next == null)
					return hashCode() + ":" + pre.hashCode() + info + "-->null";
				return hashCode() + ":" + pre.hashCode() + "-->" + info + "-->"
						+ next.hashCode();
			}

		}
	public int size;
	public Node<T> head;
	public Node<T> tail;

	public CycList() {
		head = tail = null;
		size = 0;
	}

	public void append(T e) {
		Node<T> node = new Node<T>(e);
		if (size == 0) {
			head = tail = node;
			head.next = head.pre = head;
			size = 1;
			return;
		}
		if (size == 1) {
			head.next = node;
			node.pre = head;
			node.next = head;
			head.pre = node;
			tail = node;
			size = 2;
			return;
		}
		size++;
		Node<T> pre = tail, next = head;
		pre.next = node;
		node.pre = pre;
		node.next = next;
		next.pre = node;
		tail = node;
	}

	public void remove(Node<T> cur) {
		if (isEmpty())
			return;
		if (size == 1 && cur == head) {
			head = tail = null;
			size = 0;
			return;
		}
		if (size == 2) {
			if (cur == head) {
				head = tail;
				head.pre = head.next = head;
				size = 1;
				return;
			}
			if (cur == tail) {
				tail = head;
				head.pre = head.next = head;
				size = 1;
				return;
			}
			return;
		}
		if (cur == head) {
			Node<T> pre = tail, next = head.next;
			pre.next = next;
			next.pre = pre;
			size--;
			head = next;
			return;
		}
		if (cur == tail) {
			Node<T> pre = cur.pre, next = head;
			pre.next = next;
			next.pre = pre;
			size--;
			tail = pre;
			return;
		}
		Node<T> pre = cur.pre, next = cur.next;
		pre.next = next;
		next.pre = pre;
		size--;
		return;
	}

	private boolean isEmpty() {
		return size == 0;
	}

	public void printAll() {
		int i = 0;
		for (Node<T> cur = head; i++ < size; cur = cur.next)
			System.out.print(cur.info + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		CycList<Integer> cycList = new CycList<Integer>();
		for (int i = 0; i < 10; i++)
			cycList.append(i);
		System.out.println(cycList);
		cycList.printAll();
	}

	public void addFirst(Node biNode) {
		head = tail = biNode;
		head.next = head.pre = head;
		size++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer ans = new StringBuffer("[");
		int i = 0;
		for (Node<T> cur = head; i++ < size; cur = cur.next)
			ans.append(cur.info + ",");
		ans.setCharAt(ans.length() - 1, ']');
		return ans.toString();
	}
}
