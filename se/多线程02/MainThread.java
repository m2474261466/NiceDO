package day10;
/**
 * ��ν�����߳�Ҳ����ִ��main�������߳�
 * ����ִ�����̣߳���ִ����ͨ�߳�
 * @author 24742
 *
 */
public class MainThread {
    public static void main(String[] args) {
		System.out.println("ִ�п�ʼ��");
		//���̵߳�����
		System.out.println("���߳�����"+Thread.currentThread().getName());
	   for(int i=0;i<100;i++){
		   System.out.println(i);
	   }
	   Thread t=new Thread(){
		   public void run(){
			   System.out.println("�Զ����̣߳�"+Thread.currentThread().getName());
		      for(int i=0;i<100;i++){
		    	  System.out.println("���");
		      }
		   }
	   };
	   t.start();
    }
} 
