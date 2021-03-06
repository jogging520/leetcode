package com.wq.alg.day0329e;

import java.util.Arrays;

/**
 * @author qiwu
 * Input: [1,2], [1,2,3]

	Output: 2
	
	Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
	You have 3 cookies and their sizes are big enough to gratify all of the children, 
	You need to output 2.
 *
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j=0;i<g.length && j<s.length;j++) {
        	if(g[i]<=s[j]) i++;
        }
        return i;
    }
}