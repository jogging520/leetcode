package com.wq.alg0415m;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.wq.alg0415m.Solution.TreeNode;

public class Solution2 {
	public List<Integer> largestValues(TreeNode root) {
	   	  List<Integer> resList=new ArrayList<Integer>();
	   	  largeVist(root,resList,0);
	   	 
	      return resList;
    }
    private void largeVist(TreeNode node, List<Integer> resList, int level) {
          	if(node==null) return;
            int res=Integer.MIN_VALUE;   
          	if(resList.size()<=level){
          		resList.add(Integer.MIN_VALUE);
          	}
          	if(node.val>resList.get(level)){
          		resList.set(level, node.val);
          	}
          	largeVist(node.left,resList,level+1);
          	largeVist(node.right,resList,level+1);

	}
	public class TreeNode {
        int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
    }
}
