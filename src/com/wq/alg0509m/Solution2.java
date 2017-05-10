package com.wq.alg0509m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Solution2 {
	 public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	       if(n==1) return Collections.singletonList(0);
	       List<Set<Integer>> adj=new ArrayList<Set<Integer>>();
	       for(int [] edge:edges){
	    	   adj.get(edge[0]).add(edge[1]);
	    	   adj.get(edge[1]).add(edge[0]);
	       }
	       List<Integer> leaves=new ArrayList<Integer>();
	       for(int i=0;i<adj.size();i++){
	    	   if(adj.get(i).size()==1) {
	    		   leaves.add(i);
	    	   }
	       }
	       while(n>2){
	    	   n=n-leaves.size();
	    	   List<Integer> newLeaves=new ArrayList<Integer>();
	    	   for(int i:leaves){
	    		   //int j=adj.get(i).iterator().next();
	    		   for(int j:adj.get(i)){
		    		   adj.get(j).remove(i);
		    		   if(adj.get(j).size()==1) {
		    			   newLeaves.add(j);
		    		   }
	    		   }
	    	   }
	    	   leaves=newLeaves;
	       }
	       return leaves;
     }
}
