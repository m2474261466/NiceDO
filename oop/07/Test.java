package day07;
/**
 * һ�������ʵ�ֶ���ӿ�,�����ö��Ÿ���,���м̳�Ҳ��ʵ��ʱ,
 * Ӧ�� �ȼ̳� ��ʵ��
 * @author Lenovo
 *
 */
public class Test extends Test2 implements DemoInterface2 {
	public void test2(){
		System.out.println("test2()����");
	}
	
	public void test3(){
		System.out.println("test3()����");
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		t.tt();
	}
	
}
