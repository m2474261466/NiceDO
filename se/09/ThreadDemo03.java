package day09;
/**
 * 用匿名内部类的形式完成线程的两种创建方式
 * @author 24742
 *
 */
public class ThreadDemo03 {
          public static void main(String[] args) {
			//创建线程
        	  Thread t1=new Thread(){
        		  public void run(){
        			  for(int i=0;i<100;i++){
        					System.out.println("你好，可以加个联系方式嘛！");
        			  }
        		  }
        	  };
        	  
        	  
        	  //创建线程任务
        	  Runnable r=new Runnable(){
				public void run() {
					for(int j=0;j<100;j++){
						System.out.println("你谁啊!FUCK OFF");
						}
				}
        		  
        	  };
        	  //创建线程
        	  Thread t2=new Thread(r);
        	  //启动线程
        	  t1.start();
        	  t2.start();
        	  
		}
}
