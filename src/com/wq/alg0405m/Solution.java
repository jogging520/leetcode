package com.wq.alg0405m;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Administrator
 *given [3, 30, 34, 5, 9], the largest formed number is 9534330.

  Note: The result may be very large, so you need to return a
  string instead of an integer.
 * 2017年4月5日 上午8:59:12   
 */
public class Solution {
	
	    public String largestNumber(int[] nums) {
	        if(null==nums||nums.length==0)  return "";
	        String[] res=new String[nums.length];
	    	for(int i=0;i<nums.length;i++){
	    		res[i]=nums[i]+"";
	    	}
	    	Arrays.sort(res,new Comparator<String>(){

				@Override
				public int compare(String o1, String o2) {
					String s1=o1+o2;
					String s2=o2+o1;
					return s2.compareTo(s1);
				}
	    		
	    	});
	    	if(res[0].charAt(0)=='0')  return "0";

	    	StringBuilder sb=new StringBuilder();
	    	for(int i=0;i<res.length;i++){
	    		sb.append(res[i]);
	    	}
	    	return sb.toString();
	    	
	    }
	
}

	    