package day07;
/**
 * 1.ʵ�ֽӿ��ùؼ���implements������д�ӿ��е����з���
 * 2.�ӿ��ֲ��˼̳еĵ�һ��,����ʵ�ֶ���ӿڲ��Զ��Ÿ���
 * @author Lenovo
 *
 */
public class AAA implements DemoInterfaceLoad,DemoInterfaceLoad2 {
	public void load(){
		System.out.println("��ȡ����AAA��U������");
	}
	
	public int load2(){
		return 2;
	}
	
	public static void main(String[] args) {
		DemoInterfaceLoad a=new AAA();//�ӿ�ָ������ʵ����(��������)
		a.load();
		System.out.println();
		DemoInterfaceLoad b=new BBB();//�ӿ�ָ������ʵ����(��������)
		b.load();
	}
	
}

class BBB implements DemoInterfaceLoad {
	public void load(){
		System.out.println("��ȡ����BBB��U������");
	}
}