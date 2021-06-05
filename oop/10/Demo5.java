package test;
/**
 *  继承(extends)
	1.发生超类(父类)和子类(派生类)中;
		1):所有派生类的共有属性和行为
		2):派生类继承超类后具有的属性和行为:超类+派生类,在这里注意如果超类的属性和行为被私有化,派		   生类则不在继承
	2:一个超类可以有多个派生类,一个派生类只能有一个超类
	3:作用(好处):代码的复用,减少代码的重复
	派生类如果继承超类的构造方法?(关键字super())
	 1.用super()来继承超类的构造方法,必须写在派生类构造方法中的第一行(指代当前对象的超类对象)
	 2.派生类中如果没有调用超类的构造方法,则默认super()来调用超类的无参构造方法,如果调用了超类
       的构造方法,则不在默认提供
 * @author Lenovo
 *
 */
public class Demo5 {
	public String name;
	public int age;
	
	public Demo5(String name){
		System.out.println("Demo5的构造方法");
	}
	
	public void test(){
		System.out.println(name);
	}
	
}

class A00 extends Demo5{
	public A00(){
		super("坤");
		System.out.println("测试");
		
	}
}

