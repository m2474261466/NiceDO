package day09;
/**
 * �������ڲ������ʽ����̵߳����ִ�����ʽ
 * @author 24742
 *
 */
public class ThreadDemo03 {
          public static void main(String[] args) {
			//�����߳�
        	  Thread t1=new Thread(){
        		  public void run(){
        			  for(int i=0;i<100;i++){
        					System.out.println("��ã����ԼӸ���ϵ��ʽ�");
        			  }
        		  }
        	  };
        	  
        	  
        	  //�����߳�����
        	  Runnable r=new Runnable(){
				public void run() {
					for(int j=0;j<100;j++){
						System.out.println("��˭��!FUCK OFF");
						}
				}
        		  
        	  };
        	  //�����߳�
        	  Thread t2=new Thread(r);
        	  //�����߳�
        	  t1.start();
        	  t2.start();
        	  
		}
}
