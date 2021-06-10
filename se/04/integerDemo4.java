package day03;
/**
 * jdk1.5版之后退出一个新特性，自动拆装箱功能特性
 * 该特性是编译器认可，不是JVM。
 * 编译器在编译代码时遇到基本类型与包装类型相互转换时，会自动补全他们转换的代码
 * 这样做可以让我们在代码编写时不在考虑类型转换问题。
 * @author Thinkpad
 *
 */
public class integerDemo4 {
	public static void main(String[] args) {
		Integer p=3;
		int a=p;
		/*(拆)
		 * int a=p;
		 * 触发了自动拆装箱特性，编译会将代码改编为
		 * p.intValue();
		 */
		
		
		Integer i2=a;
		//Integer.valueOf(a);
		/*（装）
		 *integer i2=a;
		 *触发了自动拆装箱特性，编译会将代码改编为
		 *Integer.valueOf(a);
		 */
	}
}
