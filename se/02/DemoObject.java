package day02;
/**
 * Object (顶级父类)
 * 所有的类都有一个父类叫Object，默认的父类事java.lang.object
 * Object类型的引用变量可指向任何对象（向上造型）；
 * Object 常见方法：
 * toString()返回一个String类型，该方法意义是当前对象转换为一个字符串
 * Object已经实现该方法，返回的字符串是当前对象的句柄（引用），
 * 格式为包名，类名@散列码
 * 该字符串在实际开发中意义不大，所以通常需要使用这个方法时重写
 * toString（）方法时非常有用的调试工具（一般返回的是类中的成员变量）
 * 强烈建议自定的对象都要重写toString()方法
 * 
 * @author 24742
 *
 */

public class DemoObject {
	 public static void main(String[] args) {
		Person p=new Person();
		p.setAge(30);
		p.setName("liuhua");
		System.out.println(p);
		//System.out.println(任意对象);//直接调用toString()方法
	}

}
