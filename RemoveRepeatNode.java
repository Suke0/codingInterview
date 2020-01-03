package codingInterview;

import java.util.HashSet;

public class RemoveRepeatNode {
	public class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value=value;
		}
	}
	
	public static void removeRepeat(Node head) {
		HashSet<Integer> set=new HashSet<Integer>();
		Node temp=head;
		Node pre=null;
		while(temp !=null) {
			if(set.contains(temp.value)) {
				pre.next=temp.next;
			}else {
				set.add(temp.value);
				pre=temp;
			}
			temp=temp.next;
		}
	}
	
}
