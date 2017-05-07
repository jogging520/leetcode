package com.wq.alg0507h;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiwu
 * @282 
 *  "123", 6 -> ["1+2+3", "1*2*3"] 
	"232", 8 -> ["2*3+2", "2+3*2"]
	"105", 5 -> ["1*0+5","10-5"]
	"00", 0 -> ["0+0", "0-0", "0*0"]
	"3456237490", 9191 -> []
 */
public class Solution {
	 public List<String> addOperators(String num, int target) {
	        List<String> resList=new ArrayList<String>();
	        if(null==num||num.length()==0) return resList;
	        helper(resList,"",num,target,0,0,0);
	        return resList;
	 }

	private void helper(List<String> resList, String path,String num, int target, int pos, long eval, long multi) {
	     if(pos==num.length()){
	    	 if(eval==target){
	    		 resList.add(path);
	    		 return;
	    	 }
	     }
		 for(int i=pos;i<num.length();i++){
			 if(i != pos && num.charAt(pos) == '0') break;
			 long cur=Long.parseLong(num.substring(pos, i+1));
			 if(pos==0){
				 helper(resList,path+cur,num,target,i+1,cur,cur);
			 }else{
				 helper(resList,path+"+"+cur,num,target,i+1,eval+cur,cur);
				 helper(resList,path+"-"+cur,num,target,i+1,eval-cur,-cur);
				 helper(resList,path+"*"+cur,num,target,i+1,eval-multi+multi*cur,multi*cur);
			 }
			 
		 }
	}
}
