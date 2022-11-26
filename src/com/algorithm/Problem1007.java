package com.algorithm;

public class Problem1007 {
	public static void main(String[] args) {
		System.out.println(myAtoi("words and 987"));
	}

	public static int myAtoi(String s) {

		 boolean isLeading = true;
			boolean isNegative = false;
			boolean skipAll = false;
			long number = 0;
			for (int i = 0; i < s.length(); i++) {
				char currChar = s.charAt(i);
				if (isLeading && currChar == ' ') {// || !Character.isDigit(currChar) || foundValidNumber) {
					continue;
				} else if (isLeading && (currChar == '+' || currChar == '-')) {
					if (currChar == '-') {
						isNegative = true;
					}
					isLeading = false;
					continue;
				} else if ((!Character.isDigit(currChar)) || skipAll) {
					skipAll = true;
					continue;
				}
				isLeading = false;
				number = (number * 10) + Character.getNumericValue(currChar);
				if(number> Integer.MAX_VALUE) {

					number = isNegative?Integer.MIN_VALUE : Integer.MAX_VALUE;
					return (int)number;
				}

			}
			return isNegative ? (int)number * -1 : (int)number;
	}

}
