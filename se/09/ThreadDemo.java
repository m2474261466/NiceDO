package day09;
/**
 * ����ԭ��
 * ���̣߳����߳��������ǡ�ͬʱ��ִ�ж�δ���
 * �߳��ǲ������еģ��̵߳��Ȼ�ͳһ�滮CPUʱ�䣬��CPU��ʱ�仮��Ϊ
 *ŵ��Ƭ�Σ�Ȼ�󾡿��ܵľ��ȷ������Ҫ�������е��̣߳�ÿ���߳��ڻ�ȡCPU
 *ʱ��Ƭ�κ�CPU���������������񣬵�ʱ��Ƭ�������CPU���뿪��ִ�л�ȡ��CPUʱ��Ƭ���̣߳�
 *���������̲߳��������ġ�ͬʱ����������룬��������ͣͣ���ں���ϸо���ͬʱ���е������Ϊ���������С�
 *
 *
 *�̣߳�Thread
 *�߳��ṩ�����ִ�����ʽ��
 *��ʽһ���̳�Thread����дrun�����������߳�����
 * @author 24742
 *
 */
public class ThreadDemo {
   public static void main(String[] args) {
	Thread t1=new MyThread1();
	Thread t2=new MyThread2();
	/*
	 * �����̲߳��ǵ���run()����������Ҫ����start()������
	 * �߳̿�ʼ��������ʱ���Զ�����run()����
	 * 
	 */
	t1.start();
	t2.start();
	/*
	 * ��һ�ִ����̵߳ķ�ʽ����������
	 * 1.����java�ǵ��̳У���͵������̳���Thread�Ͳ��ܼ̳������࣬
	 * ��ʵ�ʿ����зǳ������㣬��Ϊ�޷������������ĳЩ����
	 * 2.���ڼ̳�Thread��дrun()�����������߳�Ҫִ�е�������͵����߳����߳�ִ�е�������һ����Ȼ
	 * ����Ϲ�ϵ���������߳�����
	 */
   }
}
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("��ã����ԼӸ���ϵ��ʽ�");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int j=0;j<100;j++){
		System.out.println("��˭��!FUCK OFF");
		}
	}
}