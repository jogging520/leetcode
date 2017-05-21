package com.wq.alg0518h;

/**
   @ClassName: Solution 
   @Description: 327Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
   Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
   @param  
   @return 
 * @author Administrator
 * 2017年5月18日 上午8:49:37   
 */
public class Solution {
	
   public int countRangeSum(int[] nums, int lower, int upper) {
//       if(null==nums||nums.length==0) return 0;
//       int len=nums.length;
//       int[] sum=new int [len+1];
//       for(int i=0;i<len;i++){
//    	   sum[i+1]=sum[i]+nums[i];
//       }
//       int res=0;
//	   for(int i=0;i<len;i++){
//		   for(int j=i+1;j<len;j++){
//			   int k=sum[j]-sum[i];
//			   if(k>=lower&&k<=upper){ 
//				   res++;
//			   }
//		   }
//	   }
//	   return res;
//	   //System.arraycopy(src, srcPos, dest, destPos, length);
//   }
	   int n=nums.length;
	   long[] sums=new long [n+1];
	   for(int i=0;i<n;i++){
		   sums[i+1]=sums[i]+nums[i];
	   }
	   return CountWhileMergeSort(sums,0,n+1,lower,upper);
   }

	private int CountWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
	    if(end<start) return 0;
	    int mid=(start+end)/2;
	    int count=CountWhileMergeSort(sums,start,mid,lower,upper)+
	    		  CountWhileMergeSort(sums,mid,end,lower,upper);
	    int j=mid,k=mid,t=mid;
	    long []cache =new long[end-start];
	    for(int i=start,r=0;i<mid;++i,++r){
	    	while(k<end&&sums[k]-sums[i]<lower) k++;
	    	while(j<end&&sums[j]-sums[i]<=upper) j++;
	    	while(t<end&&sums[t]<sums[i]) cache[r++]=sums[t++];
	        cache[r]=sums[i];
	        count+=j=k;
	    }
	    System.arraycopy(cache, 0, sums, start, t-start);//how and why
		return count;
	}
   
}
