package codingInterview;

import java.util.Stack;

public class StackSortUseStack {
	private Stack<Integer> stack1=null;
	public StackSortUseStack() {
		this.stack1=new Stack<Integer>();
	}
	public void sort(Stack<Integer> ostack) {
		if(ostack.empty()) {
			throw new RuntimeException("ø’’ª");
		}
		
		while(!ostack.empty()) {
			int value=ostack.pop();
				while(!this.stack1.empty() && this.stack1.peek() < value) {
					ostack.push(this.stack1.pop());
				}
				this.stack1.push(value);
			}
		while(!this.stack1.empty()) {
			ostack.push(this.stack1.pop());
		}
	}
	public static void main(String[] args) {
		StackSortUseStack sss=new StackSortUseStack();
		Stack<Integer> sk=new Stack<Integer>();
		sk.push(1);
		sk.push(6);
		sk.push(2);
		sk.push(5);
		sk.push(3);
		sk.push(9);
		//sk.push(1);
		sss.sort(sk);
		while(!sk.empty()) {
			System.out.println(sk.pop());
		}
		
	}
}

