package day12;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合操作
 * @author 24742
 *
 */
public class CollectionDemo06 {
      public static void main(String[] args) {
		Collection c1=new ArrayList();
		c1.add("java");
		c1.add("c#");
		c1.add("C++");
		c1.add("js");
		System.out.println("c1:"+c1);
		Collection c2=new ArrayList();
		c2.add("windows");
		c2.add("macos");
		c2.add("Linux");
		System.out.println("c2:"+c2);
		/*
		 * boolean addAll(Collection c)
		 * 将给定集合元素添加到当前集合
		 */
		c1.addAll(c2);
		System.out.println("添加集合的C1:"+c1);
		
		Collection c3=new ArrayList();
		c3.add("windows");
		c3.add("macos");
		c3.add("Honmey");
		System.out.println("c3:"+c3);
		/*
		 * 删除集合C3中删除c3
		 * boolean(Collection c)当前集合中给定集合的公有元素
		 */
		c1.removeAll(c3);
		System.out.println("删除集合c3后的C1"+c1);
	}
}
