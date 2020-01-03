package codingInterview;

import java.util.Random;
import java.util.Stack;
//��һ��ջʵ����һ��ջ�����򣬴�ջ����ջ�װ���С����
public class SortStackByStack {
	public static void sortStackByStack(Stack<Integer> stack){
		Stack<Integer> help=new Stack<Integer>();
		while(!stack.isEmpty()){
			int cur=stack.pop();
			while(!help.isEmpty() && help.peek() < cur){
				//��help�д��ڵ���cur��Ԫ�ض�����ѹ��stack��
				stack.push(help.pop());
			}
			//heip�е�Ԫ���Ǵ�С�������е�
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
