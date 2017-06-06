package com.wq.alg0605e;

import java.util.HashMap;
import java.util.Map;

/**
   @ClassName: Solution 
   @Description:  K-diff Pairs in an Array
   Input: [3, 1, 4, 1, 5], k = 2
	Output: 2
	Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
	Although we have two 1s in the input, we should only return the number of unique pairs.
   @param  
   @return 
 * @author Administrator
 * 2017年6月5日 上午9:03:26   
 */
public class Solution {
	 public int findPairs(int[] nums, int k) {
	     if(nums==null||nums.length==0||k<0) return 0;
	     int count=0;
	     Map<Integer,Integer> map=new HashMap();
	     for(int num:nums){
	    	 map.put(num, map.getOrDefault(num, 0)+1);
	     }
	     for(Map.Entry<Integer, Integer> entry:map.entrySet()){
	    	 if(k==0){
	    		 if(entry.getValue()>1){
	    			 count++;
	    		 }
	    	 }else{
	    		 if(map.containsKey(entry.getKey()+k)){
	    			 count++;
	    		 }
	    	 }
	     }
		 return count;
	     
	 }
}
