package day03;
/**
 * �ص�:
 * ��ʾ��Ա�����;ֲ��������ڴ�ֲ�������������
 * �ɲο�ykt201911OOP/day03_Leftcycle(�ص�).png��ͼƬ
 * ��Ա�����;ֲ�����
   ��Ա�����;ֲ������Ĳ������:
    �ֲ�����:1.�����ڷ����� 
		     2.û��Ĭ��ֵ,�����Լ��趨��ʼֵ
		     3.����������ʱ,����ջ��,�������ý���,��ջ�����.
	��Ա����:
		     1.����������,������.
		     2.��Ĭ�ϳ�ʼֵ,���Բ��ó�ʼ��
		     3.�����౻ʵ������,���ڶ���,���󱻻���ʱ,��Ա����ʧЧ
 *
 *
 */
public class Test {
	int age=1;//��Ա����
	
	public void show(){
		int age=6;//�ֲ�����
		System.out.println(age);
	}
	
	public void show2(){
		System.out.println(age);
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		t=null;
		//t=new Test2();
		//t.show();
		//t.show2();
	}
	
}
