package codingInterview;

import java.util.Stack;

import javax.management.RuntimeErrorException;

//利用两个栈实现一个队列
public class MyQueue {
	private Stack<Integer> stackPop=null;
	private Stack<Integer> stackPush=null;
	
	public MyQueue() {
		this.stackPop=new Stack<Integer>();
		this.stackPush=new Stack<Integer>();
	}
	
	public void add(int value) {
			this.stackPush.push(value);
	}
	
	public int poll() {
		if(this.stackPop.isEmpty() && this.stackPush.isEmpty()) {
			throw new RuntimeException("空栈");
		}else if(this.stackPop.isEmpty()) {
			while(!this.stackPush.isEmpty()) {
				this.stackPop.push(this.stackPush.pop());
			}
		}
		return this.stackPop.pop();
	}
	
	public int peek() {
		if(this.stackPop.isEmpty() && this.stackPush.isEmpty()) {
			throw new RuntimeException("空栈");
		}else if(this.stackPop.isEmpty()) {
			while(!this.stackPush.isEmpty()) {
				this.stackPop.push(this.stackPush.pop());
			}
		}
		return this.stackPop.peek();
	}
	
	
}
