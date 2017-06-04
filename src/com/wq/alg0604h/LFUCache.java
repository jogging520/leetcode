package com.wq.alg0604h;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	private Node head=null;
	private int cap=0;
	private HashMap<Integer,Integer> valueHash=null;
	private HashMap<Integer,Node> nodeHash=null;
	
    public LFUCache(int capacity) {
        this.cap=capacity;
        valueHash=new HashMap<Integer,Integer>();
        nodeHash=new HashMap<Integer,Node>();
    }
    
    public int get(int key) {
        if(valueHash.containsKey(key)){
        	inCreaseCount(key);
        	return valueHash.get(key);
        }else{
        	return -1;
        }
    }
    
    private void inCreaseCount(int key) {
        Node node=nodeHash.get(key);
        node.keys.remove(key);
        if(node.next==null){
        	node.next=new Node(node.count+1);
        	node.next.prev=node;
        	node.next.keys.add(key);
        }else if(node.next.count==node.count+1){
        	node.next.keys.add(key);
        }else{
        	Node temp=new Node(node.count+1);
        	temp.keys.add(key);
        	temp.prev=node;
        	temp.next=node.next;
        	node.next.prev=temp;
        	node.next=temp;
        }
        nodeHash.put(key, node.next);
        if(node.keys.size()==0) remove(node);
	}

	private void remove(Node node) {
         if(node.prev==null){
        	 head=node.next;
         }else{
        	 node.prev.next=node.next;
         }
         if(node.next!=null){
        	 node.next.prev=node.prev;
         }
	}
	private void removeOld(){
		if(head==null)  return ;
		int old=0;
		for(int n:head.keys){
			old=n;
			break;
		}
		head.keys.remove(old);
		if(head.keys.size()==0)  remove(head);
		nodeHash.remove(old);
		valueHash.remove(old);
	}

	public void put(int key, int value) {
        if(cap==0) return;
        if(valueHash.containsKey(key)){
        	valueHash.put(key, value);
        }else{
        	if(valueHash.size()<cap){
        		valueHash.put(key, value);
        	}else{
        		removeOld();
        		valueHash.put(key, value);
        	}
        	addToHead(key);
        }
        inCreaseCount(key);
    }
    private void addToHead(int key){
    	if(head==null){
    		head=new Node(0);
    		head.keys.add(key);
    	}else if (head.count>0){
    		Node node=new Node(0);
    		node.keys.add(key);
    		node.next=head;
    		head.prev=node;
    		head=node;
    	}else{
    		head.keys.add(key);
    	}
    	nodeHash.put(key, head);
    }
    class Node {
        public int count = 0;
        public LinkedHashSet<Integer> keys = null;
        public Node prev = null, next = null;
        
        public Node(int count) {
            this.count = count;
            keys = new LinkedHashSet<Integer>();
            prev = next = null;
        }
    }
}
