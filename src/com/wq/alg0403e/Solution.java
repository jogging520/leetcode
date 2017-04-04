package com.wq.alg0403e;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	   public int[] intersection(int[] nums1, int[] nums2) {
			 if(null==nums1||nums1.length==0)  return nums1;
			 if(null==nums2||nums2.length==0)  return nums2;
			 Set<Integer> set1=new HashSet<Integer>();
			 Set<Integer> set2=new HashSet<Integer>();
			 List<Integer> list=new ArrayList<Integer>();
	         for(int i=0;i<nums1.length;i++){
	        	 set1.add(nums1[i]);
	         }
	         for(int i=0;i<nums2.length;i++){
	        	 set2.add(nums2[i]);
	         }
	         for(int i:set1){
	        	 if(set2.contains(i)){
	        		 list.add(i);
	        	 }
	         }
	         int len=list.size();
	         int [] res=new int[len];
	         for(int i=0;i<list.size();i++){
	        	 res[i]=list.get(i);
	         }
		     return res;
		  }
	}
