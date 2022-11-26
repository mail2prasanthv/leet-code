package com.algorithm;

public class Problem1006 {
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
		System.out.println(reverseNew(1534236469));
		
	}

	public static long reverse(int x) {
		long rev = 0;
		int newX = Math.abs(x);
		int multiplyfactor = x<0?-1:1;
		int power = new String("" + newX).length() - 1;
		while (newX > 0) {

			int modulas = newX % 10;
			rev = (long) (rev + (modulas * Math.pow(10, power)));
			power--;
			newX= newX / 10;
		}
		return rev*multiplyfactor;
	}
	
	public static int reverseNew(int x) {
		
		
		
		long rev = 0;
		int newX = Math.abs(x);
		int multiplyfactor = x<0?-1:1;
		int power = new String("" + newX).length() - 1;
		while (newX > 0) {

			int modulas = newX % 10;
			rev = (long) (rev + modulas * Math.pow(10, power));
			if(rev>Integer.MAX_VALUE) {
				return 0;
			}
			power--;
			newX= newX / 10;
		}
		return (int)rev*multiplyfactor;
	}

}
