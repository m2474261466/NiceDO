package day10;
/*
 * �ػ��̣߳���̨�̣߳���
 * �ػ��߳��ֳ�Ϊ��̨�̣߳�Ĭ�ϴ������̶߳����Ǻ�̨�̣߳�
 * �ػ��߳���Ҫ�����߳��ṩ�ķ���void setDaemon�� boolean b��
 * ������Ϊtrueʱ���̱߳�Ϊ�ػ��߳�
 * 
 * �ػ��̺߳���ͨ�߳�����ʹ����û��ʲô���𣬵��ǽ���ʱ��һ������
 * �����̽���ʱ�������������е��ػ��̻߳�ǿ��������Ҳ����˵��Ҳ����˵,
 * ��ͨ�߳̽���ʱ���ػ��̻߳�ǿ�ƽ�����
 * 
 */
public class DaemonThread {
	public static void main(String[] args) {
		//�߳�1��rose��
		Thread rose=new Thread(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println("rose: ����ȥ����////");
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("rose:��ͨ������");
			}
		};
		
		
		//�߳�2��jack��
		Thread jack=new Thread(){
			public void run(){
				while(true){
					System.out.println("jack:������Ҳ��@������");
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		//��jack���ó��ػ��̣߳���̨�̣߳�
		//�����ػ��߳���start����֮ǰ����ǰ����
		jack.setDaemon(true);
		rose.start();
		jack.start();
	}
}
