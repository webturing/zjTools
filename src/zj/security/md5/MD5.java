package zj.security.md5;

import java.security.MessageDigest;
import java.util.Scanner;

import sun.misc.BASE64Encoder;

public class MD5 {
	public static String md5(String s) {
		try {
			return new BASE64Encoder().encode(MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8")));
		} catch (Exception e) {
			return s;
		}
	}

	static Scanner cin = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println(MD5.md5("abcdefghijklmnopqrstuvwxyz1234567890"));
		System.out.println(MD5.md5("abcdefghijklmnopqrstuvwxyz123456789o"));
		System.out.println(MD5.md5("abcdefghijklmnopqrstuvwxyz1234567890"));
		String userPassword = "123456";
		String encodedPassword = MD5.md5(userPassword);//
		String userInput = cin.next();
		String encodeInput2 = MD5.md5(userInput);
		System.out.println(encodedPassword);
		// if(userInput.equals(userPassword))
		if (encodeInput2.equals(encodedPassword)) {
			System.out.println("Welcome");
		} else {
			System.out.println("Wrong");
		}
	}
}
