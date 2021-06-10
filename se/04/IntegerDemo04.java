package day03;
/**
 * JDK1.5版本之后推出的一个新特性，自动拆装箱特性，
 * 该特性是编译器认可，不是JVM。
 * 编译器在编译代码时遇到基本类型与包装类型互相转换时，会自动不去它们之间的转换的代码，
 * 这样做可以让我们在源代码中编写时不再考虑类型转换问题。
 * @author 24742
 *
 */
public class IntegerDemo04 {
	       public static void main(String[] args) {
			Integer i1=3;
			int a=i1;
			/*
			 * int a=i1;
			 * 触发了自动拆装箱特性，编译器会将代码改变为
			 * i1.intValue();
			 */
			Integer i2=a;
			/*
			 * Integer i2=a;
			 * 触发了自动拆装箱特性，编译器会将代码改变为
			 * Integer.valueof(a);
			 */
			
			
			
		}   
	     

}
