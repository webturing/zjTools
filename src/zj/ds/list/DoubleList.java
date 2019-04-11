/**
 * ˫����ʵ��
 */
package zj.ds.list;

/**
 * @author Administrator
 */
public class DoubleList<T> {
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
				if (this == null)
					return "null";
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
	public Node<T> head;
	public Node<T> tail;
	public int size;

	public DoubleList() {
		head = tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void append(T i) {
		Node<T> node = new Node<T>(i);
		if (size == 0) {
			head = tail = node;
		} else if (size == 1) {
			tail.next = node;
			tail = node;
			node.pre = head;
		} else {
			Node<T> pre = tail;
			pre.next = node;
			node.pre = pre;
			node.next = null;
			tail = node;
		}
		size++;
	}

	public void printAll() {
		for (Node<T> temp = head; temp != null; temp = temp.next)
			System.out.print(temp.info + " ");
		System.out.println();
	}

	public void rprintAll() {
		for (Node<T> temp = tail; temp != null; temp = temp.pre)
			System.out.print(temp.info + " ");
		System.out.println();
	}

	public void insert(T o, Node cur) {
		Node<T> node = new Node<T>(o);
		Node<T> pre = cur, next = pre.next;
		pre.next = node;
		node.pre = pre;
		node.next = next;
		next.pre = node;
		size++;
	}

	public static void main(String[] args) {
		DoubleList<Integer> list = new DoubleList<Integer>();
		for (int i = 0; i < 10; i++)
			list.append(i);
		list.printAll();
		list.rprintAll();
	}

	public T popFirst() {
		Node<T> result = head;
		remove(head);
		return result.info;
	}

	public T popLast() {
		Node<T> result = tail;
		remove(tail);
		return result.info;
	}

	private void remove(Node<T> cur) {
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
				head.pre = head.next = null;
				size = 1;
				return;
			}
			if (cur == tail) {
				tail = head;
				head.pre = head.next = null;
				size = 1;
				return;
			}
			return;
		}
		if (cur == head) {
			Node<T> next = cur.next;
			next.pre = null;
			head = next;
			size--;
			return;
		}
		if (cur == tail) {
			Node<T> pre = cur.pre;
			pre.next = null;
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

	public int getSize() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer ans = new StringBuffer("[");
		for (Node node = head; node != null; node = node.next)
			ans.append(node.info + ",");
		ans.setCharAt(ans.length() - 1, ']');
		return ans.toString();
	}
}
