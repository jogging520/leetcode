package com.wq.alg0531m;

import java.util.Stack;

public class MinStack {
    int  min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack();
        //min=Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
        	stack.push(0);
        	min=x;
        }else{
        	stack.push(x-min);
        	if(min>x){
        		min=x;
        	}
        }
    }
    
    public void pop() {
        if(stack.isEmpty())  return;
        int pop=stack.pop();
        if(pop<0){
        	min=min-pop;
        }
    }
    
    public int top() {
        int top=stack.peek();
        if(top>0){
        	return min+top;
        }else{
           return min;
        }
    }
    
    public int getMin() {
        return min;
    }
}