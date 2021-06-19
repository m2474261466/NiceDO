package day10;
/*
 * 守护线程（后台线程）：
 * 守护线程又称为后台线程，默认创建的线程都不是后台线程，
 * 守护线程需要调用线程提供的方法void setDaemon（ boolean b）
 * 当参数为true时，线程变为守护线程
 * 
 * 守护线程和普通线程上在使用上没有什么区别，但是结束时有一个区别：
 * 当进程结束时，所有正在运行的守护线程会强至结束，也就是说，也就是说,
 * 普通线程结束时，守护线程会强制结束。
 * 
 */
public class DaemonThread {
	public static void main(String[] args) {
		//线程1（rose）
		Thread rose=new Thread(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println("rose: 让我去死。////");
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("rose:扑通。。。");
			}
		};
		
		
		//线程2（jack）
		Thread jack=new Thread(){
			public void run(){
				while(true){
					System.out.println("jack:你死我也死@！！！");
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		//给jack设置成守护线程（后台线程）
		//设置守护线程在start方法之前方法前调用
		jack.setDaemon(true);
		rose.start();
		jack.start();
	}
}
