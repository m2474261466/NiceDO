package day08;

public class Demo {
	public static void test(Person person){
		/*person.age=30;
		person.name="轲";
		System.out.println("姓名:"+person.name+",年龄:"+person.age);*/
		person.setAge(5000);
		person.setName("中国");
		int age=person.getAge();
		String name=person.getName();
		System.out.println("姓名:"+name+",年龄:"+age);
	}
	
	public static void main(String[] args) {
		//Person person=new Person();
		//Demo.test(person);
	}
}
