package day12;

import java.util.ArrayList;
import java.util.Collection;

/*
 * ���ϴ�ŵ���Ԫ�ص�����
 */
public class CollectionDemo2 {
	
	public static void main(String[] args) {
		Collection c=new ArrayList();
		Point p=new Point(2, 3);
		c.add(p);
		System.out.println(c);
		p.setX(20);
		System.out.println(c);
	}
}