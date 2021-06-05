package test;
/**
 * 方法的重载:
 * 1.发生在同一个类中,方法名相同,参数列表类型和数量不同
   2.和返回值毫无关系
   3.编译器在编译时根据方法的签名(方法名+参数列表)自动绑定调用的方法
 * @author Lenovo
 *
 */
public class Demo3 {
	int age;
	String name;
	//构造方法
	public Demo3(){
		
	}
	public Demo3(String name){
		
	}
	public Demo3(String name,int age){
		
	}
	
	public int test(String name){
		System.out.println("有参");
		return  1;
		
	}
	
	public int test(int age){
		System.out.println("有参");
		return  1;
		
	}
	
	public void test(){
		System.out.println("无参");
	}
	
	public static void main(String[] args) {
		Demo3 d=new Demo3();
		d.test("坤");
		d.test(18);
	}	
	
	
	
}
