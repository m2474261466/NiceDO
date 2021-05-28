package day01;
/**
 *  学生的具体对象类
 * @author Lenovo
 *
 */
public class StudentTest {
	public static void main(String[] args) {
	//  类(Student)   引用类型(student)  指向( = )   创建了一个新的对象(new Student())
		Student       student               =          new Student();//使用无参构造方法创建对象
		Student       student02             =          new Student(23,"测试2",'男',9527);//使用有参构造方法创建对象
		/*
		 * 获取对象中属性的值:对象的引用类型.对象的属性/特征即可
		 */
		System.out.println(student02.name+","+student02.num);
		//student.sleep();
		/*
		 * 创建对象后用引用类型"."去访问对象的属性和方法
		 */
		/*student.age=18;
		student.gender='男';
		student.name="尔特";		
		student.num=1;
		student.sleep();
		
		Student student02 = new Student();
		student02.name="高轲";
		student02.gender='男';
		student02.age=18;
		student02.num=2;
		student02.study();*/
		
		
	}
}
