package day08;

public class Demo {
	public static void test(Person person){
		/*person.age=30;
		person.name="��";
		System.out.println("����:"+person.name+",����:"+person.age);*/
		person.setAge(5000);
		person.setName("�й�");
		int age=person.getAge();
		String name=person.getName();
		System.out.println("����:"+name+",����:"+age);
	}
	
	public static void main(String[] args) {
		//Person person=new Person();
		//Demo.test(person);
	}
}
