package user;

public class Student {
       @Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	String name;
       String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
       
       
}
