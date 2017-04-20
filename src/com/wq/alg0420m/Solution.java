package com.wq.alg0420m;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	 
	 public int findCircleNum(int[][] M) {
	     if(M==null||M.length==0)  return 0; 
		 int people=M.length;
		 List<Set> list=new ArrayList<Set>();
		 for(int i=0;i<people;i++){
			 Set<Integer> set=new HashSet<Integer>();
			 for(int j=i;j<people;j++){
				 if(M[i][j]==1){
					set.add(i);
					set.add(j);
				 }
			 }
			 list.add(set);
		 }
		 Set<Integer> tempset=list.get(0);
		 for(int i=1;i<list.size();i++){
			 if(tempset.contains(list.get(i))){//maybe function to make it
				 list.get(i).addAll(tempset);
				 tempset=list.get(i);
				 list.remove(i-1);
			 }
			 if(list.get(i).size()==people) return 1;
		 }
		 return list.size();
	 }

}
