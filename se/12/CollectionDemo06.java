package day12;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ���ϲ���
 * @author 24742
 *
 */
public class CollectionDemo06 {
      public static void main(String[] args) {
		Collection c1=new ArrayList();
		c1.add("java");
		c1.add("c#");
		c1.add("C++");
		c1.add("js");
		System.out.println("c1:"+c1);
		Collection c2=new ArrayList();
		c2.add("windows");
		c2.add("macos");
		c2.add("Linux");
		System.out.println("c2:"+c2);
		/*
		 * boolean addAll(Collection c)
		 * ����������Ԫ����ӵ���ǰ����
		 */
		c1.addAll(c2);
		System.out.println("��Ӽ��ϵ�C1:"+c1);
		
		Collection c3=new ArrayList();
		c3.add("windows");
		c3.add("macos");
		c3.add("Honmey");
		System.out.println("c3:"+c3);
		/*
		 * ɾ������C3��ɾ��c3
		 * boolean(Collection c)��ǰ�����и������ϵĹ���Ԫ��
		 */
		c1.removeAll(c3);
		System.out.println("ɾ������c3���C1"+c1);
	}
}
