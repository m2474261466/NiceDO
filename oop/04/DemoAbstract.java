package day03;
/**
 * ���󷽷���ʾ:
 * 1.��abstract����
 * 2.ֻ�г��󷽷��Ķ���,û�о����ʵ��(��{}Ҳû��)
 *  ������:
 *  1)��abstract����
 *  2)�������󷽷���������ǳ�����,���������󷽷�����Ҳ��������Ϊ������(��ʵ��)
 *  3)�������ǲ��ܱ�ʵ������
 *  4)����������Ҫ���̳е�,������:������д�������е����г��󷽷�,�䲻����Ϊ����
 *  �����������:
 *  	1.��װ���������е����Ժ���Ϊ(���븴��)
 *  	2.Ϊ�����������ṩͳһ������----��������
 *  	3.���԰������󷽷�,Ϊ�����������ṩͳһ�����,���������Ϊ��һ��,���������һ�µ�.
 * @author Lenovo
 *
 */
public abstract class DemoAbstract {
	
	public abstract void test();//���󷽷�(��������һ������)
	
	public abstract void test2();

	public static void main(String[] args) {
		//DemoAbstract d=new DemoAbstract();//�������,�����಻�ܱ�ʵ����
		//DemoAbstract a=new AOO();
		//a.test();
		
	}

}

class AOO extends DemoAbstract{
	//������д�����еĳ��󷽷�,�䲻����Ϊ����
	public void test(){
		System.out.println("������д�����еĳ��󷽷�");
	}
	
	public void test2(){
		
	}
	
	
}