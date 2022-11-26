package com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Problem1005 {
	public static void main(String[] args) {
		String convert = convert("PAYPALISHIRING", 3);
		System.out.println(convert);
		
//		convert = convert("A", 1);
//		System.out.println(convert);
		
		convert = convert("ABC", 1);
		System.out.println(convert);
		
	}

	public static String convert(String s, int numRows) {

		char[][] s1 = new char[numRows][(s.length())];
		int[] size = new int[numRows];

		boolean increase = true;
		int mainIndex = 0;
		for (int i = 0; i < s.length(); i++) {

			s1[mainIndex][size[mainIndex]] = s.charAt(i);
			size[mainIndex]++;

			if (numRows != 1) {
				if (increase) {
					mainIndex++;
				} else {
					mainIndex--;
				}
				if (mainIndex == numRows) {
					increase = false;
					mainIndex = numRows - 2;
					if (mainIndex == -1) {
						mainIndex = 0;
					}
				} else if (mainIndex == -1) {
					increase = true;
					mainIndex = 1;
				}
			}

		}
		String finalStr = "";
		for (int i = 0; i < numRows; i++) {
			finalStr = finalStr + String.copyValueOf(s1[i], 0, size[i]);
		}
		return finalStr;
	}

}
