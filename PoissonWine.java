package codingInterview;
//泊松分酒
/*分酒规则

大瓶子只能倒入中瓶子
中瓶子只能倒入小瓶子
小瓶子只能倒入大瓶子
小瓶子只有在已经装满的情况下才能倒入大瓶子
若小瓶子被倒空，则无论中瓶子是否满，应马上从中瓶子倒入小瓶子

设大，中，小三个瓶子容量分别是C1，C2，C3，需要倒出的容量是R
则实际上要是我们能将容量为R的酒倒到中瓶子和小瓶子中就可以啦（有点废话）
设大瓶子倒满中瓶子X次，从小瓶子中倒入大瓶子Y次。
那么显然由大瓶子累次倒入中瓶子和小瓶子总共C2*X的酒。而由小瓶子倒入大瓶子一共有C3*Y的酒。
那么最终，小瓶子和中瓶子剩余的酒显然就是 C2*X - C3*Y
因此，泊松分酒问题实质上转化为下面的不定方程是否有正整数解的问题：
C2*X - C3*Y = R

如果存在X和Y，使得下面的方程有解：
C2*X - C3*Y = 1
实质上就是说能够倒出1品脱的酒，那么任意品脱的酒都能倒出了。
因为:
(C2*X - C3*Y)*N = N
*/
public class PoissonWine {
	private int b1,b2,b3,m,count=0;
	public PoissonWine(int b1,int b2,int b3,int m) {
		this.b1=b1;
		this.b2=b2;
		this.b3=b3;
		this.m=m;
	}
	  //递归结束条件，假设超过1000次则视为不可能或遇到目标酒量是停止递归。
	public void distributeWine(int cur1,int cur2,int cur3) {
		System.out.println(cur1+"---"+cur2+"---"+cur3);
		count++;
		if(cur1==this.m || cur2==this.m || cur3==this.m || this.count>10000) {
			if(this.count>10000) {
				System.out.println("fail to distribute the wine");
				return;
			}
			System.out.println("success to distribute the wine");
			return;
		}
		
		if(cur2 != 0 && cur3 != b3) {//中瓶子不为空，且小瓶子未满,这时要把中瓶子内的酒倒入小瓶子
			if(cur2+cur3<=b3) {
				distributeWine(cur1,0,cur2+cur3);
			}else {
				distributeWine(cur1,cur2+cur3-b3,b3);
			}
		}else if(cur3==b3) {//小瓶子已满,这时要把小瓶子内的酒倒入大瓶子
			if(cur1+cur3<=b1) {
				distributeWine(cur1+cur3,cur2,0);
			}else {
				distributeWine(b1,cur2,cur1+cur3-b1);
			}
		}else if(cur2 == 0) {//中瓶子为空，这时要把大瓶子内的酒倒入中瓶子
			if(cur1 >= b2) {
				distributeWine(cur1-b2,b2,cur3);
			}else {
				distributeWine(0,cur1,cur3);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		PoissonWine pw=new PoissonWine(12, 8, 5, 6);
		pw.distributeWine(12, 0, 0);
	}
}
