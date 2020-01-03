package codingInterview;

import java.util.LinkedList;

public class MaxWindow {
	//求出数组中下标为start到end之间的元素中的最大值
	public static int getMax(int[] arr,int start,int end){
		int temp=arr[start];
		while(end>start){
			if(temp<arr[++start]){
				temp=arr[start];
			}
		}
		return temp;
	}
	
	//常规方式实现
	public static int[] getMaxWindow(int[] arr,int w){
		int[] newArr=new int[arr.length-(w-1)];
		for(int i=0;i+w-1<arr.length;i++){
			newArr[i]=getMax(arr,i,i+w-1);
		}
		return newArr;
	}
	
	//通过双向链表来实现。
	/*思路整理：
	 qmax的放入规则：
	        依次遍历arr窗口数组，qmax的队头始终存放遍历的最大值对应的下标，
	       1）若 下一个数组值  <= 当前队尾所存下标对应的数组值，则将此值对应的下标存入队尾；
	       2）若 下一个数组值  > 当前队尾所存下标对应的数组值，则将当前队尾弹出，继续放入规则。
	  
	  qmax的弹出规则：
	           弹出只在队头弹出，弹出的是过期的队头最大值对应的下标。 
	   
	     总结来说，之所以用双端队列qmax，是因为：
	      1.队头需要支持出队操作，用来负责弹出过期的最大值下标；
	      2.队尾需同时支持入队与出队操作，以此来动态的更新qmax，使得队头存的下标对应的数组值一直是当前的最大值
	*/
	public static int[] getMaxWindowByLinkedList(int[] arr,int w){
	LinkedList<Integer> qmax=new LinkedList<Integer>();
	int[] newArr=new int[arr.length-(w-1)];
	int index=0;
	
	for (int i = 0; i < arr.length; i++) {
		while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]){
			qmax.pollLast();
		}
		qmax.addLast(i);//只会存放大于等于arr[i]的元素的下标
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
