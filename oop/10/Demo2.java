package test;
/**
 * 
 * ��Ա����(ȫ������)�;ֲ���������
 * 1.��Ա������Ĭ��ֵ,�ֲ���������������ʼ��(���ڷ�����)
   2.���ȼ�:��Ա�����;ֲ�����ͬ��ʱ,�ֲ��������������ȼ�(�ͽ�ԭ��)
 * 
 * 3.�������ڲ�һ��.....
 * 
 */
public class Demo2 {
	//��Ա����
	int age;// Ĭ�� 0
	String name;//Ĭ�� null
	
	public void test(){
		//�ڷ����������ı�������ʱ�ֲ�����(������������ʼ��)
		String address="����";
		int age=20;
		System.out.println(age);
		System.out.println(address);
	}
	
	public static void main(String[] args) {
		Demo t=new Demo("3",12);
		Demo2 d=new Demo2();
		d.test();
		
	}
}
