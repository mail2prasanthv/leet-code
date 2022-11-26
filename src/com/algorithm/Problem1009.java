package com.algorithm;

public class Problem1009 {
	public static void main(String[] args) {

//		System.out.println(isMatchNewNew("aa", "a"));
//		System.out.println(isMatchNewNew("aa", "a*"));
//		System.out.println(isMatchNewNew("ab", ".*"));
//		System.out.println(isMatchNewNew("aab", "c*a*b"));
//		System.out.println(isMatchNewNew("aaa", "aa"));
//		System.out.println(isMatchNewNew("mississippi", "mis*is*ip*"));
//		System.out.println(isMatchNewNew("aa", "aa"));
//		System.out.println(isMatchNewNew("ab", ".*c"));
////		
//		System.out.println(isMatchNewNew("mississippi", "mis*is*ip*."));
//		
//		System.out.println(isMatchNewNew("aaa", "a.a"));
		System.out.println(isMatchNewNew("aaa", ".a"));
		
	}
	public static boolean isMatchNewNew(String s, String p) {
		
		char prevChar =0;
		int stringIndex = 0;
		for (int i = 0; i < p.length(); i++) {
			char patternChar = p.charAt(i);
			if(patternChar=='*') {
				if(prevChar!= 0) {
					// search for 0 or more occurance of prev Character.
					while (stringIndex < s.length()) {
						if (s.charAt(stringIndex) != prevChar) {
							break;
						}
						stringIndex++;
					}
				} else {
					// search for 0 or more occurance of any character
					while (stringIndex < s.length()) {
						stringIndex++;
					}
				}
				 prevChar =0;
			}else if(patternChar=='.') {
				if (stringIndex > s.length()) {
					return false;
				}
//				if(s.charAt(stringIndex) != prevChar) {
//					return false;
//				}
				///
//				if(s.charAt(stringIndex) != prevChar) {
//					return false;
//				}
				stringIndex++;
				if (stringIndex > s.length()) {
					return false;
				}
				stringIndex++;
				 prevChar =0;
			} else if(prevChar !=0 ) {
				if(s.charAt(stringIndex) != prevChar) {
					return false;
				}
				stringIndex++;
				prevChar = patternChar;
			} 
			else {
				prevChar = patternChar;
			}
			
			
		}
		if(prevChar!= 0) {
			if( stringIndex >= s.length()) {
				return false;
			}
			if(s.charAt(stringIndex) != prevChar) {
				return false;
			}
			stringIndex++;
		}	
		if( stringIndex >= s.length()) {
			return false;
		}
		return true;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean isMatch(String s, String p) {
		int stringIndex = 0;
		char previousChar = ' ';
		String staticString ="";
		boolean isValid= false;
		
		for (int i = 0; i < p.length(); i++) {
			char patternChar = p.charAt(i);
			if (patternChar == '.') {
				if (stringIndex > s.length()) {
					return false;
				}
//				previousChar = patternChar;
				stringIndex++;
				continue;
			}
			if (patternChar == '*') {
				if(staticString.length()>1) {
				 String substring = s.substring(stringIndex, stringIndex + staticString.length());
				 if(substring.equals(staticString)) {
					 staticString = "";
					 stringIndex = stringIndex + stringIndex + staticString.length();
				 } else {
					 return false;
				 }
				}
				while (stringIndex < s.length()) {
					if (s.charAt(stringIndex) != previousChar) {
						break;
					}
					stringIndex++;
				}
			}
			if(previousChar!= ' ' && patternChar!= '.' &&  patternChar!= '*') {
			staticString = staticString + previousChar;
			}
		if(patternChar!= '.' &&  patternChar!= '*') {
			previousChar = patternChar;
			}
		}
		if(stringIndex< s.length()-1) {
			return false;
		}
		
		return true;
	}

	public static boolean isMatchNew  (String s, String p) {
		int stringIndex = 0;
		char previousChar = 0;
		String staticString ="";
		boolean isValid= false;
		
		if(s.equals(p)) {
			return true;
		}
		
		for (int i = 0; i < p.length(); i++) {
			char patternChar = p.charAt(i);
			
			if((patternChar == '.' || patternChar == '*') && staticString.length()>0) {
				 String substring = s.substring(stringIndex, stringIndex + staticString.length());
				 if(substring.equals(staticString)) {
					 stringIndex = stringIndex + staticString.length();
					 staticString = "";
				 } else {
					 return false;
				 }
			}
			
			if (patternChar == '.') {
				if (stringIndex > s.length()) {
					return false;
				}
//				previousChar = patternChar;
				stringIndex++;
				continue;
			}
			if (patternChar == '*') {
				
				//if previousCharacter valid 
				
				if(previousChar!= 0) {
					for (;stringIndex<s.length();stringIndex++) {
						if(previousChar!= s.charAt(stringIndex)  ) {
							break;
						}
					}
				} else {
				
				
				while (stringIndex < s.length()) {
					if (s.charAt(stringIndex) != previousChar) {
						break;
					}
					stringIndex++;
				}
				}
				staticString="";
				previousChar=0;
			}
			
			if(previousChar!=0) {
				staticString = staticString + previousChar;
			}
			previousChar  = (patternChar!= '.' &&  patternChar!= '*')?patternChar:0;
			
			
		}
		if(stringIndex< s.length()-1) {
			return false;
		}
		if(previousChar!= 0) {
			 String substring = s.substring(stringIndex,  s.length());
			 if(previousChar != substring.charAt(0)) {
				 return false;
			 }
		}
		
		return true;
	}
}
