package com.wq.alg0528m;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author qiwu
 *
 */
public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
         Map<Integer,List<Integer>> adjLists=new HashMap();
         for(int i=0;i<ppid.size();i++){
        	 adjLists.putIfAbsent(ppid.get(i),new LinkedList<>());
        	 adjLists.get(ppid.get(i)).add(pid.get(i));
         }
         List<Integer>res=new LinkedList<>();
         Stack<Integer>stack =new Stack<>();
         stack.add(kill);
         while(!stack.isEmpty()){
        	 int cur=stack.pop();
        	 res.add(cur);
        	 List<Integer> adjList=adjLists.get(cur);
        	 if(adjList==null) continue;
        	 stack.addAll(adjList);
         }
    	 return res;
    }
}
