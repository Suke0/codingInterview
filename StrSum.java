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
			//ch[i]-'0'�õ���intֵС��0���ߴ���9����˵��λ��i�����ַ����������ַ���
			cur=ch[i]-'0';
			if(cur<0 || cur>9){
				//��ch[i]Ϊ�������ַ�ʱ������Ŀǰ���ۼ�ֵ
				res+=num;
				//ch[i]Ϊ�������ַ�ʱ��num����Ϊ0��
				num=0;
				//�жϽ��������ַ�����'-'�ĸ�����Ϊ������posiΪfalse��ż����Ϊtrue��
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
