package day04;
/**
 * static final:����(Ӧ���ʺܸ�)
 * 1.��������ͬʱ��ʼ��,���������,���ܱ��ı�,���ҿ���ͨ������ֱ�ӷ���
 * 2.����:������������ĸ����д,���������"_"�ָ�
 * 3.�ڱ���ʱ���Զ��滻Ϊ�����ֵ,Ч���ܸ�
 * 4.��ʱ��:һ������Զ����,���ҷ����Ķ��ʹ��
 * @author ����
 *
 */
public class DemoStaticFinal {
	final int age=20;//��Ա����,�ж��ٸ�������ж��ٸ�final int age=20;���ܸı�����ֵ
	static int a=30;//��̬����,ֻ��һ��,���Ըı�������ֵ
	
	public static void main(String[] args) {
		/*
		 * ���ص�BOO.class��������,PIһ���洢�ڷ�������,���������л�ȡPI��ֵ�����
		 * �������ڱ���ʱ������ֱ���滻Ϊ�����ֵ,����Ч�ʺܸ�
		 * System.out.println(BOO.PI);�൱��System.out.println(3.1415926);
		 */
		System.out.println(3.1415926);
		System.out.println(BOO.PI);
		//BOO.PI=45.68;//�������,ԭ���ǳ������ܱ��ı�
		
		System.out.println(BOO.USER_AGE);
	}
	
	public void test(){
		System.out.println(age);
	}
	
}

class BOO{
	public static final double PI=3.1415926;//����,�����дpublic���δ�,ϵͳ���Զ����public
	public static final int USER_AGE=18;
	
}