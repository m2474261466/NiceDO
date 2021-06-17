package day09;
/**
 * 第二种创建线程的方式
 * 实现runnable接口单独定义线程任务
 * 
 * 
 * 使用runnable创建并启动线程实现Runnable接口并重写run方法
 * 来定义线程体，然后再创建线程的时候将runnable的实例传入并启动线程
 * ，这样做的好处在于可以将线程和线程要执行的任务分离，降低耦合度
 * @author 24742
 *
 */
public class ThreadDemo02 {
     public static void main(String[] args) {
	       //创建线程任务
    	 MyThread3 m1=new MyThread3();
    	 MyThread4 m2=new MyThread4();
    	 
    	 //创建线程并执行
    	 Thread t1=new Thread(m1);
    	 Thread t2=new Thread(m2);
    	 //执行任务
    	 t1.start();
    	 t2.start();
    
    }
}
//线程任务
class MyThread3 extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("你好，可以加个联系方式嘛！");
		}
	}
}
//线程任务
class MyThread4 extends Thread{
	public void run(){
		for(int j=0;j<100;j++){
		System.out.println("你谁啊!FUCK OFF");
		}
	}
}