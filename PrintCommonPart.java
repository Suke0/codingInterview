package codingInterview;

public class PrintCommonPart {
	public class Node{
		public int value;
		public Node next;
		public Node(int value){
			this.value=value;
		}
	}
	public static void printCommonPart(Node head1,Node head2){
		if(head1==null || head2==null){
			return;
		}
		while(head1.next !=null && head2.next !=null){
			if(head1.value < head2.value){
				head1=head1.next;
			}else if(head1.value<head2.value){
				head2=head2.next;
			}else{
				System.out.println(head1.value +" ");
				head1=head1.next;
				head2=head2.next;
			}
		}
	}
}
