package day05;
/**
 * ��ϰ�����ڲ���
 * @author Lenovo
 *
 */
public class DemoAnonymousClass {
	public static void main(String[] args) {
		Student s=new Student(){
			public void sleep(){
				System.out.println("Student��˯��");
			}
		};
		s.sleep();
		
		Student s2=new Student(){
			public void sleep(){
				System.out.println("Student2����˯��");
			}
		};
		s2.sleep();
		
		Teacher t=new Teacher(){
			public void well(){
				System.out.println("Teacher�ڽ̿�");
			}
		};
		t.well();
		
		Teacher t2=new Teacher(){
			public void well(){
				System.out.println("Teacher2û���ڽ̿�");
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