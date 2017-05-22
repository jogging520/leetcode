package com.wq.alg0522m;

/**
 * @author qiwu
 *
 */
public class Solution {
	 public void sortColors(int[] nums) {
	     if(null==null||nums.length==0) return ;
	     int left=0,cur=0,right=nums.length-1;
	     while(cur<=right){
	    	 if(nums[cur]==0){
	    		swap(nums,left,cur);
	    		left++;cur++;
	    	 }else if(nums[cur]==1){
	    		 swap(nums,cur,right);
	    		 right--;
	    	 }else{
	    		 cur++;
	    	 }
	     }
	 }

	private void swap(int[] nums, int i, int j) {
         int temp=nums[i];
         nums[i]=nums[j];
         nums[j]=temp;
	}
}
