package com.wq.alg;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
        static List<List<String>> resultLst;
	    static ArrayList<String> currLst;
	    public static List<List<String>> partition(String s) {
	        resultLst = new ArrayList<List<String>>();
	        currLst = new ArrayList<String>();
	        backTrack(s,0);
	        return resultLst;
	    }
	    public static void backTrack(String s, int l){
	    	System.out.println("开始调用backtrack"+l+"这个时候currentLst:"+currLst);
	        if(currLst.size()>0 //the initial str could be palindrome
	            && l>=s.length()){
	                List<String> r = (ArrayList<String>) currLst.clone();
	            	System.out.println( r+"is one of p set");

	                resultLst.add(r);
	        }
	        for(int i=l;i<s.length();i++){
	        	System.out.println("以"+l+"为第一位，开始循环,向后移动(i+1):"+(i+1));
	            if(isPalindrome(s,l,i)){
//	                if(l==i)
//	                    currLst.add(Character.toString(s.charAt(i)));
//	                else
	                    currLst.add(s.substring(l,i+1));
	                backTrack(s,i+1);
	                System.out.println("currlst is "+currLst);
	                currLst.remove(currLst.size()-1);
	                System.out.println("currlst after remove and list is "+currLst+"loc向后移动的i+1:"+i);
	            }
	            else{
	            	System.out.println( s.substring(l,i+1)+"is not palindrom");
	            }
	        }
	    }
	    public static boolean isPalindrome(String str, int l, int r){
	        if(l==r) return true;
	        while(l<r){
	            if(str.charAt(l)!=str.charAt(r)) return false;
	            l++;r--;
	        }
	        return true;
	    }
	    
	    public static void main(String[] args) {
	    	String s = "aab";
	    	//System.out.println(s.substring(0,1));
	    	System.out.println(partition(s));
		}
}