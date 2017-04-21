package com.wq.alg0421m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author Administrator
 * @332
 * 2017��4��21�� ����8:52:37   
 * Example 1:
	tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
	Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
	Example 2:
	tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
	Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
	�����ǣ�1.map���� 2.dfs ����
 */

 public class Solution2 {
	public List<String> findItinerary(String[][] tickets) {
   	 List<String> resList=new ArrayList<String>();
   	 if(tickets==null||tickets.length==0||tickets[0].length==0) return resList;
   	 Map<String,PriorityQueue<String>> map=new HashMap<String,PriorityQueue<String>>();
   	 for(int i=0;i<tickets.length;i++){//build a from to'sLIst map
   		 if(!map.containsKey(tickets[i][0])){
   	           map.put(tickets[i][0], new PriorityQueue<String>());		 
   		 }
   		
   		    map.get(tickets[i][0]).add(tickets[i][1]);
   		 
   	 }
   	 
   	//DFS  通过stack 保存访问过的节点
   	 Stack<String> stack=new Stack<String>();
   	 stack.push("JFK");
   	 while(!stack.isEmpty()){
   		 String key=stack.peek();
   		 if(map.containsKey(key)&&!map.get(key).isEmpty()){
   			 stack.push(map.get(key).poll());
   		 }else{
   			 resList.add(0, stack.pop());
   		 }
   	 }
   	 return resList;
   	 
   }

	
}
