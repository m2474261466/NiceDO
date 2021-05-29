package day02;
/**
 * 方法的签名:方法名+参数列表
 * 方法的重载
 * 1.发生在同一个类中,方法名相同,参数列表类型和数量不同
 * 2.方法的重载和返回值类型没有任何关系
 * 3.编译器在编译时根据方法的签名自动绑定并调用方法;
 * @author Lenovo
 *
 */
public class Student {
	int age;
	String name;
	String address;
	
	public Student(){//无参构造方法
		//System.out.println("无参构造方法");
	}
	
	public Student(String name){//有参构造方法
		//System.out.println("参数为name的有参构造方法");
	}
	
	public Student(int age,String address){//有参构造方法
		this.age=age;
		this.address=address;
		//System.out.println("参数为age和address的有参构造方法");
	}
	
	public void test(){//方法的签名:test()
		System.out.println("test()无参方法");
	}
	
	public void test(String name){
		System.out.println("我的名字是:"+name);
	}
	
	//编译错误,这不是方法的重载,因为方法名、参数列表类型和数量都相同,不满足条件1
	/*public void test(String adderss){
		System.out.println("我的地址是:"+address);
	}*/
	
	public void test(String name, String address){
		System.out.println("我的名字是:"+name+",地址是:"+address);
	}
	
	//编译错误,方法的重载和返回值类型没有任何关系,这不是方法的重载
	/*public int test(){
		System.out.println("带有返回值类型的方法");
		return 6;
	}*/
	
	public static void main(String[] args) {
		Student s=new Student();
		/*s.test();
		s.test("坤坤");
		s.test("坤坤","益康特");*/
	}
	
	
	
	
	
}
