package com.algorithm;

public class Problem1010 {
	public static void main(String[] args) {
		System.out.println(maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}

	public static int maxArea(int[] height) {

		int maxVolume =0;
		for (int i=0; i < height.length; i++) {
;			for (int j=i+1; j < height.length; j++) {
				int capacity = height[i] < height[j]? height[i] : height[j];
				int length = j-i;
				int volume = capacity*length;
				if(maxVolume<volume) {
					maxVolume = volume;
				}
				
			}
		}
		return maxVolume;
	}
	public static int maxAreaNew(int[] height) {

		 int maxVolume =0;
			int left =0, right =height.length()-1;
			while (left<right) {
				int capacity = height[left] < height[right]? height[left] : height[right];
				int length = right-left;
				int volume = capacity*length;
				if(maxVolume<volume) {
					maxVolume = volume;
				}
				
				if(height[left] < height[right]) {
					left++;	
				} else if(height[left] > height[right]) {
					right--;	
				} else {
					left++;	
					right--;
				}
	        }
			return maxVolume;
	}

}
