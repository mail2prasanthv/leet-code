package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Problem1003 {
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
		
		s = "bbbbb";
		System.out.println(lengthOfLongestSubstring(s));
		
		s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
		
	}

	public static int lengthOfLongestSubstring(String s) {
		int largest = s== null|| s.length()==0?0:1;
		Map<Character, Integer> map = new HashMap<>();
		int index = 0;
		for (int i = index; i < s.length(); i++) {
			char eachChar = s.charAt(i);
			if (map.containsKey(eachChar)) {
				if (largest < map.size()) {
					largest = map.size();
				}
				map = new HashMap<>();
				index++;
				i = index - 1;
			} else {
				map.put(eachChar, i);
			}

		}
		if (largest < map.size()) {
			largest = map.size();
		}
		return largest;
	}

}
