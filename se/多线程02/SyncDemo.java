package day10;
/**
 * 多线程并发安全问题：
 * 当多个线程并发运行操作一个数据时，由于线程切换的时间
 * 不可控制原因，可能会导致操作该数据时的过程没有按照程序
 * 设计的执行顺序运行，导致操作后数据出现混乱，严重时可能
 * 会导致系统瘫痪
 * @author 24742
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		Table table=new Table();
		Thread t1=new Thread(){
			public void run(){
				while(true){
				int n=table.getBean();
				Thread.yield();
				System.out.println(Thread.currentThread().getName()+"豆豆数量为"+n);
			}
		  }	
		};
		Thread t2=new Thread(){
			public void run(){
				while(true){
					int n=table.getBean();
					Thread.yield();
					System.out.println(Thread.currentThread().getName()+"豆豆数量为"+n);
				}
			}
		};
		t1.start();
		t2.start();
	}
}
class Table{
	private int bean=10;
	/*
	 * 当一个方法用synchronized修饰，那么该方法变为“同步方法”多个线程不能
	 * 同时进入方法内容运行，而且必须是有顺序的一个一个运行，这样就能避免并发安全
	 * 问题
	 * 
	 */
	public synchronized int getBean(){
		if(bean==0){
			throw new RuntimeException("没有豆豆了");
		}
		/*
		 * yield()将导致线程从运行状态转到就绪状态，但是有可能没有效果
		 * 作用是暂停当前正在执行的线程对象（放弃当前拥有的CPU资源），并
		 * 执行其他线程
		 */
		
		Thread.yield();//模拟切换线程
		return bean--;
		
	}
}

