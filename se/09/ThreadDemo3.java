package day09;
/*
 * ʹ�������ڲ���ʵ�ִ����̵߳����ַ�ʽ
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//�����߳�
		Thread t1=new Thread(){
			
			public void run() {
				for(int i=0;i<100;i++){
					System.out.println("�����ƣ�");
				}
			}
		};
		
		//�����߳�����
		Runnable r=new Runnable() {
		
			public void run() {
				for(int i=0;i<100;i++){
					System.out.println("�ݲݲݣ�");
				}
			}
		};
		Thread t2=new Thread(r);
		
		//�����߳�
		t1.start();
		t2.start();
	}
}
