package com.wq.alg0428m;

/**
   @ClassName: Solution 
   @Description: 516 
   @param  
   @return 
 * @author Administrator
 * 2017年4月27日 上午10:56:20   
 */
public class Solution {
	
	public int longestPalindromeSubseq(String s) {
		 if(null==s||s.length()==0) return 0;
		 int len=s.length();
		 if(len==1) return 1; 
		 int[][]dp=new int[len][len];
		 for(int i=0;i<len;i++){
		     dp[i][i]=1;
		 }
		 for(int i=len;i>=0;i--){
			 for(int j=i+1;j<len;j++){
				 if(s.charAt(i)==s.charAt(j)){
					 dp[i][j]=dp[i+1][j-1]+2;
				 }else{
					 dp[i][j]=Integer.max(dp[i][j-1],dp[i+1][j]);
				 }
			 }
		 }
		 
		 return dp[0][len-1];
	 }

}
