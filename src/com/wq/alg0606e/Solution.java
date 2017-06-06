package com.wq.alg0606e;

import java.util.Arrays;

/**
   @ClassName: Solution 
   @Description: 581 Shortest Unsorted Continuous Subarray
   @param  
   @return 
 * @author Administrator
 * 2017年6月6日 上午9:29:36   
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int len=nums.length;
        int temp[]=new int[len];
        for(int i=0;i<len;i++){
        	temp[i]=nums[i];
        }
    	Arrays.sort(temp);
    	int start=0;
    	int end=len-1;
    	for(int i=0;i<len&&temp[i]==nums[i];i++){
    		start++;
    	}
    	for(int i=len-1;i>=1&&temp[i]==nums[i]&&end>start;i--){
    		end--;
    	}
    	return end-start+1;
    }
}
