package com.wq.alg0504e; 
/**
   @ClassName: Solution 
   @Description: 514Input: s = "abcdefg", k = 2
                 Output: "bacdfeg"
   @param  
   @return 
 * @author Administrator
 * 2017年5月4日 上午8:44:46   
 */
public class Solution {
    public String reverseStr(String s, int k) {
        if(null==s||s.length()==0) return "";
        int len=s.length();
        if(len<=k)  return reverseHelper(s);
        else{
           return reverseHelper(s.substring(0,k+1)+s.substring(k));
        }
        
    }

	private String reverseHelper(String s) {
		int len=s.length();
		char [] c=s.toCharArray();
		String str="";
		for(int i=len-1;i>=0;i--){
			str+=c[i];
		}
		return str;
	}
}
