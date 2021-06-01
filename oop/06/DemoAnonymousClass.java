package day05;
/**
 * 练习匿名内部类
 * @author Lenovo
 *
 */
public class DemoAnonymousClass {
	public static void main(String[] args) {
		Student s=new Student(){
			public void sleep(){
				System.out.println("Student爱睡觉");
			}
		};
		s.sleep();
		
		Student s2=new Student(){
			public void sleep(){
				System.out.println("Student2不爱睡觉");
			}
		};
		s2.sleep();
		
		Teacher t=new Teacher(){
			public void well(){
				System.out.println("Teacher在教课");
			}
		};
		t.well();
		
		Teacher t2=new Teacher(){
			public void well(){
				System.out.println("Teacher2没有在教课");
			}
		};
		t2.well();
	}		
	
}

abstract class Student{
	public abstract void sleep();
}

abstract class Teacher{
	public abstract void well();
}