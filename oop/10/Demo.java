package test;
/**
 * * ��ʾ:
 * һ�����п��Դ����������,����Ľṹ��ͬ,���ݲ�ͬ
 * 
 * 
 * 
 * ���Ƕ���ģ��,��������ľ���ʵ��
 * @author Lenovo
 *
 */
public class Demo {
	String name;
	int age;
	//���췽��
	public Demo(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	
	
	
	public static void main(String[] args) {
		Demo d=new Demo("����1",18);
		Demo d2=new Demo("����2",19);
	}
}
