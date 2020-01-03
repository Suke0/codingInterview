package codingInterview;

import java.util.LinkedList;

public class SonArrayNum {
	public static int getNum(int[] arr,int num){
		if(arr==null || arr.length==0 || num<0){
			return 0;
		}
		int i=0;
		int j=0;
		int res=0;
		LinkedList<Integer> qmax=new LinkedList<Integer>(); 
		LinkedList<Integer> qmin=new LinkedList<Integer>(); 
		while(i<arr.length){
			while(j<arr.length){
				while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[j] ){
					qmax.pollLast();
				}
				qmax.addLast(j);
				while(!qmin.isEmpty() && arr[qmin.peekLast()]>=arr[j] ){
					qmin.pollLast();
				}
				qmin.addLast(j);
				if(arr[qmax.peekFirst()]-arr[qmin.peekFirst()] >num){
					break;
				}
				j++;
			}
			if(qmax.peekFirst()==i){
				qmax.pollFirst();
			}
			if(qmin.peekFirst()==i){
				qmin.pollFirst();
			}
			res+=j-i;
			i++;
		}
		return res;
	}
}
