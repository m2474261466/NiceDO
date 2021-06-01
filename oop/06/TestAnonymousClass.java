package day05;

public class TestAnonymousClass {
	
	public void test(){
		/*class DOO extends AOO{
			public void dream(){
				System.out.println("�̳�AOO��4");
			}
		}*/
		
		//��ʾ�����ڲ���,һ������ľֲ��ڲ���
		AOO a=new AOO(){
			public void dream(){
				System.out.println("�̳�AOO��4");
			}
		};
		a.dream();
	}
	
	public static void main(String[] args) {
		TestAnonymousClass t=new TestAnonymousClass();
		t.test();
		
		/*AOO b=new BOO();
		b.dream();
		
		AOO b1=new COO();
		b1.dream();
		
		//�����ڲ����﷨:new ����(){};
		AOO a=new AOO(){
			public void dream(){
				System.out.println("�̳�AOO��3");
			}
		};
		a.dream();*/
	}
	
	
	
}

abstract class AOO{
	public abstract void dream();
}

class BOO extends AOO{
	public void dream(){
		System.out.println("�̳�AAO��1");
	}
	
}

class COO extends AOO {
	public void dream(){
		System.out.println("�̳�AOO��2");
	}
}