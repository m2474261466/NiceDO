package day12;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

/*
 * 判断当前集合是否包含给定的元素
 */
public class CollectionDemo4 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add(new Point(3, 4));
		c.add(new Point(8, 9));
		c.add(new Point(6, 5));
		c.add(new Point(2, 1));
		
		System.out.println(c);
		/*
		 * 集合会将给定元素与集合元素顺序进行equals比较，若有
		 * 比较为true的，则集合包含该元素。
		 */
		Point p=new Point(3,4);
		boolean b=c.contains(p);
		System.out.println(b);
	}
}
