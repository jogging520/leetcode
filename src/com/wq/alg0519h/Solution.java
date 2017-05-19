package com.wq.alg0519h;
 
/**
   @ClassName: Solution 
   @Description: 493 
   iven an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

   You need to return the number of important reverse pairs in the given array.
   @param  
   @return 
 * @author Administrator
 * 2017年5月19日 上午9:09:30   
 */
class Node{
	int val;
	int cnt;
	Node left,right;
	Node(int val){
		this.val=val;
		this.cnt=1;
	}
}
public class Solution {
	 private int search(Node root, long val){
		 if(null==root) {
			 return 0;
		 }else if(root.val==val){
			 return root.cnt;
		 }else if(root.val>val){
			 return root.cnt+search(root.left,val);
		 }else{
			 return search(root.right,val);
		 }
		 
	 }
	 private Node insert(Node root, int val) {
		 if (root == null) {
			 root=new Node(val);
		 }else if(root.val==val){
			 root.cnt++;
		 }else if(root.val<val){
			 root.cnt++;
			 root.right=insert(root.right,val);
		 }else{
			 root.left=insert(root.left,val);
		 }
		 return root;
	 }
	 
	 public int reversePairs(int[] nums) {
	     int res=0;
	     Node root=null;
	     for(int num:nums){
	    	 res += search(root,2L*num+1);
	    	 root=insert(root,num);
	     }
		 return res;
	 }
}
