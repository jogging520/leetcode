package com.wq.alg0608m;

import java.util.ArrayList;
import java.util.List;

/**
   @ClassName: Solution 
   @Description: 120
   @param  
   @return 
 * @author Administrator
 * 2017年6月8日 上午8:21:12   
 */
public class Solution {
	 public int minimumTotal(List<List<Integer>> triangle) {
	     if(triangle==null||triangle.size()==0) return 0;
		 int row=triangle.size();
		 int sumMin=0;
		 int rowMin=0;
		 for(int i=0;i<row;i++){
			 List<Integer> subList=new ArrayList<Integer>();
			 subList=triangle.get(i);
			 rowMin=getMin(subList);
			 sumMin+=rowMin;
		 }
		 
		 return  0;
	 }

	private int getMin(List<Integer> subList) {
        int min=Integer.MAX_VALUE;
        for(int num:subList){
        	min=Integer.min(min, num);
        }
		return min;
	}
}
