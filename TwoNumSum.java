package codingInterview;

import java.util.HashMap;
//Ѱ��������������Ԫ�صĺ�Ϊsum��Ҫ��ʱ�临�Ӷ�ΪO(n)
public class TwoNumSum {
	public static void twoNumSum(int[] arr, int sum) {
		boolean flag=false;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==sum) {
					flag=true;
					System.out.println(i+"--"+j+"==="+arr[i]+"--"+arr[j]);
				}
			}
		}
		if(!flag) {
			System.out.println("û���ҵ���");
		}
	}
	
	public static void twoNumSum1(int[] arr,int sum) {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i]) && arr[i]+arr[i]==sum) {
				System.out.println(arr[i]+"---"+arr[i]);
			}else {
			map.put(arr[i], sum-arr[i]);
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(map.get(arr[i])) && map.get(arr[i]) < arr[i] ) {
				System.out.println(arr[i]+"---"+(sum-arr[i]));
			}
		}
		
	}
	public static void main(String[] args) {
		TwoNumSum.twoNumSum(new int[]{1,3,5,4,6,2,3,4,7},7);
		System.out.println("--------------------------");
		TwoNumSum.twoNumSum1(new int[]{1,3,5,4,6,2,3,4,7},7);
	}
	
}
