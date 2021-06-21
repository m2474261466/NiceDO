package day12;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo05 {
      public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add(new Point(3,4));
		c.add(new Point(6,9));
		c.add(new Point(1,5));
		c.add(new Point(4,8));
		Point p=new Point(4,8);
		 /*
         * boolean remove(Object o)删除给定的元素，
         * 集合删除元素是根据集合的顺序并且使用equals比较，
         *返回true则删除成功，对于List集合而言，若存在多个只删除一个
         */
		c.remove(p);
		System.out.println(c);
		
	}
}
