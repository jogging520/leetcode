package com.wq.alg0501m;

import java.util.ArrayList;
import java.util.List;

/**
   @ClassName: Solution 
   @Description: 241
   Example 2
	Input: "2*3-4*5"
	
	(2*(3-(4*5))) = -34
	((2*3)-(4*5)) = -14
	((2*(3-4))*5) = -10
	(2*((3-4)*5)) = -10
	(((2*3)-4)*5) = 10
   @param  
   @return 
 * @author Administrator
 * 2017年5月1日 下午4:01:06   
 */
public class Solution {
	  public List<Integer> diffWaysToCompute(String input) {
	      List<Integer> resList=new ArrayList<Integer>();
          if(null==input||input.length()==0) return resList;
        
	      for(int i=0;i<input.length();i++){
	    	  char c=input.charAt(i);
	    	  if(c=='+'||c=='-'||c=='*'){
	    		  List<Integer> part1List=diffWaysToCompute(input.substring(0,i));
	    		  List<Integer> part2List=diffWaysToCompute(input.substring(i+1,input.length()));
	    	 
		    	  for(int p1:part1List){
		    		  int temp=0;
			    	  for(int p2:part2List){
			    		  if(c=='+') temp=p1+p2;
			    	      if(c=='-') temp=p1-p2;
			    	      if(c=='*') temp=p1*p2;
			    	      resList.add(temp);
			    	  }
			      }
	    	  }
	       }
	      if(resList.size()==0){
	    	  resList.add(Integer.parseInt(input));
	      }
	      return resList;
	  }
}
