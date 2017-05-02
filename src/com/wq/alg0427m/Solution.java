package com.wq.alg0427m;

/**
   @ClassName: Solution 
   @Description: 96 
   
   @param  
   @return 
 * @author Administrator
 * 2017年4月28日 上午9:18:56   
 */
public class Solution {
	
	public int numTrees(int n) {
	    int [] G = new int[n+1];
	    G[0] = G[1] = 1;
	    
	    for(int i=2; i<=n; ++i) {
	    	for(int j=1; j<=i; ++j) {
	    		G[i] += G[j-1] * G[i-j];
	    	}
	    }

	    return G[n];
	}

}
