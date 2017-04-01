package com.wq.alg0401m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Administrator
	 *Input: [ [1,2], [2,3], [3,4], [1,3] ]
	
	  Output: 1
	
	Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * 2017年4月1日 上午9:30:14   
 */

public class Solution {
	
	 public int eraseOverlapIntervals(Interval[] intervals) {
		 
		 if(null==intervals||intervals.length==0) return 0;
	    	//1.sort intervals  from min_->max   
	    	Arrays.sort(intervals,new Comparator<Interval>(){
				@Override
				public int compare(Interval o1, Interval o2) {
					
				   return o1.start>o2.start?o2.end-o1.end:o2.start-o1.start;
				}
			
	    	});
	   // 	for(Interval i:intervals)
	   // 	         System.out.println(""+i.start+":"+i.end+"-------");
	    	//add list if meet cross num++;
	    	List<Interval> list=new ArrayList<Interval>();
	    	int inter=0;
	    	list.add(intervals[0]);
	    	for(int i=1;i<intervals.length;i++){
	    		if(intervals[i].start==intervals[i-1].start){
	    			inter++;
	    			continue;
	    		}
	    		if(intervals[i].start>intervals[i-1].start&&intervals[i-1].start<intervals[i-1].end){
	    			inter++;
	    			continue;
	    		}
	    		list.add(intervals[i]);
	    	}
	    	return inter;
	    }
	    
   // Definition for an interval.
    public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }
}