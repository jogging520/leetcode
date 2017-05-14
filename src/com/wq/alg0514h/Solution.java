package com.wq.alg0514h;

/**
 * @author qiwu
 * #329Example 1:
	nums = [
	  [9,9,4],
	  [6,6,8],
	  [2,1,1]
	]
Return 4
The longest increasing path is [1, 2, 6, 9]
 */
public class Solution {
     public final int [][] dirs={{1,0},{-1,0},{0,1},{0,-1}};   

	 public int longestIncreasingPath(int[][] matrix) {
		 if(null==matrix||matrix.length==0) return 0;
		 int m=matrix.length;
		 int n=matrix[0].length;
		 int [][] cache=new int[m][n];
		 int max=1;
		 for(int i=0;i<m;i++){
			 for(int j=0;j<n;j++){
				 int len=dfs(matrix,i,j,m,n,cache);
				 max=Integer.max(max, len);
			 }
		 }
		 		 
		 return max;
	 }

	private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
		if(cache[i][j]!=0)  return cache[i][j];
		int max=1;
		for(int[] d:dirs){
			int x=i+d[0];
			int y=j+d[1];
			if(x<0||x>=m||y<0||y>=n||matrix[i][j]>=matrix[x][y]) continue;
			int len=1+dfs(matrix,x,y,m,n,cache);
			max=Integer.max(max, len);
		}
		cache[i][j]=max;
		return max;
	}
}
