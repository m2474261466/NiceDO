package day04;
/**
 * ������Ϊ��9��99��999��...��9999999999��
 * Ҫ��ʹ�ó����������еĺ�
 * ��һ�ַ���:
 * 0*10		+9;
 * 9*10		+9;
 * 99*10	+9;
 * 999*10	+9;
 * ...
 * long s=0;
 * s=s*10+9;
 * @author Lenovo
 *10^-1=9;
 *10^2-=99;
 *...
 *
 */
public class HomeWork09 {
	public static void main(String[] args) {
		//����һ:
		long sum=0;//�ܺ�
		/*long s=0;
		for(int i=0;i<10;i++){
			s=s*10+9;
			sum=sum+s;
		}
		System.out.println("������Ϊ��9��99��999��...��9999999999="+sum);*/
		//������:
		/*for(int i=1;i<=10;i++){
			//Math.pow(a,b)��������a��b�η�,a��b�Լ�����������double����
			sum+=(long)Math.pow(10,i)-1;
		}
		System.out.println("������Ϊ��9��99��999��...��9999999999="+sum);*/
	}
}
