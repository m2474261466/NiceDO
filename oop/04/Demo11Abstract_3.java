package day03;

public class Demo11Abstract_3 extends Demo11Abstract {
	
	public void test(){
		System.out.println("DemoAbstract_3的test()方法");
	}
	
	public void test2(){
		System.out.println("DemoAbstract_3的test2()方法");
	}
	
	public void test3(){
		System.out.println("DemoAbstract_3的test3()方法");
	}
	
	public static void main(String[] args) {
		Demo11Abstract demo=new Demo11Abstract_3();
		demo.test();
		demo.test2();
		demo.test3();
	}
}
