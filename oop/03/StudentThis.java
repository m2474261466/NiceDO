package day02;
/**
 * this�ؼ���ʹ��
 * 1.this�ؼ����ڷ�������,����ָ����ø÷����ĵ�ǰ����,�򵥵�˵:�ĸ�������÷���,
 * thisֵ�͵����ĸ�����,�ϸ������ڷ�������Ҫͨ��this�ؼ���ָ����ǰ����
 * 2.�ڹ��췽����,������ʼ����Ա�����Ĳ���һ��ͳ�Ա����ȡ��ͬ������,�����������ڴ���Ŀɶ���,
 * ���˴��ͱ���ͨ��this�ؼ��������ֳ�Ա�����Ͳ�����(�����ﲻ��ʡ��this)
 * this���÷�:
 * 1.	this.��Ա����---------���ʳ�Ա����
 * 2.	this.������()---------���õ�ǰ���󷽷�(һ�㲻��)
 * 3.	this()----------------���ù��췽��(�ڹ��췽��֮�����)
 * @author Lenovo
 *
 */
public class StudentThis {
	//��Ա����
	int age;
	String name;
	String address;
	
	public StudentThis(){
		this("null",20,"����");
	}
	
	public StudentThis(String name,int age,String address){//�вι��췽��
		//this.��Ա����=���Ա����ͬ���ı���;
		this.name=name;
		this.age=age;
		this.address=address;
		System.out.println("���óɹ�!"+name+","+age+","+address);
		System.out.println(this);//this�ĵ�ַ
	}
	
	public void test(){
		System.out.println("test()");
		this.test1();//this���õ�ǰ�����test1����
	}
	
	public void test1(){
		System.out.println("test1()");
	}
	
	public static void main(String[] args) {
		StudentThis s=new StudentThis();
		/*
		 * s�ĵ�ֵַ�빹�췽��StudentThis�ĵ�ֵַ��ͬ
		 * ����this�ؼ��ֵĵ�һ��:ͨ���Ǹ�������õķ���,this��ֵ�����Ǹ�����
		 */
		System.out.println(s);//��ֵַ
	}
}
