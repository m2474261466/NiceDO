package day10;

import day01.string;

/*
 * 查看线程信息的相关方法
 */
public class InforDemo {
	public static void main(String[] args) {
		//获取该方法的线程信息
		Thread main=Thread.currentThread();
		System.out.println(main);
		//获取线程id
		long id=main.getId();
		System.out.println(id);
		//获取线程名字
		String name=main.getName();
		System.out.println(name);
		
		
//		Thread t=new Thread(){
//			public void run(){
//				String str=Thread.currentThread().getName();
//				System.out.println(str);
//			}
//		};
//		t.start();
		
		
		//获取线程的优先级
		int p=main.getPriority();
		System.out.println(p);
		
		//判断线程是否还活着
		boolean b=main.isAlive();
		System.out.println(b);
		
		//判断线程是否是后台线程
		boolean b1=main.isDaemon();
		System.out.println(b1);
		
		//判断线程是否被中断
		boolean b2=main.isInterrupted();
		System.out.println(b2);
	}
}
