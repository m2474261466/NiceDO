package day06;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * һ������n�Ľ׳˿���д��n!������ʾ��1��n��n�������ĳ˻���
 * �׳˵������ٶȷǳ��죬���磬13�����Ѿ��Ƚϴ��ˣ�
 * �Ѿ��޷������һ�����ͱ����У���35���͸����ˣ����Ѿ��޷������һ�������ͱ����С�
 * ��ˣ���n�Ƚϴ�ʱ��ȥ����n!�Ƿǳ����ѵġ�
 * ���˵��ǣ��ڱ����У����ǵ�������ȥ����n!������ȥ����n!���ұߵ��Ǹ���0�������Ƕ��١�
 * ���磬5��=1*2*3*4*5=120�����5!���ұߵ��Ǹ���0��������2��
 * ���磬7��=5040�����7�����ұߵ��Ǹ���0��������4��
 * ���磬15��= 1307674368000�����15�����ұߵ��Ǹ���0��������8��
 * ���дһ����������һ������n(0<n<=100)��Ȼ�����n!���ұߵ��Ǹ���0�������Ƕ��١�
 * @author Lenovo
 *
 */
public class ArrayDemo01 {

	public static void main(String[] args) {
		/*
		 *	   ���:   01234
		 * String str="asdfg";
		 * �ַ�����.length():��ʾһ������,���ַ����ĳ���,��:int n=str.length();//����Ϊ5
		 * �ַ�����.charAt(�ַ����±�):
		 * �ַ����������Ϊ��һ���������ַ������������һ���ַ���
		 * ��ʾһ������,���ַ�����ĳһ���ַ�,��:char s=str.charAt(2);//�ַ�Ϊd
		 */
		Scanner scanner=new Scanner(System.in);
		System.out.println("������һ�������㲢��С�ڵ���100��������:");
		int n=scanner.nextInt();
		//��n�Ľ׳�
		/*long s=1;
		for(int i=1;i<=n;i++){
			s*=i;
		}
		System.out.println(s);
		//��long����ת��Ϊ�ַ���
		String str=s+"";
		for(int i=str.length()-1;i>=0;i--){
			if(str.charAt(i)!='0'){
				System.out.println(str.charAt(i));
				break;
			}
		}*/
		
		/*
		 * BigDecimal;
		 * �����Գ���16λ��Чλ�������о�ȷ������.
		 * ˫���ȸ����ͱ���double���Դ���16λ��Ч��.
		 * ��ʵ��Ӧ����,��Ҫ�Ը�����߸�С������������ʹ���.
		 * BigDecimal���ֳ�������������ʱ,ֻ�ܵ������BigDecimal���еķ���
		 */
		BigDecimal a=new BigDecimal(1);
		for(int i=1;i<=n;i++){
			a=a.multiply(new BigDecimal(i));
		}
		System.out.println(a);
		String str=a+"";
		for(int i=str.length()-1;i>=0;i--){
			if(str.charAt(i)!='0'){
				System.out.println(str.charAt(i));
				break;
			}
		}
		
	}
}
