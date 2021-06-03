package day08;

public class Person {
	private int age;
	private String name;
	
	public Person(int age, String name){
		this.age=age;
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	/*public void setAge(int age){//设置年龄
		this.age=age;
	}
	
	public int getAge(){//获取年龄
		return this.age;
	}
	
	public void setName(String name){//设置名字
		this.name=name;
	}
	
	public String getName(){//获取名字
		return this.name;
	}*/
	
	
	
}
