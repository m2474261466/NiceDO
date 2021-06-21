package day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * JDK1.5版本之后推出了一个特性：泛型
 * 什么是泛型？
 * 泛型也称为参数化类型，它可以用于指定一个类中的属性类型，方法参数的类型
 * 以及返回值类型等，这样做的好处是将类型的定义权交给了调用者，而不是在提
 * 供着决定，提高了灵活性，泛型在集合中广泛被使用，用与指定集合中的元素类型，
 * 若不指定泛型，则指定为“原型”：Object
 * 
 * 注意：泛型中的类型不能是基本类型，因为他们不是对象，必须用基本类型的包装
 * 类型，因为包装类型就是每个类型的对象。
 */
public class CollentionDemo7 {
	public static void main(String[] args) {
		Collection<String> c=new ArrayList<String>();
		/*
		 * 当调用方法传入泛型的约束参数时，编译器会检查实例参数是否符合
		 * 该参数指定的泛型类型，不符合编译不通过，由于当前泛型指定为string
		 * 类型，那么调用add（）编译器会检查实际参数类型是否为string，不符合就
		 * 编译失败。
		 */
		
		c.add("integer");
		c.add("double");
		c.add("short");
		//c.add(78);//编译错误,泛型string类型只能添加string类型，不能添加int类型
		
		for(String s:c){
			System.out.println(s);
		}
		
		Iterator<String> it=c.iterator();
		while(it.hasNext()){//问
			String s=it.next();//取
			if(s.equals("short")){
				it.remove();
			}else{
				System.out.println(s);
			}
		}
	}
}
