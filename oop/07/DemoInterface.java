package day07;
/**
 * �ӿ���ʾ:
 * ʲô�ǽӿ�:�ӿھ���һ�ֱ�׼��һ�ֹ淶
 * �ӿڹؼ��� interface
 * �ӿ���ֻ�ܰ������󷽷��ͳ���,���ҽӿ��е����з���(���󷽷�)��ʵ������
 * ����Ҫ��д
 * ���δʱ���Ϊpublic
 * @author Lenovo
 *
 */
public interface DemoInterface {
	//private int age=18;//������� �ӿ���ֻ�ܰ������󷽷��ͳ���
	/*public void test(){//������� �ӿ���ֻ�ܰ������󷽷��ͳ���
		
	}*/
	
	public static final String NAME="java";//����
	public static final int AGE=18;//����
	public abstract void test();//���󷽷�(���ᳫ����д)
	
	//���󷽷��е�ǰ������δ�public abstract����ʡ��,Java��Ĭ���ṩ
	void test2();
	int test3();
	//���󷽷��е�ǰ������δ�abstract����ʡ��,Java��Ĭ���ṩ
	public void test4();
	public int test5();
	
	/*public void test6(){//�������,�ڽӿ��в����з�����
		
	}*/
	
	
}
