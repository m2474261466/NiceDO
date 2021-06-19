package day10;
/**
 * 守护线程（后台线程）：
 * 守护线程又称为后台线程，默认创建的线程都不是守护线程
 * 守护线程需要调用线程提供的void setDaemon(boolean b)
 * 当参数为true时，线程变为守护线程
 * 
 * 守护线程和普通线程在使用上没有什么区别，但是结束时有一个区别：
 * 当进程结束时，所有正在运行的守护线程会强结束，也就是说，普通线程
 * 结束时，守护线程强制中止
 * @author 24742
 *
 */
public class DaemonThreadDemo {
      public static void main(String[] args) {
		Thread t=new Thread(){
			public void run(){
				for(int i=0;i<15;i++){
					System.out.println("测试"+i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		};
    	  //线程（rose）
    	  Thread rose=new Thread(){
    		  public void run(){
    			  for(int i=0;i<10;i++){
    				  System.out.println("rose:我要跳海");
    				  try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
    			  }
    			  System.out.println("rose扑通跳下去了。。。。。。。");
    		  }
    	  };

    	  
    	//线程（jack）
    	  Thread jack=new Thread(){
    		public void run(){  
    		while(true)	{
    				System.out.println("你别跳，我陪你");
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
    		  }
    	  };
    	  //给jack设置成守护线程（后台线程）
    	  //设置守护线程再start方法之前
    	  jack.setDaemon(true);
    	  rose.start();
    	  jack.start();
    	  t.start();
    	  System.out.println("主线程");
	}
}
