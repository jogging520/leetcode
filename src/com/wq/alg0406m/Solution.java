package com.wq.alg0406m;

public class Solution {
    public void wiggleSort(int[] nums) {
    	 int median = findKthLargest(nums, (nums.length + 1) / 2,0,nums.length-1);
         int n = nums.length;

         int left = 0, i = 0, right = n - 1;

         while (i <= right) {

             if (nums[newIndex(i,n)] > median) {
                 swap(nums, newIndex(left++,n), newIndex(i++,n));
             }
             else if (nums[newIndex(i,n)] < median) {
                 swap(nums, newIndex(right--,n), newIndex(i,n));
             }
             else {
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
		int end =high;
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
			if(start<=end){
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
		System.out.println( newIndex(1, 6 ) );
	}
}