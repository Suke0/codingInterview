package codingInterview;
//通过位运算求两个数中的最大值
public class GetMaxWithoutOperator {
	//有溢出问题
	public static int getMax(int a, int b) {
		//求出a-b的符号位
		int c=a-b;
		int n=(c>>31) & 1;
		int m=n ^ 1;
		return a*m + b*n;
	}
	//同号没有溢出问题，异号存在溢出问题
	public static int getMax1(int a, int b) {
		//求出a，b的符号位
		int af= a>>31 & 1;
		int raf= af ^ 1;

		int bf= b>>31 & 1;
		int rbf= bf ^ 1;
		
		int f=af ^ bf;
		int rf=f ^ 1;
		
		//求出a-b的符号位
		int c=a-b;
		int cf= c>>31 & 1;
		int rcf=cf ^ 1;
		
		return f*(a*raf+b*rbf)+rf*(a*rcf + b*cf);
	}
	
	public static void main(String[] args) {
		System.out.println(getMax1(-55, 75));
	}
}
