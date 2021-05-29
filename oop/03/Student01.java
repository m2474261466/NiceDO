package day02;
/**
 * 访问控制修饰词
 * private只适用于本类不管是成员变量还是方法
 * protected:受保护,本类,子类,同包类;
 * public:公开的,适用于任何类(不能跨项目使用)
 * @author Lenovo
 *
 */
public class Student01 {
	//结合day01.Test02类看
	private int password=567;
	String name="测试";
	public int age=18;
	protected int num=123;//学号
	//year变量在day01.Test02调用
	public int year=2020;
	
	private void test(){
		System.out.println(password);
	}
	
	protected void test01(){
		test();
		System.out.println("我是test01方法");
	}
}
