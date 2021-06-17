package day09;
/*
 * 使用匿名内部类实现创建线程的两种方式
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//创建线程
		Thread t1=new Thread(){
			
			public void run() {
				for(int i=0;i<100;i++){
					System.out.println("淦淦淦！");
				}
			}
		};
		
		//创建线程任务
		Runnable r=new Runnable() {
		
			public void run() {
				for(int i=0;i<100;i++){
					System.out.println("草草草！");
				}
			}
		};
		Thread t2=new Thread(r);
		
		//启动线程
		t1.start();
		t2.start();
	}
}
