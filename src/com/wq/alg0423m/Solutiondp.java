package com.wq.alg0423m;

public class Solutiondp {
	 public int findTargetSumWays(int[] nums, int S) {
		 if(null==nums||nums.length==0) return 0;
		 int sum=0;
		 for(int i:nums){
			 sum+=i;
		 }
		 int s=(S+sum)>>>1;

	     if(s>sum||(S+sum)%2!=0) return 0;
	     
		 return findSubset(nums,s); 
	 }

	private int findSubset(int[] nums, int s) {
		int [] dp=new int[s+1];
		dp[0]=1;
		for(int n:nums){
			for(int i=s;i>=n;i--){
				//dp[i]=dp[i-n]+n;
				//dp[i]=dp[i-n]+dp[i];
				dp[i]=dp[i-n]+dp[i];
			}
		}
		return dp[s];
	}
}
