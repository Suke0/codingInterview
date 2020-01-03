package codingInterview;

import java.util.HashMap;

//给定一个字符串str，返回str的最长无重复字符子窜的长度，要求时间复杂度为	O(N)
public class MaxUnique {
	//时间复杂度为O(N*logN)
	public static int maxUnique(String str) {
		char[] ch=str.toCharArray();
		int[] arr=new int[ch.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=1;
		}
	a:	for (int i = 0; i < ch.length; i++) {
			for (int j = i+1; j < ch.length; j++) {
				if(!str.substring(i, j).contains(ch[j]+"")) {
					arr[i]=arr[i]+1;
				}else {
					continue a;
				}
			}
		}
		int max=0;
		for (int i = 0; i < arr.length; i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		System.out.println(max);
		return max;
	}
	//时间复杂度为O(N)
	public static int maxUnique1(String str) {
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		char[] ch=str.toCharArray();
		int[] preArr=new int[ch.length];
		for (int i = 0; i < ch.length; i++) {
			if(map.get(ch[i])==null) {
				preArr[i]=i==0?1:preArr[i-1]+1;
			}else {
				int aPos=map.get(ch[i])+1;
				int bPos=i-preArr[i-1];
				if(aPos>=bPos) {
					preArr[i]=i-aPos+1;
				}else {
					preArr[i]=i-bPos+1;
				}
			}
			map.put(ch[i], i);
		}
		int max=0;
		for (int i = 0; i < preArr.length; i++) {
			if(max<preArr[i]) {
				max=preArr[i];
			}
		}
		System.out.println(max);
		return max;
	}
	public static void main(String[] args) {
		maxUnique("aabcbdfagrykyuytergbvcffewgetsbyh");
		maxUnique1("aabcbdfagrykyuytergbvcffewgetsbyh");
	}
}
