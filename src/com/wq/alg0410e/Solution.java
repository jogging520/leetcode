package com.wq.alg0410e;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Administrator
 *
 * 2017年4月10日 上午9:03:24   
 */
public class Solution {
	
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		  Queue<TreeNode> queue=new LinkedList<TreeNode>();
		  List<List<Integer>> warpList=new ArrayList<List<Integer>>();
		  if(null==root)   return warpList;
          queue.offer(root);
		  while(!queue.isEmpty()){
			  int levelNum = queue.size();
	          List<Integer> subList = new LinkedList<Integer>();
			  for(int i=0;i<levelNum;i++){
				  
				  if(queue.peek().left!=null)  queue.offer(queue.peek().left);
				  if(queue.peek().right!=null)  queue.offer(queue.peek().right);
				  subList.add(queue.poll().val);
			  }
			  warpList.add(0,subList);
		  } 
	      return warpList;
	 }
	public class TreeNode {
	          int val;
		      TreeNode left;
		      TreeNode right;
	 	      TreeNode(int x) { val = x; }
     }
}
