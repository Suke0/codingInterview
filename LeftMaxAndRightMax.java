package codingInterview;
//����leftmax��rightmax֮��ľ���ֵ��
//����һ������ΪN�����飬���Ի���Ϊ�����������֣���������������������ֵ�Ĳ�ֵ�����Ϊ����
//ʱ�临�Ӷ�ΪO(N)���ռ临�Ӷ�ΪO(1)
public class LeftMaxAndRightMax {
	public static int getMax(int[] arr) {
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max=Math.max(max, arr[i]);
		}
		return max-Math.min(arr[0], arr[arr.length-1]);
	}
}
