package user;

public class Teacher {
      private String name;
      private int age;
	public Teacher(String name, int age) {
		System.out.println("Teacher�вι�����");
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + "]";
	}
	
}
