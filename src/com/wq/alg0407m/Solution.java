package com.wq.alg0407m;

import java.util.Comparator;
import java.util.List;

/**
 * @author qiwu
 *
 *Input:
	s = "abpcplea", d = ["ale","apple","monkey","plea"]
**********************************************************
  Output: 
	"apple"
 */
public class Solution {
     public String findLongestWord(String s, List<String> d) {
    	 if(null==d||d.size()==0) return "";
    	 //1.sort dic from length max->min ,letter min->max
    	 d.sort(new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length()!=o2.length()?o2.length()-o1.length():o1.compareTo(o2);
			} 
    	 });
         //2.比较s与字典
    	 for(String str:d){
    		 int i=0;
    		 for(char c:s.toCharArray()){
    			 if(i<str.length()&&c==str.charAt(i)){
    			      i++;
    			 }
    		 }
    		 if(i==str.length()){
    			 return str;
    		 }
    	 }
    	 return "" ;
     }

}
