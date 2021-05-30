package day03;

public class DemoOverride_1 extends DemoOverride{
	//重写父类中的方法
	public void test(){
		System.out.println("子类中的test()方法");
	}
	
	//子类的单独方法
	public void test1(){
		System.out.println("子类的test1()方法");
	}
	
	//基本类型时,必须相等
	public int test2(){
		System.out.println("子类的test2()方法");
		return 1;
	}
	
	//
	public DemoOverride_1 test3(){
		System.out.println("子类中的test3()方法");
		return new DemoOverride_1();
	}
	
	/*private void test4(){//编译错误,原因是子类的访问权限小于了父类的访问权限
		System.out.println("父类中的test4()方法");
	}*/
	
	public void test4(){
		System.out.println("父类中的test4()方法");
	}
	
	public static void main(String[] args) {
		/*DemoOverride d1=new DemoOverride();
		d1.test();*/
		
		//向上造型
		//方法的重写特点:能点出来什么看引用类型,调用方法看对象类型
		DemoOverride d=new DemoOverride_1();
		d.test();
		d.test2();
		d.test3();
		d.test4();
	}
}
