package day03;
/**
 * 
 * ��̬����:
 * 1)��static ����
 * 2)������,�洢�ڷ�����,ֻ��һ��
 * 3)ͨ��ͨ������������
 * 4)��ʱ��?���ж��������������(ͼƬ,��Ƶ,��Ƶ��)
 * 
 * 
 * ��̬����,��̬�� ���콲
 *
 * @author Lenovo
 *
 */
public class DemoStatic {
	int a=1;//��Ա����
	static int b=1;//��̬����
	public DemoStatic(){
		a++;
		b++;
	}
	
	public void show(){
		System.out.println("a="+this.a);
		System.out.println("b="+DemoStatic.b);
	}
	
	public static void main(String[] args) {
		
		System.out.println(DemoStatic.b);
		//System.out.println(DemoStatic.a);//��Ϊa�ǳ�Ա�����ڶ���,����ʵ������ſ��Է���
		
		DemoStatic demo=new DemoStatic();
		demo.show();
		
		DemoStatic demo2=new DemoStatic();
		demo2.show();
		
		DemoStatic demo3=new DemoStatic();
		demo3.show();
		
		
	}
}
