package com.wq.alg0513m;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiwu
 *Given "25525511135",

  return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> resList=new ArrayList<>();
    	if(null==s||s.length()<4||s.length()>12) return resList;
    	int len=s.length();
    	//暴力法
    	for(int i=1;i<4&&i<len-2;i++){
    		for(int j=i+1;j<i+4&&j<len-1;j++){
    			for(int k=j+1;k<j+4&&k<len;k++){
    				String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        resList.add(s1+"."+s2+"."+s3+"."+s4);
                    }
    			}
    		}
    	}
    	
    	return resList;
    }

	private boolean isValid(String s1) {
		if(s1.length()>3||s1.length()==0||(s1.charAt(0)=='0'&&s1.length()>1)||Integer.parseInt(s1)>255){
			return false;
		}
		return true;
	}
}
