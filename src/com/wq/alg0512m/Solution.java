package com.wq.alg0512m;

/**
 * @author qiwu
 *Input: 2
	Output: 2
	Explanation: 
	
	The first beautiful arrangement is [1, 2]:
	
	Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
	
	Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
	
	The second beautiful arrangement is [2, 1]:
	
	Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
	
	Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 */
public class Solution {
	 public int count=0;
     public int countArrangement(int N) {
         if(N==0) return 0;
         helper(N,new int[N+1],1);
    	 return count;
     }
	private void helper(int n, int[] used, int pos) {
		 if(pos>n) {
			 count++;
			 return ;
		 }
		 for(int i=1;i<=n;i++){
             if(used[i]==0&&(pos%i==0||i%pos==0)){
            	 used[i]=1;
            	 helper(n,used,pos+1);
            	 used[i]=0;
             }
		 }
	}

}
