package day12;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

/*
 * �жϵ�ǰ�����Ƿ����������Ԫ��
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
		 * ���ϻὫ����Ԫ���뼯��Ԫ��˳�����equals�Ƚϣ�����
		 * �Ƚ�Ϊtrue�ģ��򼯺ϰ�����Ԫ�ء�
		 */
		Point p=new Point(3,4);
		boolean b=c.contains(p);
		System.out.println(b);
	}
}
