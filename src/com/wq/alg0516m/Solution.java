package com.wq.alg0516m;

/**
   @ClassName: Solution 
   @Description: 421 
   Input: [3, 10, 5, 25, 2, 8]
   Output: 28
   Explanation: The maximum result is 5 ^ 25 = 28. 字典树和位运算
   @param  
   @return 
 * @author Administrator
 * 2017年5月16日 上午9:24:55   
 */
class Trie{
	 Trie next[];
	 public Trie(){
		 next =new Trie[2];
	 }
}
public class Solution {
	 
	 public int findMaximumXOR(int[] nums) {
	     if(null==nums||nums.length==0) return 0;  
	     Trie root=new Trie();
	     //bulid dic tree
	     for(int num:nums){
	    	 Trie curNode=root;
	    	 for(int i=31;i>=0;i--){
	    		 int curBit=(num>>>i)&1;
	    		 if(curNode.next[curBit]==null){
	    			 curNode.next[curBit]=new Trie();
	    		 }
	    		 curNode=curNode.next[curBit];
	    	 }
	     }
	     //
	     int max=Integer.MIN_VALUE;
	     for(int num:nums){
	    	 Trie CurNode=root;
	    	 int sum=0;
	    	 for(int i=31;i>=0;i--){
	    		 int curBit=(num>>>i)&1;
	    		 if(CurNode.next[curBit^1]!=null){
	    			 sum+=(1<<i);//sum   understand
	    			 CurNode=CurNode.next[curBit^1];
	    		 }else{
	    			 CurNode=CurNode.next[curBit];
	    		 }
	    	 }
	    	 max=Math.max(max, sum);
	     }	     
	     
		 return max;
	 }
	 
}
