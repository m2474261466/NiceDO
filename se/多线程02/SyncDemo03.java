package day10;
/**
 * ��̬������ʹ����Synchronized���κ���ô�÷���һ������ͬ��Ч��
 * ��̬�����Ķ����ǵ�ǰ��Ķ���
 * Class���ÿһ��ʵ�����ڱ�ʾJVM���ص�һ���࣬��JVM����һ�����ʱ��ͻ�
 * ʵ����һ��Class��ʵ�����ڱ�ʾ����ÿ������JVM�ڲ�������ֻ��һ��Class��ʵ��
 * �����Ծ�̬�������ľ��ǵ�ǰ���Ӧ��Class��ʵ��
 * @author 24742
 *
 */
public class SyncDemo03 {
	public static final int AGE=2;
     public static void main(String[] args) {
		FOO1 Foo1=new FOO1();
		Thread t1=new Thread(){
			public void run(){
				FOO1.dosome();
			}
		};
		Thread t2=new Thread(){
			public void run(){
				FOO1.dosome();
			}
		};
		t1.start();
		t2.start();
	}
}
class FOO1{
	public static void dosome(){
		try {
			String name=Thread.currentThread().getName();
			System.out.println(name+"��������dosome����");
			Thread.sleep(5000);
			System.out.println(name+"����dosome�������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
}
