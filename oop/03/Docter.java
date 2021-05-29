package day02;
/**
 * 派生类(子类)
 * @author Lenovo
 *
 */
public class Docter extends Person {
	String uiform;//制服
	
	public Docter(){
		super("刘医生", 20);
		uiform="白色制服";
		System.out.println("Person的子类Decoter的构造方法");
	}
	
	public void test(){
		System.out.println(age);//继承了父类的age属性/特征
	}	
	
	public void cure(){
		//super.sleep();//调用超类里的sleep方法
		//sleep();//调用派生类里的sleep方法
		System.out.println("我是医生每天穿个"+uiform+","+name);
	}
	
	//睡觉行为
	public void sleep(){
		System.out.println("我是Docter里的方法");
	}
	
	public static void main(String[] args) {
		/*
		 * 向上造型(重点):
		 * 1:超类型的引用指向派生类对象
		 * 2:能点"."出来什么,看引用类型
		*/

		Person docter=new Docter();//典型的多态(向上造型)
		//Docter d=(Docter)docter;//采用强制类型转换,将Person类型转换为Docter类型
		docter.sleep();
		Docter docter02=new Docter();
		//docter02.cure();//测试
	}
}
