package com.wq.alg0502h;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	double findMedianSortedArrays(int[] nums1, int[] nums2) {
	       if(nums1.length==0&&nums2.length==0) return 0;
	       int Lnum1=nums1.length;
	       int Lnum2=nums2.length;
	       int Lall=Lnum1+Lnum2;
	       int [] num=new int[Lall];
	       mergesort(nums1,nums2,num);
	    
	       if(Lall%2==0)  return (num[Lall/2-1]+num[Lall/2])*0.5;
	       else return num[(Lall-1)/2];
	    }

		private void mergesort(int[] nums1, int[] nums2, int[] num) {
	   
	       for(int i=0;i<nums1.length;i++)
	    	    num[i]=nums1[i];
	       for(int i=0,j=nums1.length;i<nums2.length;j++,i++)
	   	        num[j]=nums2[i];
	       Arrays.sort(num);
		}

}
