package com.wq.alg0601m;

import java.util.Stack;

/**
   @ClassName: BSTIterator 
   @Description: 173 
   @param  
   @return 
 * @author Administrator
 * 2017年6月1日 上午8:41:15   
 */
public class BSTIterator {
	    Stack<TreeNode>stack;
	    public BSTIterator(TreeNode root) {
	        stack=new Stack();
	        pushAll(root);
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	       TreeNode tempnode=stack.pop();
	       pushAll(tempnode.right);
	       return tempnode.val;
	    }
	    private void pushAll(TreeNode node) {
	    	while(node!=null){
	    		stack.push(node);
	    		node=node.left;
	    	}
	    }
	    
	    public class TreeNode {
	    	     int val;
	    	     TreeNode left;
	    	     TreeNode right;
	    	     TreeNode(int x) { val = x; }
	    }
}
