package day03;

public class DemoTest_2 extends Demo {

	public void test(){
		System.out.println("DemoTest_2�е�test()����");
	}
	
	public void test2(){
		System.out.println("DemoTest_2�е�test2()����");
	}
	
	public void test3(){
		System.out.println("DemoTest_2�е�test3()����");
	}
	
	public static void main(String[] args) {
		Demo d=new DemoTest_2();
		d.test();
		d.test2();
		d.test3();
	}
	
}
