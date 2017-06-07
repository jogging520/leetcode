package com.wq.alg0607e;

/**
   @ClassName: Solution 
   @Description: 189 Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is 
rotated to [5,6,7,1,2,3,4].
   @param  
   @return 
 * @author Administrator
 * 2017年6月7日 上午8:53:44   
 */
public class Solution {
	 public void rotate(int[] nums, int k) {
	     if(nums==null||nums.length==0)  return ;
	     int len =nums.length;
	     int temp[]=new int[len];
	     k %= len;
	     for(int i=0;i<k;i++){
	    	 temp[i]=nums[len-1-k+1+i];
	     }
	     for(int i=k;i<len;i++){
	    	 temp[i]=nums[i-k];
	     }
	     nums=temp;
	 }
}  
