package day03;

public class Demo11Abstract_2 extends Demo11Abstract {

	public void test(){
		System.out.println("DemoAbstract_2��test()����");
	}
	
	public void test2(){
		System.out.println("DemoAbstract_2��test2()����");
	}
	
	public void test3(){
		System.out.println("DemoAbstract_2��test3()����");
	}
	
	public static void main(String[] args) {
		Demo11Abstract demo=new Demo11Abstract_2();
		demo.test();
		demo.test2();
		demo.test3();
	}
}
