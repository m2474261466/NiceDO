package day03;
/**
 * 
 * 2.编写一个类中有三个方法,并且用三个不同的类继承这个类并重写后执行方法体中的内容
 * 
 * 最后我要提问:重写后的方法应该执行的是哪里的方法?如果子类没有重写父类的方法,
 * 执行后的方法应该是谁的方法
 * 父类指向子类也就是向上造型,能点出来看谁,点出来后方法体执行的是谁的方法体?
 * 
 * @author Lenovo
 *
 */
public class Demo {
	
	public void test(){
		System.out.println("Demo中的test()方法");
	}
	
	public void test2(){ 
		System.out.println("Demo中的test2()方法");
	}
	
	public void test3(){
		System.out.println("Demo中的test3()方法");
	}
	
	
}
