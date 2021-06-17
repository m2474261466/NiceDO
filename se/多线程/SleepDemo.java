package day09;
/**
 * 睡眠阻塞状态：
 * static void sleep(long ms)
 * 当一个线程执行sleep方法后就会进入阻塞状态指定的毫秒数
 * 超时后线程会自动回到Runnable就绪状态等待再次并发运行，该方法要求必须处理InterruptedException
 * s睡眠阻塞状态时被其他线程调用interrupted方法中断时会抛出该异常并打断睡眠阻塞状态
 * 
 * interrupt()方法用于中断线程，但是若线程处于阻塞状态时中断阻塞，
 * 若线程没有处于阻塞状态则线程直接被中断
 * 
 * @author 24742
 *
 */
public class SleepDemo {
      public static void main(String[] args) {
    	  Thread qiang=new Thread(){
  			public void run(){
  				System.out.println("强哥：睡觉了");
  				try {
  					Thread.sleep(10000);
  					System.out.println("我醒了");
  				} catch (InterruptedException e) {
  					e.printStackTrace();
  					System.out.println("强哥：woc,墙塌了");
  				}
  			}
  		};
		Thread chao=new Thread(){
			public void run(){
		    System.out.println("刘永超：我开始砸墙了");
		     for(int i=0;i<5;i++){
		    	 System.out.println("刘永超：80···············");
		    	 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		     }
		     System.out.println("duang");
		     qiang.interrupt();
			}
		};
		
		//启动线程
		chao.start();
		qiang.start();
		
	}
}
