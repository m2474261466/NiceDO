package day10;

import day01.string;

/*
 * �鿴�߳���Ϣ����ط���
 */
public class InforDemo {
	public static void main(String[] args) {
		//��ȡ�÷������߳���Ϣ
		Thread main=Thread.currentThread();
		System.out.println(main);
		//��ȡ�߳�id
		long id=main.getId();
		System.out.println(id);
		//��ȡ�߳�����
		String name=main.getName();
		System.out.println(name);
		
		
//		Thread t=new Thread(){
//			public void run(){
//				String str=Thread.currentThread().getName();
//				System.out.println(str);
//			}
//		};
//		t.start();
		
		
		//��ȡ�̵߳����ȼ�
		int p=main.getPriority();
		System.out.println(p);
		
		//�ж��߳��Ƿ񻹻���
		boolean b=main.isAlive();
		System.out.println(b);
		
		//�ж��߳��Ƿ��Ǻ�̨�߳�
		boolean b1=main.isDaemon();
		System.out.println(b1);
		
		//�ж��߳��Ƿ��ж�
		boolean b2=main.isInterrupted();
		System.out.println(b2);
	}
}
