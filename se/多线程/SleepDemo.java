package day09;
/**
 * ˯������״̬��
 * static void sleep(long ms)
 * ��һ���߳�ִ��sleep������ͻ��������״ָ̬���ĺ�����
 * ��ʱ���̻߳��Զ��ص�Runnable����״̬�ȴ��ٴβ������У��÷���Ҫ����봦��InterruptedException
 * s˯������״̬ʱ�������̵߳���interrupted�����ж�ʱ���׳����쳣�����˯������״̬
 * 
 * interrupt()���������ж��̣߳��������̴߳�������״̬ʱ�ж�������
 * ���߳�û�д�������״̬���߳�ֱ�ӱ��ж�
 * 
 * @author 24742
 *
 */
public class SleepDemo {
      public static void main(String[] args) {
    	  Thread qiang=new Thread(){
  			public void run(){
  				System.out.println("ǿ�磺˯����");
  				try {
  					Thread.sleep(10000);
  					System.out.println("������");
  				} catch (InterruptedException e) {
  					e.printStackTrace();
  					System.out.println("ǿ�磺woc,ǽ����");
  				}
  			}
  		};
		Thread chao=new Thread(){
			public void run(){
		    System.out.println("���������ҿ�ʼ��ǽ��");
		     for(int i=0;i<5;i++){
		    	 System.out.println("��������80������������������������������");
		    	 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		     }
		     System.out.println("duang");
		     qiang.interrupt();
			}
		};
		
		//�����߳�
		chao.start();
		qiang.start();
		
	}
}
