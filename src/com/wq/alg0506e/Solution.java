package com.wq.alg0506e;

/**
 * @author qiwu
 * @35
 * Here are few examples.
	[1,3,5,6], 5 → 2
	[1,3,5,6], 2 → 1
	[1,3,5,6], 7 → 4
	[1,3,5,6], 0 → 0
 */
public class Solution {
	 public int searchInsert(int[] nums, int target) {
	      int left=0,right=nums.length-1;
	      while(left<=right){
	          int mid=(left+right)/2;
	          if(nums[mid]==target) return mid;
	          else if(nums[mid]>target){
	              right=mid-1;
	          }else{
	              left=mid+1;
	          }
	      }
	      return left;
	    }    
}
