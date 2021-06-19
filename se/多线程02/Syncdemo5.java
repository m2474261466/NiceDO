package day10;

/*
 * 死锁现象：
 * 线程都是保持着自己的锁，但是都是等待对方来释放锁，
 * 就出现互相”僵持“的情况，导致程序不会继续向后运行
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
				System.out.println(name+"A正在运行。。。");
				Thread.sleep(3000);
				System.out.println(name+"A运行完毕");
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
				System.out.println(name+"B正在运行。。。");
				Thread.sleep(3000);
				System.out.println(name+"B运行完毕");
				method1();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}