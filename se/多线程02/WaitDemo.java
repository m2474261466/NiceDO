package day10;
/**
 * 1.wait是Object类中的方法，sleep是Thread类中的方法。
 * 2.最主要的是sleep方法调用之后，并没有释放锁，使得线程仍然可以同步控制，
 *   sleep不会让出系统资源，sleep方法可以在任何地方使用，而wait必须在synchronized方法或者
 *   synchronized块中使用，否则会抛出异常java.lang.IllegalMonitorStateException，
 *   wait方法不仅让出CPU，还会释放已占有的同步资源锁；
 * 3.sleep必须捕获异常，而wait，notify和notifyAll不需要捕获异常；
 * 4.sleep是让某个线程暂时运行一段时间，其控制范围是由当前线程决定，
 *   主动权在自己手里，而wait是由某个确定的对象来调用的，主动权在某个对象手里
 * 
 * @author 24742
 *
 */
public class WaitDemo {
     public static void main(String[] args) {
		/*Thread t=new ThreadMy01();
		Thread t2=new ThreadMy01();
		Thread t3=new ThreadMy01();
		t.start();
		t2.start();
		t3.start();*/
    	 Thread t1=new ThreadMy01();
    	 Thread t2=new ThreadMy02();
    	 t1.start();
    	 t2.start();
	}
}
 class ThreadMy01 extends Thread{
	 public static StringBuilder str=new StringBuilder();
	 public void run(){
		String name= Thread.currentThread().getName();
		 synchronized(str){
		   for(int i=0;i<5;i++){
			 try {
				//Thread.sleep(3000);//不释放锁
				str.wait(10000);//完全释放锁
				str.append("*");
				 System.out.println(name+":"+str.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			 }
			}
		 }
	 }
 }
 
 ///唤醒wait状态
 class ThreadMy02 extends Thread{
	 public void run(){
		 synchronized (ThreadMy01.str) {
			 for(int i=0;i<2;i++){                                      
			    	try {
			    		System.out.println("ykt");
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
		      }
		   }
		    //唤醒wait()状态
			 ThreadMy01.str.notify();
	    }
	 }
 }