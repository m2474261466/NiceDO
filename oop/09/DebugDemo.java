package day09;
/**
 * ��ʾDebug����
 * @author Lenovo
 * ����������н��������Ԥ�ڵĽ����ͬʱ:
 * 1.��׮: System.out.println(����);
 * 2.Debug���Թ���
 * 2.1 ��Ӷϵ�
 * 2.2 ����4����
 * 		1. F5:��������(����뵽������)
 * 		2. F6:�𲽹��̵���(������뵽������,���Ƿ��������жϵ㻹�ǻ����е��öϵ㴦)
 * 		3. F7:���������ĵ���
 * 		4. F8:ֱ��������һ���ϵ�(������û�жϵ����������)
 * �ῴ��������:
 * 1.�ῴ����
 * 2.����Ӽ���(ѡ�б��ʽ,�Ҽ�Watch-->Variables)
 */
public class DebugDemo {
	public static void main(String[] args) {
		int a=5;
		test(a);
		show();
	}

	private static void show() {
		System.out.println("aaa");
		System.out.println("bbb");
	}

	private static void test(int a) {
		int b=a+10;
		if(b>15){
			System.out.println("b");
		}
	}
	
	
}
