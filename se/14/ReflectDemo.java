package day16;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射：
 * 1.Java提供了一套API
 * 2.提供了检查一个对象内部结构的手段
 * 3.反射API可以
 * 3-1.动态加载类
 * 3-2.动态创建对象
 * 3-3.动态访问属性
 * 3-4.动态调用方法
 * @author 24742
 *
 */
public class ReflectDemo {
     public static void main(String[] args) {
	test("hasd");
		
	}

	private static void test(Object obj) {
		//通过反射可以检查对应的类型的内部结构，动态获取obj类型
		//Object类提供了一个方法getClass()返回一个Clsaa类
		Class<? extends Object> cls=obj.getClass();
		//System.out.println(cls);
		/*
		 * 检查对象下载声明了那些属性
		 * Class类提供了getDeclarenFields();返回一个field[]数组
		 * Declared:声明的，定义的意思
		 * Fields:字段，属性的意思
		 */
		Field[] field=cls.getDeclaredFields();
		for(Field f:field){
			//System.out.println(f);
		}
		/*
		 * 通过反射获取对象中指定的属性
		 * Class类提供了getDeclaredField(String name) 
		 */
		try {
			Field fie=cls.getDeclaredField("hash");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 通过反射获取对象中的所有方法
		 * Class类提供了getDeclaredMethods()返回
		 * Method[]数组
		 * 
		 */
		Method[] methods=cls.getDeclaredMethods();
		//System.out.println(methods.length);
		for(Method m:methods){
			//System.out.println(m);
		}
		/*
		 * 通过反射获取对象中指定的方法
		 * Class类提供了getDeclareMethod(String name,parameterTypes)
		   name: 指方法的名字
		   type：指该方法中的参数类型，如果是多个参数则用“，”隔开
		    
		 */
		try {
			Method method=cls.getDeclaredMethod("valueOf", char.class,int.class,int.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		/*
		 * 通过反射获取对象的所有构造方法
		 * Class类提供了getDeclaredConstructors()返回Constructor[]
		 */
		Constructor[] cons=cls.getDeclaredConstructors();
		System.out.println(cons.length);
		for(Constructor<?> c:cons){
			System.out.println(c);
		}
	}
}
