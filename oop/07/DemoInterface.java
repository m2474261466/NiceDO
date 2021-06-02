package day07;
/**
 * 接口演示:
 * 什么是接口:接口就是一种标准的一种规范
 * 接口关键字 interface
 * 接口中只能包含抽象方法和常量,并且接口中的所有方法(抽象方法)在实现类中
 * 必须要重写
 * 修饰词必须为public
 * @author Lenovo
 *
 */
public interface DemoInterface {
	//private int age=18;//编译错误 接口中只能包含抽象方法和常量
	/*public void test(){//编译错误 接口中只能包含抽象方法和常量
		
	}*/
	
	public static final String NAME="java";//常量
	public static final int AGE=18;//常量
	public abstract void test();//抽象方法(不提倡这样写)
	
	//抽象方法中的前面的修饰词public abstract可以省略,Java会默认提供
	void test2();
	int test3();
	//抽象方法中的前面的修饰词abstract可以省略,Java会默认提供
	public void test4();
	public int test5();
	
	/*public void test6(){//编译错误,在接口中不能有方法体
		
	}*/
	
	
}
