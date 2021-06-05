package test;
/**
 * 
 * 成员变量(全部变量)和局部变量区别
 * 1.成员变量有默认值,局部变量必须声明初始化(是在方法里)
   2.优先级:成员变量和局部变量同名时,局部变量更具有优先级(就近原则)
 * 
 * 3.生命周期不一样.....
 * 
 */
public class Demo2 {
	//成员变量
	int age;// 默认 0
	String name;//默认 null
	
	public void test(){
		//在方法里声明的变量必须时局部变量(必须声明并初始化)
		String address="西安";
		int age=20;
		System.out.println(age);
		System.out.println(address);
	}
	
	public static void main(String[] args) {
		Demo t=new Demo("3",12);
		Demo2 d=new Demo2();
		d.test();
		
	}
}
