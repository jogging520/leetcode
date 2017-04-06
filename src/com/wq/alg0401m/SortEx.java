package com.wq.alg0401m;

import java.util.Arrays;
import java.util.Comparator;

public class SortEx {

	public static void main(String[] args) {
	
		 int[][] a={{1,3},{4,2},{2,4},{1,9}};
	     
		 
		Arrays.sort(a,new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				return  o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0];
			}
			
		});
		for(int i=0;i<4;i++){
	    	 for(int j=0;j<2;j++){
	    		 System.out.println(a[i][j]+",");
	    	 }
	    	 System.out.println("***");
	     }
//		System.out.println(a.toString());
		
	}

}
