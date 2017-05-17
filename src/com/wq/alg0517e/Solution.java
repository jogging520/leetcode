package com.wq.alg0517e;

/**
   @ClassName: Solution 
   @Description: TODO
   @param  
   @return 
 * @author Administrator
 * 2017年5月17日 上午8:57:55   
 */
public class Solution {
	public class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;
		    TreeNode(int x) { val = x; } 
	}
	 int min=Integer.MAX_VALUE;
     Integer pre=null;
     public int getMinimumDifference(TreeNode root) {
         
         if(root==null) return min;
         getMinimumDifference(root.left);
         if(pre!=null){ 
        	 min=Integer.min(min, root.val-pre);
         }
    	 pre=root.val;
    	 getMinimumDifference(root.right);
    	 return min;
     }

}
