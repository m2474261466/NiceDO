package test;
/**
 *  �̳�(extends)
	1.��������(����)������(������)��;
		1):����������Ĺ������Ժ���Ϊ
		2):������̳г������е����Ժ���Ϊ:����+������,������ע�������������Ժ���Ϊ��˽�л�,��		   �������ڼ̳�
	2:һ����������ж��������,һ��������ֻ����һ������
	3:����(�ô�):����ĸ���,���ٴ�����ظ�
	����������̳г���Ĺ��췽��?(�ؼ���super())
	 1.��super()���̳г���Ĺ��췽��,����д�������๹�췽���еĵ�һ��(ָ����ǰ����ĳ������)
	 2.�����������û�е��ó���Ĺ��췽��,��Ĭ��super()�����ó�����޲ι��췽��,��������˳���
       �Ĺ��췽��,����Ĭ���ṩ
 * @author Lenovo
 *
 */
public class Demo5 {
	public String name;
	public int age;
	
	public Demo5(String name){
		System.out.println("Demo5�Ĺ��췽��");
	}
	
	public void test(){
		System.out.println(name);
	}
	
}

class A00 extends Demo5{
	public A00(){
		super("��");
		System.out.println("����");
		
	}
}

