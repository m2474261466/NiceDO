package day09;
/**
 * 线程的优先级：
 * 线程调用start()方法后纳入线程调度统一管理，线程不能主动获取CPU时间片段，只能被动分配，
 * 调整优先级可最大程度的改善某个线程获取CPU时间片段的概率，
 * 理论上线程优先级越高的线程获取CPU时间片段的次数越多
 * 
 * 
 * 
 * 线程优先级10个等级（1-10）
 * 1表示优先级最低
 * 5表示默认
 * 10表示优先级最高
 * 
 * 
 * 
 * 设置线程优先级方法setPriority(int p),
 * 线程提供了3个常量分别表示最低，最高，默认
 * @author 24742
 *
 */
public class PriorityDemo {
    public static void main(String[] args) {
		Thread t1=new Thread(){
		public void run(){
			for(int i=0;i<1000;i++){
				System.out.println("max");
			}
		 }
		};
		
		Thread t2=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("默认");
				}
			}
		};
		
		Thread t3=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("min");
				}
				
			}
		};
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
