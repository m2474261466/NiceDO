package day02;
/**
 * ����(����)
 * @author Lenovo
 *
 */
public class Person {
	String name;
	char gender;
	int age;
	
	//���췽��
	public Person(String name,int age){
		this.name=name;
		this.age=age;
		System.out.println("Person�Ĺ��췽��");
	}
	
	//˯����Ϊ
	public void sleep(){
		System.out.println(name+","+gender+","+age+"��˯��");
	}
}
