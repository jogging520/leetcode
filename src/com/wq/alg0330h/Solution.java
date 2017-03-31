package com.wq.alg0330h;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Administrator
	 *Input:
	[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	
	Output:
	[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 2017年3月30日 上午9:20:45   
 */
public class Solution {
	
	 public int[][] reconstructQueue(int[][] people) {
		if(people==null||people.length==0)  return people;
	    //1.sort peopel by height(max->min)  and  k(min->max)
		Arrays.sort(people,new Comparator<int[]>(){
			@Override
			public int compare(int[] a1, int[] a2) {
				// TODO Auto-generated method stub
				return a1[0]==a2[0]?a1[1]-a2[1]:a2[0]-a1[0];
			}
			});
		//2 .insert order
		List<int[]> list =new ArrayList<int[]>();
		for(int i=0;i<people.length;i++){
			if(people[i][1]==list.size()){
				list.add(people[i]);
			}else{
				list.add(people[i][1],people[i]);
			}
		}
		//return array
		int [][] res= new int[list.size()][2];
		for(int i=0;i<list.size();i++){
			res[i]=list.get(i);
		}
		return res;
		}
	 				
}
