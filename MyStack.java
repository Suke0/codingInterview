package codingInterview;

import java.util.Stack;

//ʵ��һ��getMin��ջ
public class MyStack {
	private Stack<Integer> stackData=null;
	private Stack<Integer> stackMin=null;
	
	public MyStack() {
		this.stackData=new Stack<Integer>();
		this.stackMin=new Stack<Integer>();
	}
	
	public void push(int value) {
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(value);
		}else if(value < this.getMin()) {
			this.stackMin.push(value);
		}else {
			int item=this.getMin();
			this.stackMin.push(item);
		}
		this.stackData.push(value);
	}
	
	public int pop() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("��ջ");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}
	
	
	public int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("��ջ");
		}
		return this.stackMin.peek();
	}
}
