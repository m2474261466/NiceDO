package day09;
/**
 * �ڶ��ִ����̵߳ķ�ʽ
 * ʵ��runnable�ӿڵ��������߳�����
 * 
 * 
 * ʹ��runnable�����������߳�ʵ��Runnable�ӿڲ���дrun����
 * �������߳��壬Ȼ���ٴ����̵߳�ʱ��runnable��ʵ�����벢�����߳�
 * ���������ĺô����ڿ��Խ��̺߳��߳�Ҫִ�е�������룬������϶�
 * @author 24742
 *
 */
public class ThreadDemo02 {
     public static void main(String[] args) {
	       //�����߳�����
    	 MyThread3 m1=new MyThread3();
    	 MyThread4 m2=new MyThread4();
    	 
    	 //�����̲߳�ִ��
    	 Thread t1=new Thread(m1);
    	 Thread t2=new Thread(m2);
    	 //ִ������
    	 t1.start();
    	 t2.start();
    
    }
}
//�߳�����
class MyThread3 extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("��ã����ԼӸ���ϵ��ʽ�");
		}
	}
}
//�߳�����
class MyThread4 extends Thread{
	public void run(){
		for(int j=0;j<100;j++){
		System.out.println("��˭��!FUCK OFF");
		}
	}
}