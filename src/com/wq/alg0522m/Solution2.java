package com.wq.alg0522m;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	 public void sortColors(int[] nums) {
		 if(null==nums||nums.length==0) return ;
		 List<Integer> list0=new ArrayList<Integer>();
		 List<Integer> list1=new ArrayList<Integer>();
		 List<Integer> list2=new ArrayList<Integer>();
         for(int num:nums){
        	  switch(num){
        	    case 0: list0.add(num);
        	    break;
        	    case 1: list1.add(num);
        	    break;
        	    case 2: list2.add(num);
        	    break;
        	 }
         }
         System.out.println(list0);
         System.out.println(list1);
         System.out.println(list2);

         list0.addAll(list1);
         list0.addAll(list2);
        
         for(int i=0;i<nums.length;i++){
        	 nums[i]=list0.get(i);
         }
	 }
}
