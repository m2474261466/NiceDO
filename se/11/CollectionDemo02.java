package day12;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合存放的是元素的引用
 * 
 * @author 24742
 *
 */
public class CollectionDemo02 {
    public static void main(String[] args) {
		Collection c=new ArrayList();
		Point p=new Point(2,3);
		c.add(p);
		System.out.println(c);
		p.setX(20);
		System.out.println(c);
	}
}
