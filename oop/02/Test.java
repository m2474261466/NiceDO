package day01;
/**
 * �ֲ������ͳ�Ա����(�ֳ�ȫ�ֱ���)(�ص�)
 * @author Lenovo
 *
 */
public class Test {
	int a;//��Ա��������Ĭ��ֵ
	static int c;
	public void demo(){
		int b;
		System.out.println(a);
		a=10;
		//System.out.println(b);//�������,�ֲ����������������ҳ�ʼ��
		System.out.println(a);
	}
	
	public static void demo02(){
		System.out.println(c);
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		t.demo();
		Test t02=new Test();
		t02.demo02();
	}
	
}
