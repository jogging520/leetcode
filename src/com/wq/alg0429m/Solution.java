package com.wq.alg0429m;

public class Solution {

    public boolean canPartition(int[] nums) {
        if(null==nums||nums.length==0)  return true;
        int sum=0;
        for(int i:nums){
        	sum+=i;
        }
        if(sum%2!=0) return false;
        sum/=2;
        boolean [][]dp=new boolean[nums.length+1][sum+1];
        for(int i=0;i<=nums.length;i++){
        	dp[i][0]=true;
        }
        for(int i=1;i<=nums.length;i++){
        	for(int j=sum;j>=nums[i-1];j--){
        		dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
        	}
        }
    	return dp[nums.length][sum];
    }
}
