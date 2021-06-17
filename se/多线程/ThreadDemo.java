package day09;
/**
 * 并发原理：
 * 多线程：多线程允许我们“同时”执行多段代码
 * 线程是并发运行的，线程调度会统一规划CPU时间，将CPU的时间划分为
 *诺干片段，然后尽可能的均匀分配给所要并发运行的线程，每个线程在获取CPU
 *时间片段后CPU就来运行它的任务，当时间片段用完后，CPU会离开并执行获取到CPU时间片的线程，
 *所以所有线程并非真正的“同时”运行这代码，而是走走停停，在宏观上感觉是同时运行的现象称为“并发运行”
 *
 *
 *线程：Thread
 *线程提供了两种创建方式：
 *方式一：继承Thread并重写run方法来定义线程任务
 * @author 24742
 *
 */
public class ThreadDemo {
   public static void main(String[] args) {
	Thread t1=new MyThread1();
	Thread t2=new MyThread2();
	/*
	 * 启动线程不是调用run()方法，而是要调用start()方法，
	 * 线程开始并发运行时会自动调用run()方法
	 * 
	 */
	t1.start();
	t2.start();
	/*
	 * 第一种创建线程的方式有两个不足
	 * 1.由于java是单继承，这就导致若继承了Thread就不能继承其他类，
	 * 在实际开发中非常不方便，因为无法重用其他类的某些方法
	 * 2.由于继承Thread重写run()方法定义了线程要执行的任务，这就导致线程与线程执行的任务有一个必然
	 * 的耦合关系，不利于线程重用
	 */
   }
}
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("你好，可以加个联系方式嘛！");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int j=0;j<100;j++){
		System.out.println("你谁啊!FUCK OFF");
		}
	}
}