package day03;
/**
 * 由于基本类型没有面向对象的基本特征，为了它们参与到面向对象的开发中，
 * 1.java为这8基本类型提供了对应的包装类
 * 2.6个和数字相关的包装类继承了java.lang.Number
 * Number是Byte,Double,Float,Intege,Long,Short类的父类，
 * Number是一个抽象类，定义了不同类型的数字之间转换的方法，所以6个数字类型的包装类都是表示基本类型的转换。
 * 
 * Integer和int的区别
 * 1.Integer是int的包装类，int则是java的一种基本类型数据。
 * 2.Integer实例后才能使用，而int则不需要
 * 3.Integer实际是对应的引用，当new一个Integer时，实际上生成了一个对象，而int则时直接存数据
 * 4.Integer的默认值是null,可以接受null和int类型的数据；int默认值是0，不能接受null
 * 
 * 
 * @author 24742
 *
 */
public class IntegerDemo {
	   public static void main(String[] args) {
// Number是Byte,Double,Float,Intege,Long,Short类的父类
		Number n=555555;
		//获取n的类型
		System.out.println(n.getClass().getName());
//		将基本类型转换到包装类型
		int  a=3;
		int b=3;
		Integer i1=new Integer(a);
		Integer i0=new Integer(b);
		System.out.println(i1.getClass().getName());
		System.out.println(i1==i0);//flase
//		推荐使用包装类的静态方法
		Integer i2=Integer.valueOf(a);
		Integer i3=Integer.valueOf(a);
//		把包装类型转换为基本类型,在Integer类中提供了一个方法intValue（）可以把Integer类型转换为int类型
		int c=i2.intValue();
		System.out.println(c);
		
		
	}

}
