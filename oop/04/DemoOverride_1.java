package day03;

public class DemoOverride_1 extends DemoOverride{
	//��д�����еķ���
	public void test(){
		System.out.println("�����е�test()����");
	}
	
	//����ĵ�������
	public void test1(){
		System.out.println("�����test1()����");
	}
	
	//��������ʱ,�������
	public int test2(){
		System.out.println("�����test2()����");
		return 1;
	}
	
	//
	public DemoOverride_1 test3(){
		System.out.println("�����е�test3()����");
		return new DemoOverride_1();
	}
	
	/*private void test4(){//�������,ԭ��������ķ���Ȩ��С���˸���ķ���Ȩ��
		System.out.println("�����е�test4()����");
	}*/
	
	public void test4(){
		System.out.println("�����е�test4()����");
	}
	
	public static void main(String[] args) {
		/*DemoOverride d1=new DemoOverride();
		d1.test();*/
		
		//��������
		//��������д�ص�:�ܵ����ʲô����������,���÷�������������
		DemoOverride d=new DemoOverride_1();
		d.test();
		d.test2();
		d.test3();
		d.test4();
	}
}
