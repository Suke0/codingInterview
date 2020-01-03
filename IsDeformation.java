package codingInterview;

import java.util.HashMap;

public class IsDeformation {
	public static boolean isDeformation(String str1,String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		char[] ch1=str1.toCharArray();
		char[] ch2=str2.toCharArray();
		for (int i = 0; i < ch1.length; i++) {
			if(map.containsKey(ch1[i])){
				map.put(ch1[i],map.get(ch1[i])+1);
			}else{
				map.put(ch1[i], 1);
			}
		}
		
		for(int i = 0; i < ch2.length; i++){
			if(map.containsKey(ch2[i])){
				map.put(ch2[i],map.get(ch2[i])-1);
				if(map.get(ch2[i])<0){
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
		/*Iterator<Entry<Character,Integer>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Entry<Character,Integer> entry= (Entry<Character,Integer>)it.next();
			if(entry.getValue()!=0){
				return false;
			}
		}*/
		/*for (Entry c : map.entrySet()) {
			if((Integer)c.getValue()!=0){
				return false;
			}
		}*/
	}
	public static void main(String[] args) {
		System.out.println(isDeformation("86249111", "16819412"));
	}
}
