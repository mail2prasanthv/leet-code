package com.algorithm;

public class Problem1008 {
	public static void main(String[] args) {

	}

	public boolean isPalindrome(int x) {
		int reverse = 0;
		int original = x;
		while (x > 0) {
			int reminder = x % 10;
			reverse = reverse * 10 + reminder;
			x = x / 10;
		}
		return reverse == original;
	}

}
