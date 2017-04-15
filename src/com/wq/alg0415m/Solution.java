package com.wq.alg0415m;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qiwu
 * @515
 * Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

   Output: [1, 3, 9]
 */
public class Solution {
     public List<Integer> largestValues(TreeNode root) {
    	 List<Integer> resList=new ArrayList<Integer>();
    	 if(root==null)  return resList;
    	 Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	 queue.add(root);
    	 while(!queue.isEmpty()){
    		 int levelsize=queue.size();
    		 int max=Integer.MIN_VALUE;
    		 for(int i=0;i<levelsize;i++){
    			 TreeNode node=queue.poll();
    			 max=Integer.max(node.val, max);
    			 if(node.left!=null) queue.add(node.left);
    			 if(node.right!=null) queue.add(node.right);
    		 }
    		 resList.add(max);
    	 }
         return resList;
     }
     public class TreeNode {
         int val;
 	      TreeNode left;
 	      TreeNode right;
 	      TreeNode(int x) { val = x; }
     }
}
