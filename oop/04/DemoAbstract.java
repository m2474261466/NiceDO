package day03;
/**
 * 抽象方法演示:
 * 1.由abstract修饰
 * 2.只有抽象方法的定义,没有具体的实现(连{}也没有)
 *  抽象类:
 *  1)由abstract修饰
 *  2)包含抽象方法的类必须是抽象类,不包含抽象方法的类也可以声明为抽象类(不实用)
 *  3)抽象类是不能被实例化的
 *  4)抽象类是需要被继承的,派生类:必须重写抽象类中的所有抽象方法,变不完整为完整
 *  抽象类的意义:
 *  	1.封装派生类所有的属性和行为(代码复用)
 *  	2.为所有派生类提供统一的类型----向上造型
 *  	3.可以包含抽象方法,为所有派生类提供统一的入口,派生类的行为不一样,但是入口是一致的.
 * @author Lenovo
 *
 */
public abstract class DemoAbstract {
	
	public abstract void test();//抽象方法(不完整的一个方法)
	
	public abstract void test2();

	public static void main(String[] args) {
		//DemoAbstract d=new DemoAbstract();//编译错误,抽象类不能被实例化
		//DemoAbstract a=new AOO();
		//a.test();
		
	}

}

class AOO extends DemoAbstract{
	//子类重写父类中的抽象方法,变不完整为完整
	public void test(){
		System.out.println("子类重写父类中的抽象方法");
	}
	
	public void test2(){
		
	}
	
	
}