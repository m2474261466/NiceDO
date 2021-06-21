package day12;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 判断当前集合是否包含给定的元素
 * @author 24742
 *
 */
public class CollectionDemo04 {
	 public static void main(String[] args) {
		Collection c=new ArrayList<>();
		c.add(new Point(3,4));
		c.add(new Point(6,9));
		c.add(new Point(1,5));
		c.add(new Point(4,8));
		System.out.println(c);
		/*
		 * 集合会将给定元素与集合元素进行equals比较，若有比较为true的则集合包含该元素
		 * （tips:该比较方法是逐个比较）
		 */
		Point p=new Point(1,5);
		boolean b=c.contains(p);
		System.out.println(b);
		
	}

}
