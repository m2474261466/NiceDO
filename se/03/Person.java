package day02;

public class Person {
     private  int age;
     private  String name;
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
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	//重写父类object中的toString()方法
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	

     










}
