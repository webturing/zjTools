package zj.string;

import java.util.Arrays;

public class StringTools {

	public static boolean isInteger(String s) {
		return s.matches("\\d+|(\\+|-)\\d+");
	}

	public static boolean isNumber(String s) {
		return isInteger(s) || isFloat(s);
	}

	public static boolean isFloat(String s) {
		return s.matches("(\\+|-)(\\d+.\\d*)|(\\d*.\\d+)");

	}

	public static void main(String[] args) {
		System.out.println(isInteger("23"));
		System.out.println(isInteger("+23"));
		System.out.println(isInteger("-23"));
		System.out.println(isFloat("2.3"));
		System.out.println(isFloat("+2.3"));
	}
}
