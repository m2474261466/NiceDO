package day12;
/**
 * 
 * ɾ������Ԫ��
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
		 * boolean remove��Object o��ɾ��������Ԫ�أ�
		 * ����ɾ��Ԫ���Ǹ��ݼ��ϵ�˳����ʹ��equals�Ƚϣ�
		 * ����true��ʾɾ���ɹ�������list���϶��ԣ�������
		 * �������ֻɾ��һ����
		 */
		c.remove(p);
		System.out.println(c);
	}
}
