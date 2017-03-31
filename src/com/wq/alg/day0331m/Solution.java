package com.wq.alg.day0331m;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 *
 * 2017年3月31日 上午8:51:52   
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(null==gas||gas.length==0)  return -1;
        int len=gas.length;
        if(len==1) {
        	if(cost[0]<=gas[0])  return 0;
        	else return -1;
        }
        List<Integer> list=new ArrayList<Integer>();
    	//1. 找出所有g[i]>cost[i]的点，加入起点列表
    	for(int i=0;i<len;i++){
    		if(gas[i]>cost[i]) {
    			list.add(i);
    		}
    	}  	
    	int gasleft=0;
        //2. 循环起点列表，计算每次走动是否剩余gasleft>0  如果小于0，继续换起点，直到结束
    	for(int i:list){
             int index=i;
             int  route=0;
             while(route<=len){
	             gasleft+=gas[index]-cost[index];
	             if(gasleft>=0){
	                 index++;route++;
	                 if(index==len) 
	                    index=0;
	             }else break;
             }
             if(route%len==i)  return i;
    	}
    	
    	return -1;
    }
}