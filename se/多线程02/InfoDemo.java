package day10;
/**
 * �鿴�߳���Ϣ����ط���
 * @author 24742
 *
 */
public class InfoDemo {
      public static void main(String[] args) {
		//��ȡִ�и÷������߳���Ϣ
    	  Thread main=Thread.currentThread();
    	  System.out.println(main);
    	  //��ȡ�߳�
    	  long id=main.getId();
    	  System.out.println(id);
    	  //��ȡ�̵߳�����
    	  String name=main.getName();
    	  System.out.println(name);
    	  //���磺
    	 /* Thread t=new Thread(){
    		    public void run(){
    		      String str=Thread.currentThread().getName();
    	          System.out.println(str);
    		  }
    	  };
    	  t.start();*/
    	  
    	  //��ȡ�̵߳����ȼ�
    	  int p=main.getPriority();
    	  System.out.println(p);
    	  //�ж��߳��Ƿ񻹻���
    	  boolean b=main.isAlive();
    	  System.out.println(b);
    	  //�ж��߳��Ƿ��Ǻ�̨�̣߳��ػ��̣߳�
    	  boolean b1=main.isDaemon();
    	  System.out.println(b1);
    	  //�ж��߳��Ƿ��ж�
    	  boolean b2=main.isInterrupted();
    	  System.out.println(b2);
	}
}
