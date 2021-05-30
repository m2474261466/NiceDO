package day03;
/**
 * 
 * final演示:
 * final修饰成员变量,只有两种初始化方式
 * 	1.声明的同时并初始化
 * 	2.在构造方法中初始化
 *
 *	final:最终的,不可改变的-------单独应用效率非常低
 *	1)修饰变量:变量不可改变
 *  2)修饰类:类是不可以被继承的
 *  3)修饰方法:方法是不可以被重写的
 *
 * @author Lenovo
 *
 */
public final class DemoFinal {
	final int age;
	
	public DemoFinal(){
		this.age=20;
	}
	
	public void test(){
		//age=20;//编译错误,age有final修饰因此不能改变
	}
	
/*class Demo extends DemoFinal(){//编译错误,DemoFinal被final修饰,所以不能被继承
		
}*/

class A{
	final public void woo(){
		
	}
}

class B extends A{
	/*public void woo(){//编译错误,原因是在父类A中的woo()方法被final修饰是不能被子类重写的
		
	}*/
}





}
