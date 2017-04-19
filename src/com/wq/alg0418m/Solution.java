package com.wq.alg0418m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *@106  
 *Given inorder and postorder traversal of a tree, construct the binary tree.
 *先做右子树？？？ 
 * 2017年4月18日 下午4:27:11   
 */
public class Solution {
	
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
	     if(inorder==null||postorder==null||inorder.length==0||postorder.length==0){
	    	 return null;
	     }
	     List<Integer> postList=toList(postorder);
	     Map<Integer,Integer>inMap=toMap(inorder);
	     int rootVal=postList.remove(postorder.length-1);
	     int rootIndex=inMap.get(rootVal);

	     TreeNode root=new TreeNode(rootVal);
	     	     root.right=builderHelper(rootIndex+1,inorder.length-1,postList,inMap);

	     root.left=builderHelper(0,rootIndex-1,postList,inMap);
	     return root; 
	 }
	
	
	 private TreeNode builderHelper(int left, int right, List<Integer> postList, Map<Integer, Integer> inMap) {
         if(left>right)  return null;
        // if(postList==null||postList.size()==0) return null ;
        // System.out.println("post:"+postList);
         int rootVal=postList.remove(postList.size()-1);
         int rootIndex=inMap.get(rootVal);
         TreeNode node=new TreeNode(rootVal);
                  node.right=builderHelper(rootIndex+1,right,postList,inMap);

         node.left=builderHelper(left,rootIndex-1,postList,inMap);
         return node;
	}


	private List<Integer> toList(int[] postorder) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<postorder.length;i++){
			list.add(postorder[i]);
		}
		return list;
	}


	private Map<Integer, Integer> toMap(int[] inorder) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<inorder.length;i++){
			map.put(inorder[i], i);
		}
		return map;
	}


	public class TreeNode {
        int      val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
     }

}
