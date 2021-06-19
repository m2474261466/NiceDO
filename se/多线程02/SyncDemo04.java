package day10;
/**
 * ������
 * ʹ��synchronized������˴��룬�����Ķ�����ͬʱ����Щ����Ƭ��֮����ǻ�������
 * ����̲߳���ͬʱִ����Щ����
 * @author 24742
 *
 */
public class SyncDemo04 {
       public static void main(String[] args) {
		Eoo e=new Eoo();
		Thread t1=new Thread(){
			public void run(){
				e.test01();
			}
		};
		Thread t2=new Thread(){
			public void run(){
				e.test02();
			}
		};
		t1.start();
		t2.start();
	}
}
class Eoo{
	public synchronized void test01(){
		try {
			String name=Thread.currentThread().getName();
			System.out.println(name+"��������test01����");
			Thread.sleep(5000);
			System.out.println(name+"��������test01�������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public synchronized void test02(){
		try {
			String name=Thread.currentThread().getName();
			System.out.println(name+"��������test02����");
			Thread.sleep(5000);
			System.out.println(name+"��������test02�������");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
