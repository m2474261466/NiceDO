package day10;
/**
 * 1.wait��Object���еķ�����sleep��Thread���еķ�����
 * 2.����Ҫ����sleep��������֮�󣬲�û���ͷ�����ʹ���߳���Ȼ����ͬ�����ƣ�
 *   sleep�����ó�ϵͳ��Դ��sleep�����������κεط�ʹ�ã���wait������synchronized��������
 *   synchronized����ʹ�ã�������׳��쳣java.lang.IllegalMonitorStateException��
 *   wait���������ó�CPU�������ͷ���ռ�е�ͬ����Դ����
 * 3.sleep���벶���쳣����wait��notify��notifyAll����Ҫ�����쳣��
 * 4.sleep����ĳ���߳���ʱ����һ��ʱ�䣬����Ʒ�Χ���ɵ�ǰ�߳̾�����
 *   ����Ȩ���Լ������wait����ĳ��ȷ���Ķ��������õģ�����Ȩ��ĳ����������
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
				//Thread.sleep(3000);//���ͷ���
				str.wait(10000);//��ȫ�ͷ���
				str.append("*");
				 System.out.println(name+":"+str.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			 }
			}
		 }
	 }
 }
 
 ///����wait״̬
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
		    //����wait()״̬
			 ThreadMy01.str.notify();
	    }
	 }
 }