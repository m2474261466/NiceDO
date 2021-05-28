package day01;
/**
 * 引用类型指向null时发生空指针异常
 * @author Lenovo
 *
 */
public class StudentTest3 {
	public static void main(String[] args) {
		Student zs=new Student();
		zs=null;
		zs.age=28;
		/*
		 * 发生空指针异常:引用类型为null,堆中的对象会被GC垃圾回收器
		 * 处理掉,因此堆中没有了这个对象,所以发生空指针异常
		 */
		System.out.println(zs.age);
	}
}
