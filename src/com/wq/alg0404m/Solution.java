package com.wq.alg0404m;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author qiwu
 *
 */
public class Solution {
	public List merge(List<Interval> intervals) {
        
	    if(null==intervals||intervals.size()==0||intervals.size()==1) return intervals;
	    	//1 sort intervals
	    	intervals.sort((i1,i2)->Integer.compare(i1.start, i2.start));
	    	
	    	//2.nstart  ostart 
	    	List<Interval> list=new ArrayList<Interval>();
	    	int start=intervals.get(0).start;
	    	int end=intervals.get(0).end;
	    	for(int i=0;i<intervals.size(); i++){
	    		if(intervals.get(i).start<=end){
	    			end=Math.max(end,intervals.get(i).end);
	         	    //list.add(new Interval(start,end));
	    		}else{
	    		    list.add(new Interval(start,end));
	    		    start=intervals.get(i).start;
	    		    end=intervals.get(i).end;
	    		}
	    	}
	    	list.add(new Interval(start,end));
	        return list;
	    }
    public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }  
}
