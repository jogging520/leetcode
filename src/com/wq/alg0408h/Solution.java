package com.wq.alg0408h;

import java.util.Arrays;

public class Solution {
	public static int maximumGap(int[] num) {
	    if (num == null || num.length < 2)
	        return 0;
	    // get the max and min value of the array
	    int min = num[0];
	    int max = num[0];
	    for (int i:num) {
	        min = Math.min(min, i);
	        max = Math.max(max, i);
	    }
	    System.out.println("max:"+max);
	    System.out.println("min:"+min);

	    // the minimum possibale gap, ceiling of the integer division
	    int gap = (int)Math.ceil((double)(max - min)/(num.length - 1));
	    System.out.println("gap:"+gap);

	    int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
	    int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
	    Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
	    Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
	    
	    // put numbers into buckets
	    for (int i:num) {
	        if (i == min || i == max)
	            continue;
	        int idx = (i - min) / gap; // index of the right position in the buckets
	        bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
	        bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
	        System.out.println("idx is (i-min)/gap:"+idx+",i is"+i+",buctketMIN:"+bucketsMIN[idx]+", buctketMMAX:"+bucketsMAX[idx]);

	    }
	    System.out.println("bucketsMIN:");printArray(bucketsMIN);
	    System.out.println("bucketsMAX:");printArray(bucketsMAX);

	    // scan the buckets for the max gap
	    int maxGap = Integer.MIN_VALUE;
	    int previous = min;
	    for (int i = 0; i < num.length - 1; i++) {
	        if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
	            // empty bucket
	            continue;
	        // min value minus the previous value is the current gap
	        maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
	        // update previous bucket value
	        previous = bucketsMAX[i];
	    }
	    maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
	    return maxGap;
	}
	private static void printArray(int[] bucketsMIN) {
		String res="";
		for (int i:bucketsMIN){
              res+=i+",";
		}
		System.out.println(res);
	}
	public static void main(String[] args) {
		int [] nums={9,8,5,2,1,1000};
		System.out.println(maximumGap(nums));
	}
}
