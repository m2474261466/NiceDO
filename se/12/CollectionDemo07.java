package day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK1.5版本之后推出了一个特性：泛型
 * 什么是泛型？
 * 泛型也称为参数化类型，它可以用于指定一个类中的属性类型，方法参数的类型以及返回值类型等，
 * 这样的好处是将类型的定义权交给了调用者，而不是在提供者决定，提高了灵活性，泛型在集合中被广泛使用，用于指定集合中的元素类型，
 * 若不指定泛型，则默认为“原型”：Object
 * 
 * 注意：泛型中的类型不能是基本类型，因为他们不是对象，因为它们不是对象，必须用基本类型的包装类型
 * 因为包装类型就是每个类型的对象
 * 
 * @author 24742
 *
 */
public class CollectionDemo07 {
      public static void main(String[] args) {
		Collection<String> c=new ArrayList<String>();
		/*
		 * 当调用方法传入泛型的约束的参数时，编译器会检查实例参数是否符合该参数指定 的泛型类型，不符合编译不通过，由于当前泛型集合指定为
		 * String类型，那么调用add()时编译器会检查实际参数为String，不符合编译就失败
		 */
		c.add("integer");
		c.add("Double");
		c.add("Short");
		//c.add(85);//编译错误，泛型为String类型则只能添加String类型的数据

        for(String s:c){
        	System.out.println(s);
        }
		//通过迭代器遍历并删除集合中的short元素
        Iterator<String> it=c.iterator();
        while(it.hasNext()){
        	String s=it.next();
        	if(s.equals("Short")){
        	it.remove();
        	}
        }
		System.out.println(c);
		
		
		
		
		
		
		
		
		
		
	}
}
