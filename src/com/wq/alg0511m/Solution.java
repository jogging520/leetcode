package com.wq.alg0511m;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
   @ClassName: Solution 
   @Description: 491
   Input: [4, 6, 7, 7]
   Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
   @param  
   @return 
 * @author Administrator
 * 2017年5月12日 上午8:51:06   
 */
public class Solution {
	 public List<List<Integer>> findSubsequences(int[] nums) {
	    Set<List<Integer>> resset=new HashSet<>();
	    if(nums==null||nums.length==1) return new ArrayList<>(resset);
	    //dfs 放入首元素
	    for(int i=0;i<nums.length;i++){
	    	List<Integer> subList=new ArrayList<>();
	    	subList.add(nums[i]);
	    	dfs(nums,i+1,resset,subList);
	    }
	    return new ArrayList<>(resset);
	 }

	private void dfs(int[] nums, int n, Set<List<Integer>> resset, List<Integer> subList) {
		 ArrayList<Integer> list=new ArrayList<>(subList);
         if(subList.size()>=2){
        	 resset.add(list);
         }
         for(int i=n;i<nums.length;i++){
        	 if(nums[i]>=subList.get(subList.size()-1)){
        		 subList.add(nums[i]);
        		 dfs(nums,i+1,resset,subList);
        		 subList.remove(subList.size()-1);
        	 }
         }
	}
}
