package com.algorithm;

import java.util.TreeMap;

public class Problem1004 {
	public static void main(String[] args) {

		System.out.println(longestPalindromeNew("babad"));
		System.out.println(longestPalindromeNew("cbbd"));
	}
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}}
	
	public static String longestPalindromeNew(String s) {
		
		String largest ="";
		for(int i=0; i < s.length(); i++) {
			for(int j=i+1; j < s.length()+1; j++) {
				String palindrome = s.substring(i, j);
				boolean isPalindrome = isPalindrome(palindrome);
				if(isPalindrome && largest.length()< palindrome.length()) {
					largest = palindrome;
				}
			}
		}
		return largest;
	}

	private static boolean isPalindrome(String newString) {

		int length = newString.length();
		
		for(int i=0,j= length-1;i< length/2; i++,j--) {
			if(newString.charAt(i)!= newString.charAt(j)) {
				return false;
			}
		}
		return true;
	}

}
