package com.wq.alg0430m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qiwu
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

	Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
	
	Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 */
public class Solution {
	 public List<String> findAllConcatenatedWordsInADict(String[] words) {
		 List<String> resList=new ArrayList<String>();
		 if(null==words||words.length<=2) return resList;
		 
		 Set<String> diction= new HashSet<String>();
		 //1.order the words from small length to large
		 Arrays.sort(words,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}		 
		 });
		 //2.get every word to see if this one is Concatenated then put it into res
		 for(String str:words){
			 if(isConcatenated(str,diction)){
				 resList.add(str);
			 }
			 diction.add(str);
		 }
	     return resList;
		 //function of to judge if it is Concatenated
	 }

	private boolean isConcatenated(String str, Set<String> diction) {
		if(null==diction||diction.isEmpty())  return false;
		int len=str.length();
		boolean [] dp=new boolean [len+1];
		dp[0]=true;
		for(int i=1;i<=len;i++){
			for(int j=0;j<i;j++){
				if(dp[j]==false) continue;
				if(diction.contains(str.substring(j, i))){
					dp[i]=true;
					break;
				}
			}
		}
		return dp[len];
	}
	
}
