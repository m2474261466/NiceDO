package day12;

import java.util.ArrayList;
import java.util.Collection;

/*
 * 集合操作
 */
public class CollectionDemo6 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add("java");
		c.add("c++");
		c.add("c#");
		c.add("js");
		System.out.println("c:"+c);
		
		
		Collection c1=new ArrayList();
		c1.add("wondows");
		c1.add("IOS");
		c1.add("Linux");
		System.out.println("c1:"+c1);
		/*
		 * boolean addAll(collection c)
		 * 将给定集合元素添加到当前集合
		 */
		c.addAll(c1);
		System.out.println("添加后的集合c："+c);
		
		Collection c2=new ArrayList();
		c2.add("wondows");
		c2.add("IOS");
		c2.add("hongmeng");
		System.out.println("c2:"+c2);
		/*
		 *在集合c中删除集合c2
		 *boolean removaAll(Collection c)
		 *删除当前集合中与给定集合的共有元素
		 */
		c.removeAll(c2);
		System.out.println("删除c中的c2元素；"+c);
	}
}
