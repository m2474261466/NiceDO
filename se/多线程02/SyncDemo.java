package day10;
/**
 * ���̲߳�����ȫ���⣺
 * ������̲߳������в���һ������ʱ�������߳��л���ʱ��
 * ���ɿ���ԭ�򣬿��ܻᵼ�²���������ʱ�Ĺ���û�а��ճ���
 * ��Ƶ�ִ��˳�����У����²��������ݳ��ֻ��ң�����ʱ����
 * �ᵼ��ϵͳ̱��
 * @author 24742
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		Table table=new Table();
		Thread t1=new Thread(){
			public void run(){
				while(true){
				int n=table.getBean();
				Thread.yield();
				System.out.println(Thread.currentThread().getName()+"��������Ϊ"+n);
			}
		  }	
		};
		Thread t2=new Thread(){
			public void run(){
				while(true){
					int n=table.getBean();
					Thread.yield();
					System.out.println(Thread.currentThread().getName()+"��������Ϊ"+n);
				}
			}
		};
		t1.start();
		t2.start();
	}
}
class Table{
	private int bean=10;
	/*
	 * ��һ��������synchronized���Σ���ô�÷�����Ϊ��ͬ������������̲߳���
	 * ͬʱ���뷽���������У����ұ�������˳���һ��һ�����У��������ܱ��Ⲣ����ȫ
	 * ����
	 * 
	 */
	public synchronized int getBean(){
		if(bean==0){
			throw new RuntimeException("û�ж�����");
		}
		/*
		 * yield()�������̴߳�����״̬ת������״̬�������п���û��Ч��
		 * ��������ͣ��ǰ����ִ�е��̶߳��󣨷�����ǰӵ�е�CPU��Դ������
		 * ִ�������߳�
		 */
		
		Thread.yield();//ģ���л��߳�
		return bean--;
		
	}
}

