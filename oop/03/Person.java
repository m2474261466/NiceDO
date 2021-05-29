package day02;
/**
 * 超类(父类)
 * @author Lenovo
 *
 */
public class Person {
	String name;
	char gender;
	int age;
	
	//构造方法
	public Person(String name,int age){
		this.name=name;
		this.age=age;
		System.out.println("Person的构造方法");
	}
	
	//睡觉行为
	public void sleep(){
		System.out.println(name+","+gender+","+age+"在睡觉");
	}
}
