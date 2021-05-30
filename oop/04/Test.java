package day03;
/**
 * 重点:
 * 演示成员变量和局部变量在内存分布及其生命周期
 * 可参考ykt201911OOP/day03_Leftcycle(重点).png的图片
 * 成员变量和局部变量
   成员变量和局部变量的差别如下:
    局部变量:1.定义在方法中 
		     2.没有默认值,必须自己设定初始值
		     3.方法被调用时,存在栈中,方法调用结束,从栈中清除.
	成员变量:
		     1.定义在类中,方法外.
		     2.有默认初始值,可以不用初始化
		     3.所在类被实例化后,存在堆中,对象被回收时,成员变量失效
 *
 *
 */
public class Test {
	int age=1;//成员变量
	
	public void show(){
		int age=6;//局部变量
		System.out.println(age);
	}
	
	public void show2(){
		System.out.println(age);
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		t=null;
		//t=new Test2();
		//t.show();
		//t.show2();
	}
	
}
