package codingInterview;

import java.util.Random;
import java.util.Stack;
//用一个栈实现另一个栈的排序，从栈顶到栈底按大到小排序
public class SortStackByStack {
	public static void sortStackByStack(Stack<Integer> stack){
		Stack<Integer> help=new Stack<Integer>();
		while(!stack.isEmpty()){
			int cur=stack.pop();
			while(!help.isEmpty() && help.peek() < cur){
				//将help中大于等于cur的元素都重新压入stack中
				stack.push(help.pop());
			}
			//heip中的元素是从小到大排列的
			help.push(cur);
		}
		while(!help.isEmpty()){
			System.out.print(help.peek()+" ");
			stack.push(help.pop());
		}
	}
	public static void main(String[] args) {
		Stack<Integer> st=new Stack<Integer>();
		while(st.isEmpty() || st.size()<10){
			st.push(new Random().nextInt(100));
			System.out.print(st.peek()+" ");
		}
		System.out.println();
		 sortStackByStack(st);
	}
}
