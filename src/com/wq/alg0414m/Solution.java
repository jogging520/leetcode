package com.wq.alg0414m;

public class Solution {
	 public void solve(char[][] board) {
		    if(board==null||board.length==0) return ;
	        int row =board.length;
	        int col=board[0].length;
	        for(int i=0;i<row;i++){
	           for(int j=0;j<col;j++){
	        	   if(i==0&&board[i][j]=='O'){
	        		   //不做操作
	        		   continue;
	        	   }
	        	   else if(i==row-1&&board[i][j]=='O'){
	        		   //不做操作
	        		   continue;
	        	   }
	        	   else if(j==0&&board[i][j]=='O'){
	        		   //不做操作
	        		   continue;
	        	   }
	        	   else if(j==col-1&&board[i][j]=='O'){
	        		   //不做操作
	        		   continue;
	        	   }
	        	   else{
	        		   board[i][j]='X';
	        	   }
	           }
	        }
	 }
}
