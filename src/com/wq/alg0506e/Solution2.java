package com.wq.alg0506e;

public class Solution2 {

	 public int searchInsert(int[] nums, int target) {
		 if(null==nums||nums.length==0) return 0;
		 return bSearch(nums,0,nums.length-1,target);
	 }

	private int bSearch(int[] nums, int start, int end, int target) {
        if(start>end){//didn't find the num then insert into start
        	return start;
        }
        int mid=(start+end)/2;
        if(nums[mid]==target)  return mid;
        else if(nums[mid]<target){
        	return bSearch(nums,mid+1,end,target);
        }else{
        	return bSearch(nums,0,mid-1,target);
        }
	}

}
