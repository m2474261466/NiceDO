package day12;

import java.util.ArrayList;
import java.util.Collection;

/**
 * �жϵ�ǰ�����Ƿ����������Ԫ��
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
		 * ���ϻὫ����Ԫ���뼯��Ԫ�ؽ���equals�Ƚϣ����бȽ�Ϊtrue���򼯺ϰ�����Ԫ��
		 * ��tips:�ñȽϷ���������Ƚϣ�
		 */
		Point p=new Point(1,5);
		boolean b=c.contains(p);
		System.out.println(b);
		
	}

}
