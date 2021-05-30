package day03;

public class Demo11Abstract_1 extends Demo11Abstract {
	
	public void test(){
		System.out.println("DemoAbstract_1的test()方法");
	}
	
	public void test2(){
		System.out.println("DemoAbstract_1的test2()方法");
	}
	
	public void test3(){
		System.out.println("DemoAbstract_1的test3()方法");
	}
	
	public static void main(String[] args) {
		Demo11Abstract demo1=new Demo11Abstract_1();
		demo1.test();
		demo1.test2();
		demo1.test3();
	}
}
