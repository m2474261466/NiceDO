package day04;
/**
 * ��̬����:
 * 	1.��static����
 * 	2.������,�洢�ڷ�����,ֻ�н���һ��
 *  3.����ͨ�������㾲̬����ȥ����
 *  4.��̬����û����ʽthis����,�����ھ�̬�����в���ֱ�ӷ���ʵ����Ա(��Ա����)
 *  ע��:�ڱ����з��ʾ�̬�������߾�̬��������ʡ������,���������������������ȥ����
 *  ��̬�������߾�̬����
 * ��ʱ��:�����Ĳ������ڲ������������޹�
 * 
 * @author ����
 *
 */
public class DemoStaticMethod {
	
	int a;//��Ա����
	static int b;//��̬����
	
	public void show(){
		System.out.println(this.a);
		System.out.println(DemoStaticMethod.b);
	}
	
	public static void show2(){
		/*
		 * ��̬����û����ʽthis����,û��this����ζ��û�ж���,
		 * ��ʵ������a����ͨ����������,���Ծ�̬�����в���ֱ�ӷ���ʵ����Ա(��Ա����)
		 */
		//System.out.println(a);;
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		DemoStaticMethod d=new DemoStaticMethod();
		d.show();
		show2();
	}
		
}

class AOO{
	public void test(){
		System.out.println(DemoStaticMethod.b);
		DemoStaticMethod.show2();
	}
}
