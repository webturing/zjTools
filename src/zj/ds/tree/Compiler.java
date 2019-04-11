package zj.ds.tree;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

import zj.string.StringTools;

public class Compiler {
	final static double ERROR_VALUE = Math.E;

	public static void rPolandExpToMidExp(String[] exp, PrintStream out) {
		ArrayList<String> expArrayList = new ArrayList<String>();
		expArrayList.addAll(Arrays.asList(exp));
		BinaryTree binaryNode = new BinaryTree(expArrayList);
		binaryNode.midVisited(out);
		out.println();
	}

	public static double value(String[] exp) {
		Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < exp.length; i++) {
			String tok = exp[i];
			if (StringTools.isNumber(exp[i]))
				stack.push(Double.parseDouble(exp[i]));
			else if ("+-*/".contains(tok))
				if (stack.size() >= 2) {
					double op2 = stack.pop();
					double op1 = stack.pop();
					double ans = 0;
					if (tok.equals("+"))
						ans = op1 + op2;
					else if (tok.equals("-"))
						ans = op1 - op2;
					else if (tok.equals("*"))
						ans = op1 * op2;
					else if (tok.equals("/"))
						ans = op1 / op2;
					stack.push(new Double(ans));
				} else
					return ERROR_VALUE;

		}
		return stack.size() == 1 ? stack.peek() : ERROR_VALUE;
	}

	public static void rPolandExpToMidExp(LinkedList<String> exp) {
		String[] ss = new String[exp.size()];
		for (int i = 0; i < exp.size(); i++) {
			ss[i] = exp.get(i);
		}
		rPolandExpToMidExp(ss,System.out);
	}

	
}
