package day07;
/**
 * 一个类可以实现多个接口,并且用逗号隔开,若有继承也有实现时,
 * 应该 先继承 再实现
 * @author Lenovo
 *
 */
public class Test extends Test2 implements DemoInterface2 {
	public void test2(){
		System.out.println("test2()方法");
	}
	
	public void test3(){
		System.out.println("test3()方法");
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		t.tt();
	}
	
}
