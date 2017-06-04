package com.wq.alg0528m;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qiwu
 * @225 mplement the following operations of a stack using queues.

	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	empty() -- Return whether the stack is empty.

 */
public class MyStack {
	/**
	 * Your MyStack object will be instantiated and called as such:
	 * MyStack obj = new MyStack();
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
	/** Initialize your data structure here. */
	Queue<Integer> queue;
    public MyStack() {
        this.queue=new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++){
        	queue.add(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	return  queue.poll();

    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
