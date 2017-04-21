package com.wq.alg0421m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author Administrator
 * @332
 * 2017年4月21日 上午8:52:37   
 * Example 1:
	tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
	Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
	Example 2:
	tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
	Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 */
public class Solution {
	public List<String> findItinerary(String[][] tickets) {
   	 List<String> resList=new ArrayList<String>();
   	 if(tickets==null||tickets.length==0||tickets[0].length==0) return resList;
   	 Map<String,List<String>> map=new HashMap<String,List<String>>();
   	 for(int i=0;i<tickets.length;i++){//build a from to'sLIst map
			 List<String> list=new ArrayList<String>();
   		 if(!map.containsKey(tickets[i][0])){
   			   list.add(tickets[i][1]);
   	           map.put(tickets[i][0], list);		 
   		 }
   		 else{
   		    list=map.get(tickets[i][0]);
   		    list.add(tickets[i][1]);
   		    map.replace(tickets[i][0], list);
   		 }
   	 }
   	 
   	 //go around the map take the list 
//   	 String start="JFK";
//   	 System.out.println("map:"+map);
//
//   	 System.out.println(map.get(start).size()!=0);
   	 //需要思考 如果找不到，走回头路的话，怎么办
     Stack<String> stack=new Stack<String>();
     stack.add("JFK");
   	 while(!stack.isEmpty()){
   		 String start=stack.peek();
   		 if(map.containsKey(start)&&!map.get(start).isEmpty()){
	   		 String toPlace=sortlist(map,start);
	   		 stack.push(toPlace);
	   		 start=toPlace; 
   		 }
   		 else{
   			 resList.add(0,stack.pop());
   		 }
   	 }
   	 // resList.add(start);
   	  return resList;
   	 
   }

	private String sortlist(Map<String, List<String>> map, String start) {
		 List<String> list=new ArrayList<String>();

		 Collections.sort(map.get(start),new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		 });
		list=map.get(start);
       String res=list.remove(0);
       map.replace(start,list);
	   return res;
	}
	
	public static void main(String[] args) {
		
	}
	
}
