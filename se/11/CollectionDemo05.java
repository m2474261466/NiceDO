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
         * boolean remove(Object o)ɾ��������Ԫ�أ�
         * ����ɾ��Ԫ���Ǹ��ݼ��ϵ�˳����ʹ��equals�Ƚϣ�
         *����true��ɾ���ɹ�������List���϶��ԣ������ڶ��ֻɾ��һ��
         */
		c.remove(p);
		System.out.println(c);
		
	}
}
