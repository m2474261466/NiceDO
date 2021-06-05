package test;
/**
 * this关键字:
 * 1.this是在方法体中,用于指向调用该方法的当前对象
   2.在构造方法中,
   用来初始化成员变量(参数列表名和成员变量名字相同的情况下,这样有利于代码的可读性)
 * 
 * @author Lenovo
 *
 */
public class Demo4 {
	String name;
	int age;
	public Demo4(String name,int age){
		this.name=name;
		this.age=age;
	}
}
