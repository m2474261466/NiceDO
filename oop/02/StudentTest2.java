package day01;
/**
 * 引用类型画等号和基本数据类型画等号区别:
 * 引用类型画等号:
 * 1)指向同一对象
 * 2)通过一个引用的修改会影响到另一个引用
 * 基本数据类型画等号:
 * 1)赋值
 * 2)对一个变量的修改不会影响到另一个变量
 * @author Lenovo
 *
 */
public class StudentTest2 {
	public static void main(String[] args) {
		/*
		 * zs和zss指向的同一个对象,所以只有一个对象
		 */
		Student zs=new Student();
		Student zss=zs;
		zs.age=20;zss.age=28;//zs.age=? 28
		int a=5;
		int b=a;//把b的值赋值给a
		a=8;b=6;//a=? 8
		
	}
}
