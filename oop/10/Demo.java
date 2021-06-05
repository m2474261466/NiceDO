package test;
/**
 * * 演示:
 * 一个类中可以创建多个对象,对象的结构相同,数据不同
 * 
 * 
 * 
 * 类是对象模板,对象是类的具体实例
 * @author Lenovo
 *
 */
public class Demo {
	String name;
	int age;
	//构造方法
	public Demo(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	
	
	
	public static void main(String[] args) {
		Demo d=new Demo("测试1",18);
		Demo d2=new Demo("测试2",19);
	}
}
