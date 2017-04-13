package com.wq.alg0413m;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


 /**
 * @author Administrator 
 * @513
 * 2017年4月13日 上午8:43:19  
 * Input:

        1
       / \
      2   3
     /   / \
    4   5   6 
       /
     7
	Output:
	7 
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        //思路 遍历每一层，如果有左节点 加入结果集  同一层的结果集 只要第一个
    	if(root.left==null) return root.val;
    	Queue<TreeNode> queue =new LinkedList<TreeNode>();
    	int res=0;
    	queue.offer(root);
    	while(!queue.isEmpty()){
    		 int N=queue.size();
    		 res=queue.peek().val;
    		 for(int i=0;i<N;i++){
    			 TreeNode node=queue.poll();
	    	     if(node.left!=null) queue.offer(node.left);
	    	     if(node.right!=null)queue.offer(node.right);
	    	 }
    	}
    	return res;
    }
    
    public class TreeNode {
        int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
    }
}