package day12;

import java.util.ArrayList;
import java.util.Collection;

/*
 * ���ϲ���
 */
public class CollectionDemo6 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add("java");
		c.add("c++");
		c.add("c#");
		c.add("js");
		System.out.println("c:"+c);
		
		
		Collection c1=new ArrayList();
		c1.add("wondows");
		c1.add("IOS");
		c1.add("Linux");
		System.out.println("c1:"+c1);
		/*
		 * boolean addAll(collection c)
		 * ����������Ԫ����ӵ���ǰ����
		 */
		c.addAll(c1);
		System.out.println("��Ӻ�ļ���c��"+c);
		
		Collection c2=new ArrayList();
		c2.add("wondows");
		c2.add("IOS");
		c2.add("hongmeng");
		System.out.println("c2:"+c2);
		/*
		 *�ڼ���c��ɾ������c2
		 *boolean removaAll(Collection c)
		 *ɾ����ǰ��������������ϵĹ���Ԫ��
		 */
		c.removeAll(c2);
		System.out.println("ɾ��c�е�c2Ԫ�أ�"+c);
	}
}
