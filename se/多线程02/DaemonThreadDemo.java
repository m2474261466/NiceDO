package day10;
/**
 * �ػ��̣߳���̨�̣߳���
 * �ػ��߳��ֳ�Ϊ��̨�̣߳�Ĭ�ϴ������̶߳������ػ��߳�
 * �ػ��߳���Ҫ�����߳��ṩ��void setDaemon(boolean b)
 * ������Ϊtrueʱ���̱߳�Ϊ�ػ��߳�
 * 
 * �ػ��̺߳���ͨ�߳���ʹ����û��ʲô���𣬵��ǽ���ʱ��һ������
 * �����̽���ʱ�������������е��ػ��̻߳�ǿ������Ҳ����˵����ͨ�߳�
 * ����ʱ���ػ��߳�ǿ����ֹ
 * @author 24742
 *
 */
public class DaemonThreadDemo {
      public static void main(String[] args) {
		Thread t=new Thread(){
			public void run(){
				for(int i=0;i<15;i++){
					System.out.println("����"+i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		};
    	  //�̣߳�rose��
    	  Thread rose=new Thread(){
    		  public void run(){
    			  for(int i=0;i<10;i++){
    				  System.out.println("rose:��Ҫ����");
    				  try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
    			  }
    			  System.out.println("rose��ͨ����ȥ�ˡ�������������");
    		  }
    	  };

    	  
    	//�̣߳�jack��
    	  Thread jack=new Thread(){
    		public void run(){  
    		while(true)	{
    				System.out.println("�������������");
    				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
    		  }
    	  };
    	  //��jack���ó��ػ��̣߳���̨�̣߳�
    	  //�����ػ��߳���start����֮ǰ
    	  jack.setDaemon(true);
    	  rose.start();
    	  jack.start();
    	  t.start();
    	  System.out.println("���߳�");
	}
}
