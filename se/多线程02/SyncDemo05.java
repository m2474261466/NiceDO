package day10;
/**
 * ��������
 * �̶߳��Ǳ������Լ����������Ƕ��ڵȴ��������ͷ�����
 * �ͳ����˻��ࡰ���֡���״�������³��򲻻�����ټ����������
 * @author 24742
 *
 */
public class SyncDemo05 {
   public static void main(String[] args) {
	   Coo c=new Coo();
		Thread t1=new Thread(){
			public void run(){
				c.method01();
			}
		};
		Thread t2=new Thread(){
			public void run(){
				c.method02();
			}
		};
		t1.start();
		t2.start();
  }
}

class Coo{
	Object synA=new Object();
	Object synB=new Object();
	public void method01(){
	String name=Thread.currentThread().getName();
	synchronized (synA) {
		
		try {
			System.out.println(name+"synA��������");
			Thread.sleep(5000);
			System.out.println(name+"synA���н���");
			method02();
		} catch (InterruptedException e) {
			e.printStackTrace();
		 }
	   }
	}
	public void method02() {
		String name=Thread.currentThread().getName();
		synchronized (synB) {
			
			try {
				System.out.println(name+"synB��������");
				Thread.sleep(5000);
				System.out.println(name+"synB���н���");
				method01();
			     } catch (InterruptedException e) {
			        	e.printStackTrace();
			 }
		}
	}
}
