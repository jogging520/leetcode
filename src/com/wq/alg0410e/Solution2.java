package com.wq.alg0410e;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		  List<List<Integer>> warpList=new ArrayList<List<Integer>>();
		  vistNode(root,warpList,0);
		 
	      return warpList;
	 }
	private void vistNode(TreeNode Node, List<List<Integer>> warpList, int level) {
		if(null==Node)  return ;
		if(level+1>warpList.size()){
			List<Integer> list=new ArrayList<Integer>();
			warpList.add(0,list);
		}
		warpList.get(warpList.size()-1-level).add(Node.val);
		if(Node.left!=null)  vistNode(Node.left,warpList,level+1);
		if(Node.right!=null) vistNode(Node.right,warpList,level+1);
		
	}
	public class TreeNode {
	          int val;
		      TreeNode left;
		      TreeNode right;
	 	      TreeNode(int x) { val = x; }
    }
}
