package com.wq.alg0527m;

/**
 * @author qiwu
 * @147 Sort a linked list using insertion sort.
 *
 */
public class Solution {
	    public ListNode insertionSortList(ListNode head) {
	        //loop Node  1.get the insert positin 2. insert 
	    	if(head==null||head.next==null) return head;
	    	ListNode helper=new ListNode(0);
	    	ListNode cur=head;
	        ListNode pre=helper;
	    	ListNode next=null;
	    	while(cur!=null){
	    		next=cur.next;
	    		while(pre.next!=null&&pre.next.val<cur.val){
	    			pre=pre.next;
	    		}
	    		//insert
	    		cur.next=pre.next;
	    		pre.next=cur;
	    		pre=helper;
	    		cur=next;
	    	}
	    	return helper.next;
	    }
	    
	    public class ListNode {
	       int val;
	       ListNode next;
	       ListNode(int x) { val = x; }
	    }
}
