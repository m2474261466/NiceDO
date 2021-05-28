package day01;
/**
 * 局部变量和成员变量(又称全局变量)(重点)
 * @author Lenovo
 *
 */
public class Test {
	int a;//成员变量具有默认值
	static int c;
	public void demo(){
		int b;
		System.out.println(a);
		a=10;
		//System.out.println(b);//编译错误,局部变量必须声明并且初始化
		System.out.println(a);
	}
	
	public static void demo02(){
		System.out.println(c);
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		t.demo();
		Test t02=new Test();
		t02.demo02();
	}
	
}
