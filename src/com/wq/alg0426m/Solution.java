package com.wq.alg0426m;

/**
   @ClassName: Solution 
   @Description: For num = 5 you should return [0,1,1,2,1,2].
   @param  
   @return 
 * @author Administrator
 * 2017年4月27日 上午9:17:49   
 */
public class Solution {
	
	 public int[] countBits(int num) {
		int[] res=new int [num+1];
		for(int i=1;i<num;i++){
			if(i%2==0){
				res[i]=res[i/2];
			}
			else{
				res[i]=res[i-1]+1;
			}
		}
	    return res;    
	 }

}
