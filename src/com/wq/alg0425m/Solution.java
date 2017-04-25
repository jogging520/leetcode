package com.wq.alg0425m;

/**
   @ClassName: Solution 
   @Description: @523 
   Input: [23, 2, 4, 6, 7],  k=6
	Output: True
	Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
   @param  
   @return 
 * @author Administrator
 * 2017年4月25日 下午3:21:29   
 */
public class Solution {
	 public boolean checkSubarraySum(int[] nums, int k) {
	     if(null==nums||nums.length==0)  return false;
	     //int []sums=new int[nums.length];
	     for(int i=0;i<nums.length;i++){
	    	 int sums=nums[i];
	    	 for(int j=i+1;j<nums.length;j++){
	    		 sums+=nums[j];
	    		 if(k!=0&&sums%k==0){
	    			 return true;
	    		 }
	    		 if(k==0&&sums==0){
	    			 return true;
	    		 }
	    	 }
	     }
		 
		 return false;
	 }
}
