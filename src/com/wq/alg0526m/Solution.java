package com.wq.alg0526m;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qiwu
 * @179 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 */
public class Solution {
	
	public String largestNumber(int[] nums) {
        if(nums==null||nums.length==0)  return "";
        int len=nums.length;
        String[] str=new String[len];
        for(int i=0;i<len;i++){
        	str[i]=Integer.toString(nums[i]);
        }
		Arrays.sort(str,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
                String s1=o1+o2;
                String s2=o2+o1;
				return s2.compareTo(s1);
			}	
		});
		
		StringBuilder sb=new StringBuilder();
		for(String s:str){
			sb.append(s);
		}
		return sb.toString();
    }
}
