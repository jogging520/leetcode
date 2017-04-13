package com.wq.alg0412e;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
	public boolean isSymmetric(TreeNode root) {
	
		if(root==null) return false;
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode left=queue.poll();
			TreeNode right=queue.poll();
			if(left==null&&right==null) continue;
			if(left==null||right==null) return false;
			if(left.val!=right.val) return false;
			
			  queue.offer(left.left);
			  queue.offer(right.right);
			  queue.offer(left.right);
			  queue.offer(right.left);

		}
		
		return true; 
	 }
	 
	
	

	public class TreeNode {
	        int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	 }

}
