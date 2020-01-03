package codingInterview;

import java.util.Stack;

public class MaxRecSize {
	/*
	 对这类的矩阵问题，可以逐行解决。

	先思考这样一个问题，如何求一个数组{3 4 5 2 4}围成的最大面积。

	对任意一个位置i，我们需要找到其左右边第一个小于arr[i]的数的位置p1，p2，则位置i对应的面积是（p2 - p1 - 1）* arr[i]

	需要一个辅助栈，压入弹出规则如下：（注意只压入下标）

	1. 若当前数 arr[i] 大于或等于栈顶数arr[j]，压入当前数的下标i；

	2.否则，弹出栈顶数j。此时栈顶数为k，继续判断。

	只在情况2中计算想要的面积。对弹出的栈顶数j，其右边第一个比他小的数为arr[i], 其左边第一个比他小的数为arr[k]. 则对j来说，

	其对应的面积为（i - k - 1）* arr[j]

	当栈为空, 左边界为-1   或已经压入了所有的数组元素，其右边界就为arr.length
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
