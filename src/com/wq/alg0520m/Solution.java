package com.wq.alg0520m;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	 public List<Integer> preorderTraversal(TreeNode root) {
	       List<Integer>resList=new ArrayList<Integer>();
	       if(null==root) return resList;
	       resList.add(root.val);
	       preorderTraversal(root.left);
	       preorderTraversal(root.right);
	       return resList;
	 }
	
	
	
	
	public class TreeNode {
		    int val;
	        TreeNode left;
	        TreeNode right;
	        TreeNode(int x) { val = x; }
    }

}
