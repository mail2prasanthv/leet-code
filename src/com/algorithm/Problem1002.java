package com.algorithm;

public class Problem1002 {
	public static void main(String[] args) {
		
		Problem1002 obj = new Problem1002();
		ListNode l1 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		l1.next = l12;
		ListNode l13 = new ListNode(3);
		l12.next = l13;
		
		ListNode l2 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		l2.next = l22;
		ListNode l23 = new ListNode(4);
		l22.next = l23;
		
		
		
		ListNode sum = obj.addTwoNumbersNew(l1, l2);
		System.out.println();
	}
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	        int power =0;
	        int num1 = 0;
	        ListNode currNode = l1;
	        while(currNode != null) {
	            num1 = num1 + ((int) (Math.pow(10,power))*currNode.val);
	            currNode = currNode.next;
	            power++;
	        }
	        power =0;
	        int num2 = 0;
	         currNode = l2;
	        while(currNode != null) {
	        	num2 = num2 + ((int) (Math.pow(10,power))*currNode.val);
	            currNode = currNode.next;
	            power++;
	        }
	        int sum = num1+num2;
	        
	        ListNode prevNode = null;
	       ListNode headNode = new  ListNode();
	        currNode = headNode;
	        while(sum>0) {
	            int modulus = sum%10;
	           currNode.val = modulus;
	            if(prevNode!= null) {
	                prevNode.next = currNode;
	            }
	            prevNode = currNode;
	            currNode = new  ListNode();
	            sum = sum/10;
	            
	        }
	        return headNode;
	        
	        
	    }

		public ListNode addTwoNumbersNew(ListNode l1, ListNode l2) {

			int reminder = 0;
			ListNode prevNode = null;
			ListNode headNode = new ListNode();
			ListNode currNode = headNode;
			while (l1 != null || l2 != null) {

				int num1 = l1 != null?l1.val : 0;
				int num2 = l2 != null?l2.val : 0;
				
				int sum = num1 + num2 + reminder;
				reminder = sum / 10;
				currNode.val = sum % 10;
				if (prevNode != null) {
					prevNode.next = currNode;
				}

				prevNode = currNode;
				currNode = new ListNode();
				if (l1 != null) {
					l1 = l1.next;
				}
				if (l2 != null) {
					l2 = l2.next;
				}
				
			}
			if(l1== null && l2== null && reminder>0) {
				currNode.val = reminder;
				if (prevNode != null) {
					prevNode.next = currNode;
				}
			}
			
			return headNode;

		}

}


  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
