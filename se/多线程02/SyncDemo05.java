package day10;
/**
 * 死锁现象：
 * 线程都是保持着自己的锁，但是都在等待对象来释放锁，
 * 就出现了互相“僵持”的状况，导致程序不会继续再继续向后运行
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
			System.out.println(name+"synA正在运行");
			Thread.sleep(5000);
			System.out.println(name+"synA运行结束");
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
				System.out.println(name+"synB正在运行");
				Thread.sleep(5000);
				System.out.println(name+"synB运行结束");
				method01();
			     } catch (InterruptedException e) {
			        	e.printStackTrace();
			 }
		}
	}
}
