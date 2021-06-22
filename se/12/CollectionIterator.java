package day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * Iterate iterator()
 * �÷������Ի�ȡһ�����ڱ�����ǰ����Ԫ�صĵ�����ʵ���࣬
 * ��ͬ�ļ���ʵ���඼�ṩ��һ���������ڱ�������ĵ�������
 * ���ǲ���Ҫ��סÿ�ֵ�����ʵ��������֣���ҪIterate�ӿڲ��õ��������������ɡ�
 * 
 * ����������������ѭ���ʣ�ȡ��ɾ�ı������̣�����ɾ��Ԫ�ز��Ǳ���Ҫ����
 * @author 24742
 *
 */
public class CollectionIterator {
    public static void main(String[] args) {
    	Collection c1=new ArrayList();
		c1.add("java");
		c1.add("c#");
		c1.add("C++");
		c1.add("js");
        System.out.println("c1:"+c1);
        /*����true���򷵻�false
         * �������true���ṩ��һ������next()ȡ�������е�Ԫ��
         */
        //������������ʵ��
        Iterator it=c1.iterator();
        while(it.hasNext()){//��
        	Object obj=it.next();//ȡ
        	//ɾ�������е�jsԪ��
        	if("js".equals(obj)){
        		/*
        		 * ������Ҫ���ڱ����Ĺ����в�����ͨ������(ͬһ����)�ķ�ʽ��ɾԪ�أ�
        		 * ������׳��쳣��ɾ��Ԫ�ؿ���ͨ���������ṩ��remove()������
        		 * ɾ�����Ǳ���ͨ����next()����������Ԫ��
        		 * 
        		 */
        		//c1.remove(obj);�ü����ṩ��remove(Object obj)ɾ�����׳��쳣
        		it.remove();
        	}
        	System.out.println("���c1�е�Ԫ��"+obj);//��������е�Ԫ��
        	
        }
        System.out.println("ɾ������c1�е�js:"+c1);
	}
}
