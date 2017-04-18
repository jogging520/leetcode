package com.wq.alg0417m;

/**
 * @author Administrator
 * @98
	 * Example 1:
	    2
	   / \
	  1   3
	Binary tree [2,1,3], return true.
	Example 2:
	    1
	   / \
	  2   3
	Binary tree [1,2,3], return false.
 * 2017年4月17日 上午9:00:19   
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
    	return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean helper(TreeNode node, long minValue, long maxValue) {
    	if(node==null) return true;
    	if(node.val<=minValue||node.val>=maxValue)  return false;
    	
		return helper(node.left,minValue,node.val)&&helper(node.right,node.val,maxValue);
	}
	public class TreeNode {
          int      val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
    }
}
