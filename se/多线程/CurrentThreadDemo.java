package day09;
/**
 * �߳��ṩ��static Thread currentThread()
 * �÷������Ի�ȡ��������������̣߳�java�����еĴ��붼���߳����еģ�main����Ҳ������
 * ��JVM�����������һ���߳���ִ��main������ͨ�����ǳ�ִ��main�������߳�Ϊ�����̡߳�
 * @author 24742
 *
 */
public class CurrentThreadDemo {
	       public static void dosome(){
	    	   Thread t=Thread.currentThread();
	    	   //Thread[main,5,main]
               //Thread[�߳�����,���ȼ�,�߳���]
	    	   System.out.println("����dosome�������߳�"+t);
	       }
           public static void main(String[] args) {
        	   //��ȡ����main�������߳�
        	Thread t2=Thread.currentThread();
        	System.out.println("t2���߳�Ϊ"+t2);
			dosome();
			Thread t3=new Thread(){
				public void run() {
					Thread r=Thread.currentThread();
			    System.out.println("t3���߳�Ϊ"+r);
				}
			};
			t3.start();
		}
}
