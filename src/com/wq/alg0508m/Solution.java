package com.wq.alg0508m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author qiwu
 * @399
 *  Given a / b = 2.0, b / c = 3.0. 
	queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
	return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 */
public class Solution {
	 public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
	     Map<String,ArrayList<String>> pairs=new HashMap<String,ArrayList<String>>();
	     Map<String,ArrayList<Double>>valPairs=new HashMap<String,ArrayList<Double>>();
	     for(int i=0;i<equations.length;i++){
	    	 String[] equ=equations[i];
		     if(!pairs.containsKey(equ[0])){
		    	 pairs.put(equ[0], new ArrayList<String>());
		    	 valPairs.put(equ[0], new ArrayList<Double>());
		     }
             if(!pairs.containsKey(equ[1])){
		    	 pairs.put(equ[1], new ArrayList<String>());
		    	 valPairs.put(equ[1], new ArrayList<Double>());
		     }
             pairs.get(equ[0]).add(equ[1]);
             valPairs.get(equ[0]).add(values[i]);
             pairs.get(equ[1]).add(equ[0]);
             valPairs.get(equ[1]).add(1/values[i]);
	     }
	     double[] res=new double[queries.length];
	     for(int i=0;i<queries.length;i++){
	    	 String[] que=queries[i];
	    	 res[i]=dfs(que[0],que[1],pairs,valPairs,new HashSet(),1.0);
	    	 if(res[i]==0.0) res[i]=-1.0;
	     }
	     return res;
	 }

	private double dfs(String start, String end, Map<String, ArrayList<String>> pairs,
		Map<String, ArrayList<Double>> valPairs, HashSet set, double value) {
		if(set.contains(start)) return 0.0;
		if(!pairs.containsKey(start)) return 0.0;
		if(start.equals(end)) return value;
		set.add(start);
		ArrayList<String> midList=pairs.get(start);
		ArrayList<Double> valList=valPairs.get(start);
		double res=0.0;
		for(int i=0;i<midList.size();i++){
			res=dfs(midList.get(i),end,pairs,valPairs,set,value*valList.get(i));//key!
			if(res!=0.0) {
				break;//find it!
			}
		}
		set.remove(start);
		return res;
	}
}
