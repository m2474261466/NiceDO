package day03;

public class Demo11Abstract_1 extends Demo11Abstract {
	
	public void test(){
		System.out.println("DemoAbstract_1��test()����");
	}
	
	public void test2(){
		System.out.println("DemoAbstract_1��test2()����");
	}
	
	public void test3(){
		System.out.println("DemoAbstract_1��test3()����");
	}
	
	public static void main(String[] args) {
		Demo11Abstract demo1=new Demo11Abstract_1();
		demo1.test();
		demo1.test2();
		demo1.test3();
	}
}
