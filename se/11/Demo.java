package day11;

import java.util.Arrays;

public class Demo {
	private int[] arr=new int[0];
	public void test(){
		Aoo a=new Aoo();
		Thread t1=new Thread(){
			public void run(){
				a.method();
			}
		};
		Thread t2=new Thread(){
			public void run(){
				a.method();
			}
		};
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		Demo d=new Demo();
		d.test();
	}
	
class Aoo {
		public void method(){
			synchronized (this) {
				arr=Arrays.copyOf(arr, arr.length+1);
				System.out.println("在线人数"+arr.length);
			}
		}
    }
}
