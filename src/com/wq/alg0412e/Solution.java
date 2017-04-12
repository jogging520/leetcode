package com.wq.alg0412e;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 *
 * 2017年4月12日 上午9:04:32   
 */
public class Solution {
	 public boolean isSymmetric(TreeNode root) {
	   if(null==root)  return false;
	   Queue<TreeNode> queue=new LinkedList<TreeNode>();
	   queue.offer(root);
	   while(!queue.isEmpty()){
		   int level=queue.size();
		   StringBuilder sb=new StringBuilder();
		   for(int i=0;i<level;i++){
			   TreeNode node = queue.peek();
			   sb.append(node.val+"");
			   if(node.left!=null) queue.offer(node.left);
			   if(node.right!=null) queue.offer(node.right);
               queue.poll();
		   }
		   //一层遍历完判断 sb是否是回文
		   if(!isMirror(sb.toString()))  return false;
	   }
	   return true;
	 }
	
	
	private boolean isMirror(String str) {
        int len=str.length();
        for(int i=0;i<=(len-1)/2;i++){
        	if(str.charAt(i)!=str.charAt(len-1-i))
        		   return false;
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
