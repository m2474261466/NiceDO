package day10;
/**
 * 所谓的主线程也就是执行main方法的线程
 * ，先执行主线程，再执行普通线程
 * @author 24742
 *
 */
public class MainThread {
    public static void main(String[] args) {
		System.out.println("执行开始了");
		//主线程的名字
		System.out.println("主线程名："+Thread.currentThread().getName());
	   for(int i=0;i<100;i++){
		   System.out.println(i);
	   }
	   Thread t=new Thread(){
		   public void run(){
			   System.out.println("自定义线程："+Thread.currentThread().getName());
		      for(int i=0;i<100;i++){
		    	  System.out.println("哈喽");
		      }
		   }
	   };
	   t.start();
    }
} 
