package day10;

/*
 * ��������
 * �̶߳��Ǳ������Լ����������Ƕ��ǵȴ��Է����ͷ�����
 * �ͳ��ֻ��ࡱ���֡�����������³��򲻻�����������
 */
public class Syncdemo5 {
	public static void main(String[] args) {
		Poo p=new Poo();
		Thread t1=new Thread(){
			public void run(){
				p.method1();
			}
		};
		
		Thread t2=new Thread(){
			public void run(){
				p.method2();
			}
		};
		t1.start();
		t2.start();
	}
}


class Poo{
	Object A=new Object();
	Object B=new Object();
	
	public void method1(){
		String name=Thread.currentThread().getName();
		synchronized (A) {
			try {
				System.out.println(name+"A�������С�����");
				Thread.sleep(3000);
				System.out.println(name+"A�������");
				method2();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void method2(){
		String name=Thread.currentThread().getName();
		synchronized (B) {
			try {
				System.out.println(name+"B�������С�����");
				Thread.sleep(3000);
				System.out.println(name+"B�������");
				method1();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}