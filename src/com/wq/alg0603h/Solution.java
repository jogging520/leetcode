package com.wq.alg0603h;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiwu
 * @560Input:nums = [1,1,1], k = 2
   Output: 2
 */
public class Solution {
	 public int subarraySum(int[] nums, int k) {
	     int sum=0,res=0;
	     Map<Integer,Integer> preSum=new HashMap();
	     preSum.put(0,1);

	     for(int i=0;i<nums.length;i++){
	    	 sum+=nums[i];
	    	 if(preSum.containsKey(sum-k)){
	    		 res+=preSum.get(sum-k);
	    	 }
	    	 preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
	     }
		 return res;
	 }
}
