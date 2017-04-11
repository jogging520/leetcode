package com.wq.alg0411m;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> resList=new ArrayList<List<Integer>>();

        //思路：矩阵中每一位进行上下左右查找，如果有0，标记为1，如果没有找出上下左右中最大的（1），然后＋1
       
        if (null==matrix||matrix.size()==0||matrix.get(0).size()==0) return resList;
        int row=matrix.size();
        int col=matrix.get(0).size();
        for(int i=0;i<row;i++){
    		List<Integer> list=new ArrayList<Integer>();
        	for(int j=0;j<col;j++){
        		doFind(matrix,list,i,j,row,col);
        	}
        	resList.add(list);
        }

        return resList;
    }

	private void doFind(List<List<Integer>> matrix, List<Integer> list, int i, int j, int row, int col) {
	   // System.out.println(i+","+j);
		if(matrix.get(i).get(j)==0) {
		    list.add(0);return ;
		}
		int up=Integer.MAX_VALUE,down=Integer.MAX_VALUE,left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
		if(matrix.get(i).get(j)!=0) {
		     //左右上下进行查找，只要有0，就是1，如果没有，就是上下左右的最小值＋1
			//1 up
			if(i>0){
				up=matrix.get(i-1).get(j);
				if(up==0) {list.add(1);return;} 
			}
			//2 down
			if(i<row-1){
				 down=matrix.get(i+1).get(j);
				if(down==0) {list.add(1);return;} 
			}
			//3 left
			if(j>0){
				 left=matrix.get(i).get(j-1);
				if(left==0) {list.add(1);return;} 
			}
			//3 right
			if(j<col-1){
				  right=matrix.get(i).get(j+1);
				if(right==0) {list.add(1);return;} 
			}
		}
		int min1=Math.min(up, down);
		int min2=Math.min(left, right);
		list.add(Math.min(min1,min2)+1);
	}
}
