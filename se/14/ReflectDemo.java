package day16;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ���䣺
 * 1.Java�ṩ��һ��API
 * 2.�ṩ�˼��һ�������ڲ��ṹ���ֶ�
 * 3.����API����
 * 3-1.��̬������
 * 3-2.��̬��������
 * 3-3.��̬��������
 * 3-4.��̬���÷���
 * @author 24742
 *
 */
public class ReflectDemo {
     public static void main(String[] args) {
	test("hasd");
		
	}

	private static void test(Object obj) {
		//ͨ��������Լ���Ӧ�����͵��ڲ��ṹ����̬��ȡobj����
		//Object���ṩ��һ������getClass()����һ��Clsaa��
		Class<? extends Object> cls=obj.getClass();
		//System.out.println(cls);
		/*
		 * ������������������Щ����
		 * Class���ṩ��getDeclarenFields();����һ��field[]����
		 * Declared:�����ģ��������˼
		 * Fields:�ֶΣ����Ե���˼
		 */
		Field[] field=cls.getDeclaredFields();
		for(Field f:field){
			//System.out.println(f);
		}
		/*
		 * ͨ�������ȡ������ָ��������
		 * Class���ṩ��getDeclaredField(String name) 
		 */
		try {
			Field fie=cls.getDeclaredField("hash");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * ͨ�������ȡ�����е����з���
		 * Class���ṩ��getDeclaredMethods()����
		 * Method[]����
		 * 
		 */
		Method[] methods=cls.getDeclaredMethods();
		//System.out.println(methods.length);
		for(Method m:methods){
			//System.out.println(m);
		}
		/*
		 * ͨ�������ȡ������ָ���ķ���
		 * Class���ṩ��getDeclareMethod(String name,parameterTypes)
		   name: ָ����������
		   type��ָ�÷����еĲ������ͣ�����Ƕ���������á���������
		    
		 */
		try {
			Method method=cls.getDeclaredMethod("valueOf", char.class,int.class,int.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		/*
		 * ͨ�������ȡ��������й��췽��
		 * Class���ṩ��getDeclaredConstructors()����Constructor[]
		 */
		Constructor[] cons=cls.getDeclaredConstructors();
		System.out.println(cons.length);
		for(Constructor<?> c:cons){
			System.out.println(c);
		}
	}
}
