package day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * JDK1.5�汾֮���Ƴ���һ�����ԣ�����
 * ʲô�Ƿ��ͣ�
 * ����Ҳ��Ϊ���������ͣ�����������ָ��һ�����е��������ͣ���������������
 * �Լ�����ֵ���͵ȣ��������ĺô��ǽ����͵Ķ���Ȩ�����˵����ߣ�����������
 * ���ž��������������ԣ������ڼ����й㷺��ʹ�ã�����ָ�������е�Ԫ�����ͣ�
 * ����ָ�����ͣ���ָ��Ϊ��ԭ�͡���Object
 * 
 * ע�⣺�����е����Ͳ����ǻ������ͣ���Ϊ���ǲ��Ƕ��󣬱����û������͵İ�װ
 * ���ͣ���Ϊ��װ���;���ÿ�����͵Ķ���
 */
public class CollentionDemo7 {
	public static void main(String[] args) {
		Collection<String> c=new ArrayList<String>();
		/*
		 * �����÷������뷺�͵�Լ������ʱ������������ʵ�������Ƿ����
		 * �ò���ָ���ķ������ͣ������ϱ��벻ͨ�������ڵ�ǰ����ָ��Ϊstring
		 * ���ͣ���ô����add��������������ʵ�ʲ��������Ƿ�Ϊstring�������Ͼ�
		 * ����ʧ�ܡ�
		 */
		
		c.add("integer");
		c.add("double");
		c.add("short");
		//c.add(78);//�������,����string����ֻ�����string���ͣ��������int����
		
		for(String s:c){
			System.out.println(s);
		}
		
		Iterator<String> it=c.iterator();
		while(it.hasNext()){//��
			String s=it.next();//ȡ
			if(s.equals("short")){
				it.remove();
			}else{
				System.out.println(s);
			}
		}
	}
}
