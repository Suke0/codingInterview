package codingInterview;
//���ɷ־�
/*�־ƹ���

��ƿ��ֻ�ܵ�����ƿ��
��ƿ��ֻ�ܵ���Сƿ��
Сƿ��ֻ�ܵ����ƿ��
Сƿ��ֻ�����Ѿ�װ��������²��ܵ����ƿ��
��Сƿ�ӱ����գ���������ƿ���Ƿ�����Ӧ���ϴ���ƿ�ӵ���Сƿ��

����У�С����ƿ�������ֱ���C1��C2��C3����Ҫ������������R
��ʵ����Ҫ�������ܽ�����ΪR�ľƵ�����ƿ�Ӻ�Сƿ���оͿ��������е�ϻ���
���ƿ�ӵ�����ƿ��X�Σ���Сƿ���е����ƿ��Y�Ρ�
��ô��Ȼ�ɴ�ƿ���۴ε�����ƿ�Ӻ�Сƿ���ܹ�C2*X�ľơ�����Сƿ�ӵ����ƿ��һ����C3*Y�ľơ�
��ô���գ�Сƿ�Ӻ���ƿ��ʣ��ľ���Ȼ���� C2*X - C3*Y
��ˣ����ɷ־�����ʵ����ת��Ϊ����Ĳ��������Ƿ���������������⣺
C2*X - C3*Y = R

�������X��Y��ʹ������ķ����н⣺
C2*X - C3*Y = 1
ʵ���Ͼ���˵�ܹ�����1Ʒ�ѵľƣ���ô����Ʒ�ѵľƶ��ܵ����ˡ�
��Ϊ:
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
	  //�ݹ�������������賬��1000������Ϊ�����ܻ�����Ŀ�������ֹͣ�ݹ顣
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
		
		if(cur2 != 0 && cur3 != b3) {//��ƿ�Ӳ�Ϊ�գ���Сƿ��δ��,��ʱҪ����ƿ���ڵľƵ���Сƿ��
			if(cur2+cur3<=b3) {
				distributeWine(cur1,0,cur2+cur3);
			}else {
				distributeWine(cur1,cur2+cur3-b3,b3);
			}
		}else if(cur3==b3) {//Сƿ������,��ʱҪ��Сƿ���ڵľƵ����ƿ��
			if(cur1+cur3<=b1) {
				distributeWine(cur1+cur3,cur2,0);
			}else {
				distributeWine(b1,cur2,cur1+cur3-b1);
			}
		}else if(cur2 == 0) {//��ƿ��Ϊ�գ���ʱҪ�Ѵ�ƿ���ڵľƵ�����ƿ��
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
