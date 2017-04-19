package com.wq.alg0419m;

import com.wq.alg0417m.Solution.TreeNode;

public class Solution {
	 public void flatten(TreeNode root) {
		 if(root==null) return ;
		 TreeNode leftNode=root.left;
		 TreeNode rightNode=root.right;
		 root.left=null;
		 flatten(leftNode);
		 flatten(rightNode);//先序遍历结束后，将左右缝合！
		 root.right = leftNode;
		 TreeNode curNode=root;
		 while(curNode.right!=null){
			 curNode=curNode.right;
		 }
		 curNode.right=rightNode;
	 }
	



	public class TreeNode {
        int      val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
     }

}
