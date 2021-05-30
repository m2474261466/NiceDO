package day03;
/**
 * 重点:
 * 方法的重写(override):重新写,覆盖
 * 1.发生在父子类中,方法名称相同,参数列表相同,但是方法体不同
 * 2.重写方法被调用时,看对象的类型,能点出来看引用类型
 * 3.重写要遵循"两同两小一大"原则:
 *  3.1):两同:
 * 		3.1.1):方法名相同
 * 		3.1.2):参数列表相同
 *  3.2):两小:
 *  	3.2.1):void时,必须相等
 *  	3.2.2):基本类型时,必须相等
 *  	3.2.3):引用类型时,小于或等于超类(子类返回类型必须小于或等于超类的类型)不常用
 *  	3.2.4):派生类所抛出的异常小于或等于超类的异常(API讲)
 *  3.3)一大:
 *  	派生类的方法的访问权限大于或等于超类的权限.
 * .....
 * 
 * @author Lenovo
 *
 */
public class DemoOverride {
	public void test(){
		System.out.println("父类中的test()方法");
	}
	
	public int test2(){
		System.out.println("父类中的test2()方法");
		return 0;
	}
	
	public DemoOverride test3(){
		System.out.println("父类中的test3()方法");
		return new DemoOverride();
	}
	
	protected void test4(){
		System.out.println("父类中的test4()方法");
	}
}
