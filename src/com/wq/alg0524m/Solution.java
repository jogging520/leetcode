package com.wq.alg0524m;

/**
 * @author qiwu
 * @3241) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
      (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 */
public class Solution {
	   public void wiggleSort(int[] nums) {
	    	 if(null==nums||nums.length==0) return ;
	    	 int len=nums.length;
	    	 int i=0,left=0;
	    	 int right=len-1;
	    	 int med=findKthLargest(nums,(1+len)/2,0,len-1);
	    	 while(i<=right){
	    		 if(nums[newIndex(i,len)]>med){
	    			 swap(nums,newIndex(left,len),newIndex(i,len));//**
	    			 left++;
	    			 i++;
	    		 }else if(nums[newIndex(i,len)]<=med){
	    			 swap(nums,newIndex(right,len),newIndex(i,len));//**
                     right--;
	    		 }else{
	    			 i++;
	    		 }
	    	 }

	    }
	    
	    private void swap(int[] nums, int i, int j) {
			 int temp=nums[i];
			 nums[i]=nums[j];
			 nums[j]=temp;
			
		}
	    private int findKthLargest(int[] nums, int pos,int low,int high) {
			int start=low;
			int end=high;
			int med=nums[pos];
			while(start<=end){
				while(nums[start]<med){
					start++;
				}
				while(nums[end]>med){
					end--;
				}
				if(start==pos&&end==pos){
					return nums[pos];
				}
				if(start<end){
					swap(nums,start,end);
					start++;
					end--;
				}
			}
			if(start<=pos){
				return findKthLargest(nums,pos,start,high);
			}
	    	return findKthLargest(nums,pos,low,end);
		}

		//n|1  if n is odd return n ;if n is even return n+1
	    private static int newIndex(int index, int n) {
	        return (1 + 2*index) % (n | 1);
	    }
	    
	    public static void main(String[] args) {
			System.out.println(newIndex(3,5));
		}

}
