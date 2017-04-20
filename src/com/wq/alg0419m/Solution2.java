package com.wq.alg0419m;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	public void flatten(TreeNode root) {
		 if(root==null) return ;
		 List<Integer> preList=new ArrayList<Integer>();
		 preList.add(root.val);
		 preorder(root,preList);
		 TreeNode temp=root;
		 for(int i=1;i<preList.size();i++){
			 TreeNode node=new TreeNode(preList.get(i));
			 temp.right=node;
			 temp.left=null;
			 temp=temp.right;
		 }
	
	 }
	



	private void preorder(TreeNode root, List<Integer> preList) {
         if(root==null) return ;
         preList.add(root.val);
         preorder(root.left,preList);
         preorder(root.right,preList);
	}




	public class TreeNode {
       int      val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
    }

}
