package codingInterview;
//最大的leftmax和rightmax之差的绝对值。
//给定一个长度为N的数组，可以划分为左右两个部分，求出左右两个部分中最大值的差值，最大为多少
//时间复杂度为O(N)，空间复杂度为O(1)
public class LeftMaxAndRightMax {
	public static int getMax(int[] arr) {
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max=Math.max(max, arr[i]);
		}
		return max-Math.min(arr[0], arr[arr.length-1]);
	}
}
