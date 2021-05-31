package day04;
/**
 * 静态方法:
 * 	1.由static修饰
 * 	2.属于类,存储在方法区,只有仅有一份
 *  3.常常通过类名点静态方法去访问
 *  4.静态方法没有隐式this传递,所以在静态方法中不能直接访问实例成员(成员变量)
 *  注意:在本来中访问静态方法或者静态变量可以省略类名,如果跨类访问则必须是类名去访问
 *  静态变量或者静态方法
 * 何时用:方法的操作仅于参数相关与对象无关
 * 
 * @author 刘坤
 *
 */
public class DemoStaticMethod {
	
	int a;//成员变量
	static int b;//静态变量
	
	public void show(){
		System.out.println(this.a);
		System.out.println(DemoStaticMethod.b);
	}
	
	public static void show2(){
		/*
		 * 静态方法没有隐式this传递,没有this就意味着没有对象,
		 * 而实例变量a必须通过对象点访问,所以静态方法中不能直接访问实例成员(成员变量)
		 */
		//System.out.println(a);;
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		DemoStaticMethod d=new DemoStaticMethod();
		d.show();
		show2();
	}
		
}

class AOO{
	public void test(){
		System.out.println(DemoStaticMethod.b);
		DemoStaticMethod.show2();
	}
}
