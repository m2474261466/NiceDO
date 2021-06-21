package day12;
/**
 * 
 * 删除集合元素
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo5 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add(new Point(3, 4));
		c.add(new Point(8, 9));
		c.add(new Point(6, 5));
		c.add(new Point(2, 1));
		
		Point p=new Point(2, 1);
		/*
		 * boolean remove（Object o）删除给定的元素，
		 * 集合删除元素是根据集合的顺序并且使用equals比较，
		 * 返回true表示删除成功，对于list集合而言，若存在
		 * 多个，则只删除一个。
		 */
		c.remove(p);
		System.out.println(c);
	}
}
