package com.wq.alg0503h;


/**
   @ClassName: Solution 
   @Description: 312 
   @param  
   @return 
 * @author Administrator
 * 2017年5月3日 下午3:27:55   
 */
public class Solution {
	  public int maxCoins(int[] nums) {
	      if(null==nums||nums.length==0)  return 0;
	      int [] num=new int [nums.length+2];
	      num[0]=1;num[num.length-1]=1;
	      for(int i=0;i<nums.length;i++){
	    	  num[i+1]=nums[i];
	      }
		  int m=num.length;
		  int [][] dp=new int[m][m];
		  for(int gap=2;gap<m;gap++){
			  for(int left=0;left<m-gap;left++){
			     int right=left+gap;
			     for(int i=left+1;i<right;i++){
			    	 dp[left][right]=Math.max(dp[left][right], 
			    			                  num[left]*num[i]*num[right]+dp[left][i]+dp[i][right]);
			     }
			  }
			  
		  }
		  return dp[0][m-1];
	  }
}
