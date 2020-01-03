package codingInterview;

public class StrSum {
	public static int numSum(String str){
		if(str==null){
			return 0;
		}
		char[] ch=str.toCharArray();
		int res=0,num=0,cur=0;
		boolean posi=true;
		for (int i = 0; i < ch.length; i++) {
			//ch[i]-'0'得到的int值小于0或者大于9，则说明位置i处的字符不是数字字符。
			cur=ch[i]-'0';
			if(cur<0 || cur>9){
				//当ch[i]为非数字字符时，计算目前的累加值
				res+=num;
				//ch[i]为非数字字符时，num重置为0；
				num=0;
				//判断紧贴数字字符左侧的'-'的个数，为奇数这posi为false，偶数则为true；
				if(ch[i]=='-'){
					if(i-1>=0 && ch[i-1]=='-'){
						posi=!posi;
					}else{
						posi=false;
					}
				}else{
					posi=true;
				}
			}else{
				//
				num=num*10+(posi ? cur : -cur);
			}
		}
		res+=num;
		return res;
	}
	
	public static int demo(String str) {
		// TODO Auto-generated method stub
		if(str==null){
			return 0;
		}
		char[] ch=str.toCharArray();
		int res=0,num=0,cur=0;
		boolean posi=true;
		for (int i = 0; i < ch.length; i++) {
			cur=ch[i]-'0';
			if(cur<0 || cur >9){
				res+=num;
				num=0;
				if(ch[i]=='-'){
					if(i-1>=0 && ch[i-1]=='-'){
						posi=!posi;
					}else{
						posi=false;
					}
				}else{
					posi=true;
				}
			}else{
				num=num*10+(posi ? cur : -cur);
			}
		}
		res+=num;
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(numSum("a-1b--2c--d6e"));
		System.out.println(demo("a-1b--2c--d6e"));
	}
}
