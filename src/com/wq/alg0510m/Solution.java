package com.wq.alg0510m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
	/**
	 * Definition for undirected graph.
	 */
	class UndirectedGraphNode {
		      int label;
		      List<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	     if(null==node) return null;
	     //init map and queue
	     Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap();
		 Queue<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();
		 queue.offer(node);
		 //init root node
		 UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
		 UndirectedGraphNode res=newNode;
		 map.put(node, res);//map's effect ?
		 while(!queue.isEmpty()){
			 int size=queue.size();
			 for(int i=0;i<size;i++){
				 node=queue.poll();
				 List<UndirectedGraphNode> adjlist=new ArrayList<UndirectedGraphNode>();
				 for(int j=0;j<node.neighbors.size();j++){
					 if(!map.containsKey(node.neighbors.get(j))){
						 newNode=new UndirectedGraphNode(node.neighbors.get(j).label);
						 map.put(node.neighbors.get(j), newNode);
						 queue.offer(node.neighbors.get(j));
					 }
					 newNode=map.get(node.neighbors.get(j));
					 adjlist.add(newNode);
				 }
				 //set edge
				 map.get(node).neighbors=adjlist;
			 }
		 }
		 return res;
	 }

}
