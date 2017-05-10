package com.wq.alg0509m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiwu
 * @310
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
  return [3, 4]
 *
 */
public class Solution {
     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves=new ArrayList<Integer>();
        if(n==0||edges.length==0) return leaves;
        Map<Integer,ArrayList<Integer>> treemap=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<edges.length;i++){
        	int [] edge=edges[i];
        	if(!treemap.containsKey(edge[0])){
        		treemap.put(edge[0], new ArrayList<Integer>());
        	}
        	if(!treemap.containsKey(edge[1])){
        		treemap.put(edge[1], new ArrayList<Integer>());
        	}
        	treemap.get(edge[0]).add(edge[1]);
        	treemap.get(edge[1]).add(edge[0]);
        }
        
        for(int i:treemap.keySet()){
        	if(treemap.get(i).size()==1) {
        		leaves.add(i);
        	}
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
            	for(int j:treemap.get(i)){
                   treemap.get(j).remove(i);
                   if (treemap.get(j).size() == 1) newLeaves.add(j);
            	}
            }
            leaves = newLeaves;
        }
        return leaves;
     }
}
