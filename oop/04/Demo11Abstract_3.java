package day03;

public class Demo11Abstract_3 extends Demo11Abstract {
	
	public void test(){
		System.out.println("DemoAbstract_3��test()����");
	}
	
	public void test2(){
		System.out.println("DemoAbstract_3��test2()����");
	}
	
	public void test3(){
		System.out.println("DemoAbstract_3��test3()����");
	}
	
	public static void main(String[] args) {
		Demo11Abstract demo=new Demo11Abstract_3();
		demo.test();
		demo.test2();
		demo.test3();
	}
}
