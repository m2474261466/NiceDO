package day07;
/**
 * ��λ��872
 * ��:��λ,ʮλ,��λ��ֵ�ֱ��Ƕ���?
 * @author Lenovo
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		int a=872;
		//1.��λ
		int b=a/100;
		//2.��λ
		int g=a%10;
		//3.ʮλ
		int s=a%100/10;
		System.out.println("��λ:"+g+" ʮλ:"+s+" ��λ:"+b);
	}
}
