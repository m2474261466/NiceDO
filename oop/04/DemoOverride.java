package day03;
/**
 * �ص�:
 * ��������д(override):����д,����
 * 1.�����ڸ�������,����������ͬ,�����б���ͬ,���Ƿ����岻ͬ
 * 2.��д����������ʱ,�����������,�ܵ��������������
 * 3.��дҪ��ѭ"��ͬ��Сһ��"ԭ��:
 *  3.1):��ͬ:
 * 		3.1.1):��������ͬ
 * 		3.1.2):�����б���ͬ
 *  3.2):��С:
 *  	3.2.1):voidʱ,�������
 *  	3.2.2):��������ʱ,�������
 *  	3.2.3):��������ʱ,С�ڻ���ڳ���(���෵�����ͱ���С�ڻ���ڳ��������)������
 *  	3.2.4):���������׳����쳣С�ڻ���ڳ�����쳣(API��)
 *  3.3)һ��:
 *  	������ķ����ķ���Ȩ�޴��ڻ���ڳ����Ȩ��.
 * .....
 * 
 * @author Lenovo
 *
 */
public class DemoOverride {
	public void test(){
		System.out.println("�����е�test()����");
	}
	
	public int test2(){
		System.out.println("�����е�test2()����");
		return 0;
	}
	
	public DemoOverride test3(){
		System.out.println("�����е�test3()����");
		return new DemoOverride();
	}
	
	protected void test4(){
		System.out.println("�����е�test4()����");
	}
}
