package day07;
/**
 * 在JDK1.7版本之后推出在接口里面也可以用普通方法
 * 但是一定要在这个方法前面加"public static"或"default"
 * @author Lenovo
 *
 */
public interface Demo {
	default void test(){
		
	}
	
	public static int test01(){
		return 0;
	}
}
