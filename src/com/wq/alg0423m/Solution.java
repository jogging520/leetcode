package com.wq.alg0423m;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qiwu
 * @494
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
	Output: 5
	Explanation: 
	
	-1+1+1+1+1 = 3
	+1-1+1+1+1 = 3
	+1+1-1+1+1 = 3
	+1+1+1-1+1 = 3
	+1+1+1+1-1 = 3

 */
public class Solution {
   public int findTargetSumWays(int[] nums, int S) {
	   if(nums==null||nums.length==0) return 0;
	   int res=0;
	   return helper(nums,0,0,res,0);

    }

	private int helper(int[] nums, int target, int pos, int res,int eval) {
	    if(pos==nums.length-1){
	    	if(eval==target){
	    		res++;
	    		return res;
	    	}
	    	helper(nums,target,pos+1,res,eval+nums[pos]);
	    	helper(nums,target,pos+1,res,eval-nums[pos]);
	    }
		return 0;
	}
}