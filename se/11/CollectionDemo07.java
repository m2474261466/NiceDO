package day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK1.5�汾֮���Ƴ���һ�����ԣ�����
 * ʲô�Ƿ��ͣ�
 * ����Ҳ��Ϊ���������ͣ�����������ָ��һ�����е��������ͣ����������������Լ�����ֵ���͵ȣ�
 * �����ĺô��ǽ����͵Ķ���Ȩ�����˵����ߣ����������ṩ�߾��������������ԣ������ڼ����б��㷺ʹ�ã�����ָ�������е�Ԫ�����ͣ�
 * ����ָ�����ͣ���Ĭ��Ϊ��ԭ�͡���Object
 * 
 * ע�⣺�����е����Ͳ����ǻ������ͣ���Ϊ���ǲ��Ƕ�����Ϊ���ǲ��Ƕ��󣬱����û������͵İ�װ����
 * ��Ϊ��װ���;���ÿ�����͵Ķ���
 * 
 * @author 24742
 *
 */
public class CollectionDemo07 {
      public static void main(String[] args) {
		Collection<String> c=new ArrayList<String>();
		/*
		 * �����÷������뷺�͵�Լ���Ĳ���ʱ������������ʵ�������Ƿ���ϸò���ָ�� �ķ������ͣ������ϱ��벻ͨ�������ڵ�ǰ���ͼ���ָ��Ϊ
		 * String���ͣ���ô����add()ʱ����������ʵ�ʲ���ΪString�������ϱ����ʧ��
		 */
		c.add("integer");
		c.add("Double");
		c.add("Short");
		//c.add(85);//������󣬷���ΪString������ֻ�����String���͵�����

        for(String s:c){
        	System.out.println(s);
        }
		//ͨ��������������ɾ�������е�shortԪ��
        Iterator<String> it=c.iterator();
        while(it.hasNext()){
        	String s=it.next();
        	if(s.equals("Short")){
        	it.remove();
        	}
        }
		System.out.println(c);
		
		
		
		
		
		
		
		
		
		
	}
}
