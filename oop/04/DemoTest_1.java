package day03;

public class DemoTest_1 extends Demo {
	
	public void test(){
		System.out.println("DemoTest_1中的test()方法");
	}
	
	public void test2(){
		System.out.println("DemoTest_1中的test2()方法");
	}
	
	public void test3(){
		System.out.println("DemoTest_1中的test3()方法");
	}
	
	public static void main(String[] args) {
		//Demo d=new Demo();
		Demo d=new DemoTest_1();
		d.test();
		d.test2();
		d.test3();
	}
	
	
	
}
