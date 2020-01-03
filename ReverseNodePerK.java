package codingInterview;
//��������ÿk��Ԫ�ؽ��з�ת
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
				//��Ҫ��ת�ĵ�һ���ڵ�Ϊstart�����һ���ڵ�Ϊcur
				 Node temp=null;
				 Node pre=start;
				 Node curNode=start.next;
				while(curNode != next) {
					temp=curNode.next;
					curNode.next=pre;
					pre=curNode;
					curNode=temp;
				}
				//��ʱcurΪ��һ���ڵ㣬startΪ���һ���ڵ�
				start.next=next;//��ֹ�γ�ѭ���������ҵ�����ĳ��Ȳ���k��������ʱ����ʣ�µĽڵ���������
				
				//preEnd��¼�� һ�η�תʱ������һ���ڵ�
				if(preEnd !=null) {
					preEnd.next=cur;//���� һ�η�תʱ������һ���ڵ�ָ��ǰ��ת���еĵ�һ���ڵ�
				}
				preEnd=start;
				
				newHead=newHead==null?cur:newHead;//newHead�ĳ�ʼֵΪnull����������һ�θ�ֵʱ������Ҫ���ص�ֵ
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
