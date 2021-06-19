package day10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * �̳߳أ�
 * �̳߳���Ҫ��ɹ�����
 * 1.������߳�����������ÿ���̻߳�ռ��һ�����ڴ棬�߳���������ᵼ���ڴ�ռ��̫��
 * ���и��������CPU�����л��ᵼ�³�����ֿ���
 * 2.�����߳�
 * @author 24742
 *
 */
public class threadPool {
   public static void main(String[] args) {
	  //�����̳߳�
	   ExecutorService pool=Executors.newFixedThreadPool(3);//�����̳߳أ����ڵ�����Ϊ3
	   for(int i=0;i<10;i++){
		   //10������
		   Runnable runn=new Runnable(){
			   public void run(){
				   try {
					String name=Thread.currentThread().getName();
					System.out.println(name+"�����������񡭡�");   
					Thread.sleep(3000);//�̵߳ȴ�3000����
				} catch (InterruptedException e) {//�쳣����
					e.printStackTrace();
				   }
			   }
		   };
		   //������ָ�����̳߳�
		   pool.execute(runn);
	   }
	   /*
	    * shutdown()��shutdownNow()�����̳߳�ֹͣ״̬
	    * shutdown()�������ú��̳߳ز��ٽ��������񣬻Ὣ�Ѿ��е�����ȫ��ִ�к���ֹͣ
	    * shutdownNow()���ú��̳߳ػ���������̵߳��жϷ���������ֹͣ
	    */
	   pool.shutdown();
    } 
} 
