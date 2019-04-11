package zj.ds.tree;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
	static void test() {
		String[] post = "a b + c d e + * * ".split(" ");
		ArrayList<String> expArrayList = new ArrayList<String>();
		expArrayList.addAll(Arrays.asList(post));
		BinaryTree binaryNode = new BinaryTree(expArrayList);
		binaryNode.midVisited();// ���Խ��((a+b)*(c*(d+e)))
		System.out.println();
		binaryNode.preVisited();// ���Խ��*+ab*c+de
		System.out.println();
		binaryNode.postVisited();// ���Խ��ab+cde+**
		System.out.println();
		System.out.println("Total elements:" + binaryNode.getElem());
		System.out.println("Tree depth:" + binaryNode.getDepth());
	}

	public static void main(String[] args) {
		test();
	}

	Object element;
	BinaryTree left;
	BinaryTree right;

	public BinaryTree() {
		this(null, null, null);
	}

	/**
	 * ����沨��ʽ��ɶ������ǵݹ��㷨
	 * 
	 * @param lrExp
	 */
	public BinaryTree(List<String> lrExp) {
		// ab+cde+**
		Stack<BinaryTree> sBinaryNodes = new Stack<BinaryTree>();
		BinaryTree root = null;
		for (int i = 0; i < lrExp.size(); i++) {
			if ("+-*/^".contains(lrExp.get(i))) {
				root = new BinaryTree(lrExp.get(i), null, null);
				root.right = sBinaryNodes.pop();
				root.left = sBinaryNodes.pop();
				sBinaryNodes.push(root);
			} else {
				root = new BinaryTree(lrExp.get(i), null, null);
				sBinaryNodes.push(root);
			}
		}
		if (sBinaryNodes.size() != 1)
			throw new IllegalArgumentException("�Ƿ����沨��ʽ");
		else {
			this.element = root.element;
			this.left = root.left;
			this.right = root.right;
		}
	}

	public BinaryTree(Object ele, BinaryTree left, BinaryTree right) {
		this.element = ele;
		this.left = left;
		this.right = right;
	}

	int getElem() {
		if (isEmpty())
			return 0;
		int s = 1;
		if (left != null)
			s += left.getElem();
		if (right != null)
			s += right.getElem();
		return s;
	}

	public int getDepth() {
		if (isEmpty())
			return 0;
		int s = 1, l = 0, r = 0;
		if (left != null)
			l = left.getDepth();
		if (right != null)
			r = right.getDepth();
		return Math.max(l, r) + s;
	}

	public boolean isEmpty() {
		return element == null;
	}

	/**
	 * ���ʽ���������Ϊ�˱�֤���˳������������
	 */
	public void midVisited() {
		midVisited(System.out);
	}
	public void preVisited() {
		midVisited(System.out);
	}
	public void postVisited() {
		midVisited(System.out);
	}
	public void midVisited(PrintStream out) {
		if (isEmpty())
			return;
		if (left != null) {
			out.print("(");
			left.midVisited(out);
		}
		out.print(element);
		if (right != null) {
			right.midVisited(out);
			out.print(")");
		}
	}
	public void preVisited(PrintStream out) {
		if (isEmpty())
			return;
		out.print(element);
		if (left != null)
			left.preVisited(out);
		if (right != null)
			right.preVisited(out);
	}

	public void postVisited(PrintStream out) {
		if (isEmpty())
			return;
		if (left != null)
			left.postVisited(out);
		if (right != null)
			right.postVisited(out);
		out.print(element);
	}
}