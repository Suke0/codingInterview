package codingInterview;
//将链表中每k个元素进行反转
public class ReverseNodePerK {
	public class Node{
		public int value;
		public Node next;
		public Node(int value) {
			this.value=value;
		}
	}
	
	public static Node reverse(Node head,int k) {
		if(k<2) {
			return head;
		}
		Node cur=head;
		Node start=head;
		Node next=null;
		Node preEnd=null;
		int count=1;
		Node newHead=null;
		while(cur !=null) {
			next=cur.next;
			if(count == k) {
				//需要反转的第一个节点为start，最后一个节点为cur
				 Node temp=null;
				 Node pre=start;
				 Node curNode=start.next;
				while(curNode != next) {
					temp=curNode.next;
					curNode.next=pre;
					pre=curNode;
					curNode=temp;
				}
				//此时cur为第一个节点，start为最后一个节点
				start.next=next;//防止形成循环链表，并且当链表的长度不是k的整数倍时，将剩下的节点连接起来
				
				//preEnd记录上 一次反转时，最后的一个节点
				if(preEnd !=null) {
					preEnd.next=cur;//将上 一次反转时，最后的一个节点指向当前反转序列的第一个节点
				}
				preEnd=start;
				
				newHead=newHead==null?cur:newHead;//newHead的初始值为null，当它被第一次赋值时，就是要返回的值
				start=next;
				count=0;
			}
			count++;
			cur=next;
		}
		
		return newHead;
	}
	
	public static void main(String[] args) {
		Node n1=new ReverseNodePerK().new Node(1);
		Node n2=new ReverseNodePerK().new Node(2);
		Node n3=new ReverseNodePerK().new Node(3);
		Node n4=new ReverseNodePerK().new Node(4);
		Node n5=new ReverseNodePerK().new Node(5);
		Node n6=new ReverseNodePerK().new Node(6);
		Node n7=new ReverseNodePerK().new Node(7);
		Node n8=new ReverseNodePerK().new Node(8);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=n8;
		
		Node node=reverse(n1, 5);
		Node temp1=node;
		while(temp1 !=null) {
			System.out.println(temp1.value);
			temp1=temp1.next;
		}
		
	}
}
