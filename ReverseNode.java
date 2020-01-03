package codingInterview;

//链表反转
public class ReverseNode {
	//单链表
	public class Node{
		public int value;
		public Node next;
		public Node(int value){
			this.value=value;
		}
	}
	//单链表的反转
	public static Node reverseNode(Node head) {
		if(head==null || head.next==null){
			return head;
		}
		Node pre=head;//前一个节点
		Node cur=head.next;//当前节点
		Node temp=null;//临时节点，用来保存当前节点的下一个节点
		while(cur !=null){
			temp=cur.next;
			cur.next=pre;
			pre=cur;
			cur=temp;
		}
		head.next=null;//最后将原链表的头节点的指针域置为null，防止产生循环链表
		return pre;
	}
	//双链表
	public class DoubleNode{
		public int value;
		public DoubleNode pre;
		public DoubleNode next;
		public DoubleNode(int value){
			this.value=value;
		}
	}	
	//双向链表的反转
		public static DoubleNode reverseDoubleNode(DoubleNode head){
			DoubleNode pre=head;
			DoubleNode cur=head.next;
			DoubleNode temp=null;
			while(cur !=null){
				temp=cur.next;
				cur.next=pre;
				cur.pre=temp;
				pre=cur;
				cur=temp;
			}
			head.next=null;
			return pre;
	}
		
		public static void main(String[] args) {
			Node n1=new ReverseNode().new Node(1);
			Node n2=new ReverseNode().new Node(2);
			Node n3=new ReverseNode().new Node(3);
			Node n4=new ReverseNode().new Node(4);
			Node n5=new ReverseNode().new Node(5);
			Node n6=new ReverseNode().new Node(6);
			Node n7=new ReverseNode().new Node(7);
			Node n8=new ReverseNode().new Node(8);
			
			n1.next=n2;
			n2.next=n3;
			n3.next=n4;
			n4.next=n5;
			n5.next=n6;
			n6.next=n7;
			n7.next=n8;
			
			Node node=reverseNode(n1);
			Node temp1=node;
			while(temp1 !=null) {
				System.out.println(temp1.value);
				temp1=temp1.next;
			}
			
		}
		
		
}
