package com.wq.alg0525h;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiwu
 * @57 Example 1:
		Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
		
		Example 2:
		Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 */
public class Solution {
	 public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	     List<Interval> resList=new ArrayList<>();   
		 if(intervals==null||intervals.size()==0){
			 resList.add(newInterval);
			 return resList;
		 }
		 int i=0;
		 while(i<intervals.size()&&intervals.get(i).end<newInterval.start){
			 resList.add(intervals.get(i));
			 i++;
		 }
		 while(i<intervals.size()&&intervals.get(i).start<=newInterval.end){
			 newInterval.start=Math.min(intervals.get(i).start, newInterval.start);
			 newInterval.end=Math.max(intervals.get(i).end, newInterval.end);
			 i++;
		 }
		 resList.add(newInterval);
         while(i<intervals.size()){
        	 resList.add(intervals.get(i++));
         }
		 
		 
		 return resList;
	 }
	public class Interval {
		     int start;
		     int end;
		     Interval() { start = 0; end = 0; }
		     Interval(int s, int e) { start = s; end = e; }
    }
}
