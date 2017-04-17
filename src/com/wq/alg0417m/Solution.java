package com.wq.alg0417m;

import com.wq.alg0415m.Solution2.TreeNode;

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
    	if(root==null) return true;
    	if(root.left!=null&&root.right!=null) {
    	    if(root.left.val<root.val&&root.right.val>root.val){
    	    	return isValidBST(root.left)&&isValidBST(root.right);
    	    }
    	    return false;
    	}
    		    
        
    	if(root.left!=null||root.right==null){
    		if(root.left.val<root.val){
    	    	return isValidBST(root.left);
    	    }
    	    return false;

    	}
    	if(root.left==null||root.right!=null){
    		if(root.right.val>root.val){
    	    	return isValidBST(root.right);
    	    }
    	    return false;

    	}
    	if(root.left==null||root.right!=null){
    		return true;
    	}
	    return false;
    }
    public class TreeNode {
        int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
    }
}
