package day10;
/**
 * 互斥锁
 * 使用synchronized锁定多端代码，而锁的对象相同时，这些代码片段之间就是互斥锁，
 * 多个线程不能同时执行这些方法
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
			System.out.println(name+"正在运行test01方法");
			Thread.sleep(5000);
			System.out.println(name+"正在运行test01方法完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public synchronized void test02(){
		try {
			String name=Thread.currentThread().getName();
			System.out.println(name+"正在运行test02方法");
			Thread.sleep(5000);
			System.out.println(name+"正在运行test02方法完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
