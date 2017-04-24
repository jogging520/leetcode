package com.wq.alg0424e;

public class Solution {
	
	 public static int climbStairs(int n) {
		 if(n==1) return 1;
		 int []dp=new int [n+1];
		 dp[0]=1;
		 dp[1]=1;
		 printdp(dp);
		 for(int i=2;i<=n;i++){
			 dp[i]=dp[i-1]+dp[i-2];
		 }
	      
		 return dp[n];
	 }
	   public static void main(String[] args) {
		 int i=climbStairs(5);
		 System.out.println("res:"+i);
	   }
	   public static void printdp(int [] dp){
		   String str="";
		   for(int i:dp)  str+=i+",";
		   System.out.println(str);
	   }
}
