package day10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：
 * 线程池主要完成工作：
 * 1.管理多线程数量，由于每个线程会占用一定的内存，线程数量过多会导致内存占用太大，
 * 还有个问题就是CPU过度切换会导致程序出现卡顿
 * 2.重用线程
 * @author 24742
 *
 */
public class threadPool {
   public static void main(String[] args) {
	  //创建线程池
	   ExecutorService pool=Executors.newFixedThreadPool(3);//创建线程池，池内的数量为3
	   for(int i=0;i<10;i++){
		   //10个任务
		   Runnable runn=new Runnable(){
			   public void run(){
				   try {
					String name=Thread.currentThread().getName();
					System.out.println(name+"正在运行任务……");   
					Thread.sleep(3000);//线程等待3000毫秒
				} catch (InterruptedException e) {//异常捕获
					e.printStackTrace();
				   }
			   }
		   };
		   //将任务指定给线程池
		   pool.execute(runn);
	   }
	   /*
	    * shutdown()与shutdownNow()都是线程池停止状态
	    * shutdown()方法调用后，线程池不再接受新任务，会将已经有的任务全部执行后在停止
	    * shutdownNow()调用后，线程池会调用所有线程的中断方法后立即停止
	    */
	   pool.shutdown();
    } 
} 
