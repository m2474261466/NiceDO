package day02;
/**
 * this关键字使用
 * 1.this关键字在方法体中,用于指向调用该方法的当前对象,简单的说:哪个对象调用方法,
 * this值就得是哪个对象,严格来讲在方法中需要通过this关键字指明当前对象
 * 2.在构造方法中,用来初始化成员变量的参数一般和成员变量取相同的名字,这样会有利于代码的可读性,
 * 但此处就必须通过this关键字来区分成员变量和参数了(在这里不能省略this)
 * this的用法:
 * 1.	this.成员变量---------访问成员变量
 * 2.	this.方法名()---------调用当前对象方法(一般不用)
 * 3.	this()----------------调用构造方法(在构造方法之间调用)
 * @author Lenovo
 *
 */
public class StudentThis {
	//成员变量
	int age;
	String name;
	String address;
	
	public StudentThis(){
		this("null",20,"大秦");
	}
	
	public StudentThis(String name,int age,String address){//有参构造方法
		//this.成员变量=与成员变量同名的变量;
		this.name=name;
		this.age=age;
		this.address=address;
		System.out.println("调用成功!"+name+","+age+","+address);
		System.out.println(this);//this的地址
	}
	
	public void test(){
		System.out.println("test()");
		this.test1();//this调用当前对象的test1方法
	}
	
	public void test1(){
		System.out.println("test1()");
	}
	
	public static void main(String[] args) {
		StudentThis s=new StudentThis();
		/*
		 * s的地址值与构造方法StudentThis的地址值相同
		 * 符合this关键字的第一条:通过那个对象调用的方法,this的值就是那个对象
		 */
		System.out.println(s);//地址值
	}
}
