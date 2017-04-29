package com.wq.alg0422e;

/**
 * @author qiwu
 * @108
 */
public class Solution {
	
     public TreeNode sortedArrayToBST(int[] nums) {
    	 
    	  return helper(nums,0,nums.length-1);
     }
     private TreeNode helper(int[] nums, int start, int end) {
		if(start>end) return null;
		int mid=start+(start-end)/2;
		TreeNode node=new TreeNode(nums[mid]);
		node.left=helper(nums,0,mid-1);
		node.right=helper(nums,mid+1,nums.length-1);
		return node;
	}
	public class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
     }

}
