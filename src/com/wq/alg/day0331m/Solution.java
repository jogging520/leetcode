package com.wq.alg.day0331m;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 *
 * 2017��3��31�� ����8:51:52   
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
    	//1. �ҳ�����g[i]>cost[i]�ĵ㣬��������б�
    	for(int i=0;i<len;i++){
    		if(gas[i]>cost[i]) {
    			list.add(i);
    		}
    	}  	
    	int gasleft=0;
        //2. ѭ������б�����ÿ���߶��Ƿ�ʣ��gasleft>0  ���С��0����������㣬ֱ������
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