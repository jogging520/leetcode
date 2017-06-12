package com.wq.alg0608m;

import java.util.HashSet;
import java.util.Set;

/**
   @ClassName: Solution2 
   @Description: @575. Distribute Candies
   @param  
   @return 
 * @author Administrator
 * 2017年6月12日 下午5:44:13   
 */
public class Solution2 {
	 public int distributeCandies(int[] candies) {
	     Set<Integer> set=new HashSet<Integer>();
	     for(int candy:candies){
	    	 set.add(candy);
	     }
		 return Math.min(candies.length/2, set.size());
	 }
}
