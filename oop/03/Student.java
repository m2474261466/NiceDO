package day02;
/**
 * ������ǩ��:������+�����б�
 * ����������
 * 1.������ͬһ������,��������ͬ,�����б����ͺ�������ͬ
 * 2.���������غͷ���ֵ����û���κι�ϵ
 * 3.�������ڱ���ʱ���ݷ�����ǩ���Զ��󶨲����÷���;
 * @author Lenovo
 *
 */
public class Student {
	int age;
	String name;
	String address;
	
	public Student(){//�޲ι��췽��
		//System.out.println("�޲ι��췽��");
	}
	
	public Student(String name){//�вι��췽��
		//System.out.println("����Ϊname���вι��췽��");
	}
	
	public Student(int age,String address){//�вι��췽��
		this.age=age;
		this.address=address;
		//System.out.println("����Ϊage��address���вι��췽��");
	}
	
	public void test(){//������ǩ��:test()
		System.out.println("test()�޲η���");
	}
	
	public void test(String name){
		System.out.println("�ҵ�������:"+name);
	}
	
	//�������,�ⲻ�Ƿ���������,��Ϊ�������������б����ͺ���������ͬ,����������1
	/*public void test(String adderss){
		System.out.println("�ҵĵ�ַ��:"+address);
	}*/
	
	public void test(String name, String address){
		System.out.println("�ҵ�������:"+name+",��ַ��:"+address);
	}
	
	//�������,���������غͷ���ֵ����û���κι�ϵ,�ⲻ�Ƿ���������
	/*public int test(){
		System.out.println("���з���ֵ���͵ķ���");
		return 6;
	}*/
	
	public static void main(String[] args) {
		Student s=new Student();
		/*s.test();
		s.test("����");
		s.test("����","�濵��");*/
	}
	
	
	
	
	
}
