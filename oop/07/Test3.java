package day07;
/**
 * �ӿڲ��ܱ�ʵ����
 * @author Lenovo
 *
 */
public class Test3 {
	public static void main(String[] args) {
		//DemoInterfaceLoad d=new DemoInterfaceLoad();//�ӿڲ��ܱ�ʵ����
		
		DemoInterfaceLoad d=new TOO();//�ӿ�ָ��ʵ�ֵĶ���(��������)
		d.load();
		
		//�������ڲ�����ʵ�ֽӿ��е����з���
		DemoInterfaceLoad dd=new DemoInterfaceLoad() {
			public void load() {
				System.out.println("���������ڲ�������д�ӿ��е�load()����");
			}
		};
		dd.load();
	}
}

class TOO implements DemoInterfaceLoad {
	public void load(){
		System.out.println("��д��DemoInterfaceLoad�е�load()����");
	}
}