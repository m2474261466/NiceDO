package day12;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ���Ͽ�ܣ�
 * java.util.Collection
 * Collection�����м��ϵĶ����ӿڣ��涨�����м��϶��е�ķ�����
 * 
 * 
 * Collection�����������������ӽӿ�
 * java.util.List  ���ظ�����˳��
 * java.util.Set �����ظ��������ж�Ԫ���Ƿ��ظ����������equals�ȽϵĽ������
 * @author 24742
 *
 */
public class CollectionDemo {
      public static void main(String[] args) {
    	  Collection c=new ArrayList();
          /*
           * Collection�ṩ��add()���������Ԫ���ڼ����У�
           * �ɹ�����true�����򷵻�false
           */
    	 boolean b= c.add("one");
    	 System.out.println(b);
    	 c.add("twp");
    	 c.add("three");
    	 c.add("four");
    	 c.add("five");
    	 //�󼯺�c�еĳ��ȣ�Collection�ṩ��size()����
    	 //size()�����Ǽ��ϳ��ȣ���.length������ĳ���
    	 int s=c.size();
    	 System.out.println(s);
    	 
    	 /*
    	  * boolean isEmpty()�жϵ�ǰ�����Ƿ�Ϊ��
    	  * �����ϲ������κ�Ԫ�ص�ʱ�򷵻�true
    	  */
		
    	 boolean empty=c.isEmpty();
    	 System.out.println(empty);
    	 /*
    	  * �Ƴ������е�Ԫ��
    	  */
    	 c.remove("one");
    	 System.out.println("�Ƴ�����Ԫ�صĳ���"+c.size());
    	 System.out.println(c);//�������c
    	 /*
     	 * �ж�һ�������Ƿ����һ��Ԫ��
     	 * boolean contains(Object o);
     	 */
    	 boolean boo=c.contains("two");
    	 System.out.println(boo);
    
    	 
    	 /*
    	  *��ռ����е�Ԫ��void clear
    	  * 
    	  */
    	 c.clear();
    	 System.out.println("���������");
    	 System.out.println(empty);
    	 System.out.println(c.size());
    	
    	 
    	
    	 
	}
}
