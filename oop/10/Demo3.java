package test;
/**
 * ����������:
 * 1.������ͬһ������,��������ͬ,�����б����ͺ�������ͬ
   2.�ͷ���ֵ���޹�ϵ
   3.�������ڱ���ʱ���ݷ�����ǩ��(������+�����б�)�Զ��󶨵��õķ���
 * @author Lenovo
 *
 */
public class Demo3 {
	int age;
	String name;
	//���췽��
	public Demo3(){
		
	}
	public Demo3(String name){
		
	}
	public Demo3(String name,int age){
		
	}
	
	public int test(String name){
		System.out.println("�в�");
		return  1;
		
	}
	
	public int test(int age){
		System.out.println("�в�");
		return  1;
		
	}
	
	public void test(){
		System.out.println("�޲�");
	}
	
	public static void main(String[] args) {
		Demo3 d=new Demo3();
		d.test("��");
		d.test(18);
	}	
	
	
	
}
