package day02;
/**
 * ���ʿ������δ�
 * privateֻ�����ڱ��಻���ǳ�Ա�������Ƿ���
 * protected:�ܱ���,����,����,ͬ����;
 * public:������,�������κ���(���ܿ���Ŀʹ��)
 * @author Lenovo
 *
 */
public class Student01 {
	//���day01.Test02�࿴
	private int password=567;
	String name="����";
	public int age=18;
	protected int num=123;//ѧ��
	//year������day01.Test02����
	public int year=2020;
	
	private void test(){
		System.out.println(password);
	}
	
	protected void test01(){
		test();
		System.out.println("����test01����");
	}
}
