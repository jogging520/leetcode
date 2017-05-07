package com.wq.alg0505h;

import java.util.Arrays;
import java.util.List;

/**
 * @author qiwu
 * @315
 * Given nums = [5, 2, 6, 1]

	To the right of 5 there are 2 smaller elements (2 and 1).
	To the right of 2 there is only 1 smaller element (1).
	To the right of 6 there is 1 smaller element (1).
	To the right of 1 there is 0 smaller element.
	Return the array [2, 1, 1, 0].


 */
public class Solution {
	 class Node{
		 Node left,right;
		 int val,Lsum,dup=1;
		 public Node(int val,int Lsum){
			 this.val=val;
			 this.Lsum=Lsum;
		 }
	 }
	 public List<Integer> countSmaller(int[] nums) {
		 Integer [] res=new Integer[nums.length];
		 Node root = null;
		 for (int i = nums.length - 1; i >= 0; i--) {
	         root = insert(nums[i], root, res, i, 0);
	     }
		 return Arrays.asList(res);
	 }
	 private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
		 if (node == null) {
	            node = new Node(num, 0);
	            ans[i] = preSum;
	     }else if (node.val==num){
	    	 node.dup++;
	    	 ans[i]=preSum+node.Lsum;
	     }else if(node.val>num){
	    	 node.Lsum++;
	    	 node.left=insert(num,node.left,ans,i,preSum);
	     }else{
	    	 node.right=insert(num,node.right,ans,i,preSum+node.Lsum+node.dup);
	     }

          return node;
	 }

}
