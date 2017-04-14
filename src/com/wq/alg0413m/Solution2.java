package com.wq.alg0413m;

import com.wq.alg0413m.Solution.TreeNode;

public class Solution2 {
	public class Solution {
	    int ans=0, h=0;
	    public int findBottomLeftValue(TreeNode root) {
	        findBottomLeftValue(root, 1);
	        return ans;
	    }
	    public void findBottomLeftValue(TreeNode root, int depth) {
	        if (h<depth) {ans=root.val;h=depth;}
	        if (root.left!=null) findBottomLeftValue(root.left, depth+1);
	        if (root.right!=null) findBottomLeftValue(root.right, depth+1);
	    }
	}
	 public class TreeNode {
	        int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	    }
}
