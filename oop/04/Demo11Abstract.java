package day03;
/**
 * 1.编写一个类中有三个抽象方法,并且用三个不同的类继承这个抽象类并执行方法体中的内容;
 * 最后我要提问:重写后的方法应该执行的是哪里的方法?如果子类没有重写父类的方法,
 * 执行后的方法应该是谁的方法
 * 父类指向子类也就是向上造型,能点出来看谁,点出来后方法体执行的是谁的方法体?
 * @author Lenovo
 *
 */
public abstract class Demo11Abstract {
	
	public abstract void test();
	
	public abstract void test2();
	
	public abstract void test3();
}
