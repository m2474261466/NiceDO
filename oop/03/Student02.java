package day02;

public class Student02 {
	public void test(){
		Student01 s01=new Student01();
		//以下编译错误,Student01类中的password修饰词和test方法修饰词为private私有属性
		//System.out.println(s01.password);//私有变量不能在其他类使用
		//s01.test();//私有方法不能在其他类使用
	}
}
