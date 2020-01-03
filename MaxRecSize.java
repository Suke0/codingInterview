package codingInterview;

import java.util.Stack;

public class MaxRecSize {
	/*
	 ������ľ������⣬�������н����

	��˼������һ�����⣬�����һ������{3 4 5 2 4}Χ�ɵ���������

	������һ��λ��i��������Ҫ�ҵ������ұߵ�һ��С��arr[i]������λ��p1��p2����λ��i��Ӧ������ǣ�p2 - p1 - 1��* arr[i]

	��Ҫһ������ջ��ѹ�뵯���������£���ע��ֻѹ���±꣩

	1. ����ǰ�� arr[i] ���ڻ����ջ����arr[j]��ѹ�뵱ǰ�����±�i��

	2.���򣬵���ջ����j����ʱջ����Ϊk�������жϡ�

	ֻ�����2�м�����Ҫ��������Ե�����ջ����j�����ұߵ�һ������С����Ϊarr[i], ����ߵ�һ������С����Ϊarr[k]. ���j��˵��

	���Ӧ�����Ϊ��i - k - 1��* arr[j]

	��ջΪ��, ��߽�Ϊ-1   ���Ѿ�ѹ�������е�����Ԫ�أ����ұ߽��Ϊarr.length
	*/
	public static int maxRecSize(int[][] arr){
		if(arr==null ||arr.length==0 || arr[0].length==0){
			return 0;
		}
		int maxArea=0;
		int[] height=new int[arr[0].length];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<height.length;j++){
				height[j]=arr[i][j]==0?0:height[j]+1;
			}
			maxArea=Math.max(maxRecFromBottom(height),maxArea );
		}
		return maxArea;
		
	}

	private static int maxRecFromBottom(int[] height) {
		if(height==null ||height.length==0){
			return 0;
		}
		int maxArea=0;
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<height.length;i++){
			while(!stack.isEmpty() && height[i]<=height[stack.peek()]){
				int j=stack.pop();
				int k=stack.isEmpty()?-1:stack.peek();
				int curArea=(i-k-1)*height[j];
				maxArea=Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
			while(!stack.isEmpty()){
				int j=stack.pop();
				int k=stack.isEmpty()?-1:stack.peek();
				int curArea=(height.length-k-1)*height[j];
				maxArea=Math.max(maxArea, curArea);
			}
		return maxArea;
	}
	public static void main(String[] args) {
		int[][] arr={{1,0,1,1},{1,1,1,1},{1,1,1,0}};
		System.out.println(maxRecSize(arr));
	}
}
