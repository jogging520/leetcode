package com.wq.alg0414m;

/**
 * @author qiwu
 * @130
 *
 */
public class Solution {
	 public void solve(char[][] board) {
		    if(board==null||board.length==0||board[0].length==0) return ;
	        int row =board.length;
	        int col=board[0].length;
	        for(int j=0;j<col;j++){
	        	if(board[0][j]=='O'){
	        		expand(board,0,j);
	        	}
	        	if(board[row-1][j]=='O'){
	        		expand(board,row-1,j);
	        	}
	        }
	        for(int i=1;i<row-1;i++){
	        	if(board[i][0]=='O'){
	        		expand(board,i,0);
	        	}
	        	if(board[i][col-1]=='O'){
	        		expand(board,i,col-1);
	        	}
	        }
	       
	        for(int i=0;i<row;i++){
	        	for(int j=0;j<col;j++){
	        		if(board[i][j]=='T') {
	        		    board[i][j]='O';
	        		}
	        		else if(board[i][j]=='O'){
	        		   board[i][j]='X'; 
	        		} 
	        	}
	        }
	        
	 }

	private void expand(char[][] board, int i, int j) {
		  int row =board.length;
	      int col=board[0].length;
	      //System.out.println("ij:"+i+","+j);
       if(i<0||i>row-1||j<0||j>col-1||board[i][j]!='O') return;
       board[i][j]='T';
       	      //System.out.println("ij:[][]"+ board[i][j]);

       if(i>1){//up
     	  expand(board,i-1,j);
       }
       if(i<row-2){//down
     	  expand(board,i+1,j);
       }
       if(j>1){//left
     	  expand(board,i,j-1);
       }
       if(j<col-2){//right
     	  expand(board,i,j+1);
       }

	}
}
	
