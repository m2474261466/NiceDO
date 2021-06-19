package day10;
/**
 * �߳��ṩ��һ������void join()�÷�������һ���߳�����һ���߳��ϵȴ���
 * ֱ��ִ����Ϻ��ټ������У�����������Э���̼߳�ġ�ͬ�����С�
 * ͬ������:����ִ�����Ⱥ�˳�򣨵��߳�����ʱͬ�������߳�Ҳ���Խ���ͬ�����в�����
 * �첽���У������ִ�и��ģ����߳����д���ʱ�첽�ģ�
 * @author 24742
 *
 */
public class JoinDemo {
       public static void main(String[] args) {
		//�̣߳����أ�
    	Thread download=new Thread(){
    		public void run(){
    			System.out.println("��ʼ����ͼƬ");
    			for(int i=1;i<100;i++){
    				System.out.println("���ؽ���"+i+"%");
    				try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    			}
    			System.out.println("ͼƬ������ϣ�");
    		}
    	};
    	
    	//�̣߳���ʾͼƬ��
    	Thread show=new Thread(){
    		public void run(){
    			try {
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    			System.out.println("��ʼ��ʾͼƬ");
    		}
    	};
    	download.start();
    	show.start();
	}
}
