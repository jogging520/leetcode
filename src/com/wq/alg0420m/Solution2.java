package com.wq.alg0420m;

public class Solution2 {
	public int findCircleNum(int[][] M) {
	     if(M==null||M.length==0)  return 0; 
	     int people=M.length;
	     int[]visit=new int[people];
	     int res=0;
	     for(int i=0;i<people;i++){
	    	 if(visit[i]==0){
	    		 dfsHelper(i,M,visit);
	    		 res++;
	    	 }
	     }
         return res;
	}

	private void dfsHelper(int i, int[][] m, int[] visit) {
		if(visit[i]==1) return;
		visit[i]=1;
		for(int j=0;j<m.length;j++){
			if(i!=j&&m[i][j]==1){
				 dfsHelper(j,m,visit);
			}
		}
	}
}
