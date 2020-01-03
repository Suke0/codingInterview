package codingInterview;

import java.util.LinkedList;

public class MaxWindow {
	//����������±�Ϊstart��end֮���Ԫ���е����ֵ
	public static int getMax(int[] arr,int start,int end){
		int temp=arr[start];
		while(end>start){
			if(temp<arr[++start]){
				temp=arr[start];
			}
		}
		return temp;
	}
	
	//���淽ʽʵ��
	public static int[] getMaxWindow(int[] arr,int w){
		int[] newArr=new int[arr.length-(w-1)];
		for(int i=0;i+w-1<arr.length;i++){
			newArr[i]=getMax(arr,i,i+w-1);
		}
		return newArr;
	}
	
	//ͨ��˫��������ʵ�֡�
	/*˼·����
	 qmax�ķ������
	        ���α���arr�������飬qmax�Ķ�ͷʼ�մ�ű��������ֵ��Ӧ���±꣬
	       1���� ��һ������ֵ  <= ��ǰ��β�����±��Ӧ������ֵ���򽫴�ֵ��Ӧ���±�����β��
	       2���� ��һ������ֵ  > ��ǰ��β�����±��Ӧ������ֵ���򽫵�ǰ��β�����������������
	  
	  qmax�ĵ�������
	           ����ֻ�ڶ�ͷ�������������ǹ��ڵĶ�ͷ���ֵ��Ӧ���±ꡣ 
	   
	     �ܽ���˵��֮������˫�˶���qmax������Ϊ��
	      1.��ͷ��Ҫ֧�ֳ��Ӳ������������𵯳����ڵ����ֵ�±ꣻ
	      2.��β��ͬʱ֧���������Ӳ������Դ�����̬�ĸ���qmax��ʹ�ö�ͷ����±��Ӧ������ֵһֱ�ǵ�ǰ�����ֵ
	*/
	public static int[] getMaxWindowByLinkedList(int[] arr,int w){
	LinkedList<Integer> qmax=new LinkedList<Integer>();
	int[] newArr=new int[arr.length-(w-1)];
	int index=0;
	
	for (int i = 0; i < arr.length; i++) {
		while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]){
			qmax.pollLast();
		}
		qmax.addLast(i);//ֻ���Ŵ��ڵ���arr[i]��Ԫ�ص��±�
		if(qmax.peekFirst()==i-w){
			qmax.pollFirst();
		}
		if(i>=w-1){
			newArr[index++]=arr[qmax.peekFirst()];
		}
	}
		return newArr;
	}
	
	
	public static void main(String[] args) {
		int[] arr={4,3,5,4,3,3,6,7};
		//int[] ar=getMaxWindow(arr, 3);
		int[] ar1=getMaxWindowByLinkedList(arr, 3);
		
		for (int i = 0; i < ar1.length; i++) {
			System.out.println(ar1[i]);
		}
		
		/*LinkedList<Integer> ll=new LinkedList<Integer>();
		ll.add(1);
		ll.addFirst(2);
		ll.addLast(3);
		ll.add(4);
		
		System.out.println(ll.peekFirst());
		*/
	}
	 
	public int[] resolution(int[] arr,int m) {
	/*	LinkedList<Integer> list=new LinkedList<Integer>();
		int[] res=new int[arr.length-m+1];
		int index=0;
		for (int i = 0; i < arr.length; i++) {
			while(!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
				list.pollLast();
			}
			list.addLast(i);
			if(list.peekFirst()==i-m) {
				list.pollFirst();
			}
			if(i-m+1>= 0) {
				res[index++]=arr[list.peekFirst()];
			}
		}
		
		return res;
	}*/
		LinkedList<Integer> qmax=new LinkedList<Integer>();
		int[] res=new int[arr.length-m+1];
		int index=0;
		for (int i = 0; i < arr.length; i++) {
			while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst()==i-m) {
				qmax.pollFirst();
			}
			if(i-m+1>=0) {
				res[index++]=arr[qmax.peekFirst()];
			}
		}
		return res;
	}
} 
