package day09;
/**
 * �̵߳����ȼ���
 * �̵߳���start()�����������̵߳���ͳһ�����̲߳���������ȡCPUʱ��Ƭ�Σ�ֻ�ܱ������䣬
 * �������ȼ������̶ȵĸ���ĳ���̻߳�ȡCPUʱ��Ƭ�εĸ��ʣ�
 * �������߳����ȼ�Խ�ߵ��̻߳�ȡCPUʱ��Ƭ�εĴ���Խ��
 * 
 * 
 * 
 * �߳����ȼ�10���ȼ���1-10��
 * 1��ʾ���ȼ����
 * 5��ʾĬ��
 * 10��ʾ���ȼ����
 * 
 * 
 * 
 * �����߳����ȼ�����setPriority(int p),
 * �߳��ṩ��3�������ֱ��ʾ��ͣ���ߣ�Ĭ��
 * @author 24742
 *
 */
public class PriorityDemo {
    public static void main(String[] args) {
		Thread t1=new Thread(){
		public void run(){
			for(int i=0;i<1000;i++){
				System.out.println("max");
			}
		 }
		};
		
		Thread t2=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("Ĭ��");
				}
			}
		};
		
		Thread t3=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("min");
				}
				
			}
		};
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
