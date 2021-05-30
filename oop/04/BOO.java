package day03;

public class BOO extends DemoAbstract{
	public void test(){
		System.out.println("BOO");
	}
	
	public void test2(){
		System.out.println("BOO里的test2()方法");
	}
	
	public static void main(String[] args) {
		DemoAbstract d=new BOO();
		d.test();
	}
}
