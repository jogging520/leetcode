package com.wq.alg0425m;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
	 public boolean checkSubarraySum(int[] nums, int k) {
		 if(null==nums||nums.length<2)  return false;
         Map<Integer,Integer>map =new HashMap<Integer,Integer>();
         int sum=0;
         for(int i=0;i<nums.length;i++){
        	 sum+=nums[i];
        	 if(k!=0){
        		 sum=sum%k;
        	 }else{
        		 return true;
        	 }
        	 if(!map.containsKey(sum)){
        		 map.put(sum, i);
        	 }else if(i-map.get(sum)>0){
        		 return true;
        	 }
         }
		 return false;
	 }
}
