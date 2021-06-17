package day09;
/**
 * 线程提供了static Thread currentThread()
 * 该方法可以获取运行这个方法的线程，java中所有的代码都是线程运行的，main方法也不例外
 * ，JVM启动后会启动一个线程来执行main方法，通常我们称执行main方法的线程为“主线程”
 * @author 24742
 *
 */
public class CurrentThreadDemo {
	       public static void dosome(){
	    	   Thread t=Thread.currentThread();
	    	   //Thread[main,5,main]
               //Thread[线程名称,优先级,线程组]
	    	   System.out.println("运行dosome方法的线程"+t);
	       }
           public static void main(String[] args) {
        	   //获取运行main方法的线程
        	Thread t2=Thread.currentThread();
        	System.out.println("t2的线程为"+t2);
			dosome();
			Thread t3=new Thread(){
				public void run() {
					Thread r=Thread.currentThread();
			    System.out.println("t3的线程为"+r);
				}
			};
			t3.start();
		}
}
