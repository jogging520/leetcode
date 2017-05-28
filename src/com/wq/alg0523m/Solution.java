package com.wq.alg0523m;

/**
 * @author qiwu
 * @274
 * For example, given citations = [3, 0, 6, 1, 5], 
 * which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5
 * citations respectively. Since the researcher has 3 papers with at least 3
 *
 */
public class Solution {

    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0) return 0;
        int len=citations.length;
        int [] buckets=new int[len+1];
        for(int c:citations){
        	if(c>=len){
        		buckets[len]++;
        	}else{
        		buckets[c]++;
        	}
        }
    	int count=0;
    	for(int i=len;i>=0;i--){
    		count+=buckets[i];
    		if(count>=i){//i is important
    			return i;
    		}
    	}
    	return 0;
    }
    
}
