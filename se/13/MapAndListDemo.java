package day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * ģ����Ʒ���ࣺ
 * һ����Ʒ���ࣺ���õ���
 * ������Ʒ���ࣺ���ӡ�����ϴ�»����յ����������
 * ������Ʒ���ࣺ���ӣ�ƽ����ӡ���ͥӰ����������ϴ�»����Կ��ű��䡢ϴ��һ��������յ����ڹ�ʽ�յ�������ʽ�յ���
 *                �����������������������ȩ��
 */
public class MapAndListDemo {
    public static void main(String[] args) {
    	
    	//һ������
	      List<String> list1=new ArrayList<String>();
		list1.add("���õ���");
		//��������
		List<String> list2=new ArrayList<String>();
		list2.add("����");
		list2.add("����ϴ�»�");
		list2.add("�յ�");
		list2.add("�������");
		//��������
		List<String> list3=new ArrayList<String>();
		list3.add("ƽ�����");
		list3.add("��ͥӰ��");
		list3.add("�Կ��ű���");
		list3.add("ϴ��һ���");
		list3.add("�ڹ�ʽ�յ�");
		list3.add("����ʽ�յ�");
		list3.add("������");
		list3.add("������ȩ");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("one",list1);
		map.put("two", list2);
		map.put("three", list3);
		//System.out.println(map);
		Set<Entry<String,Object>> entry=map.entrySet();
		for(Entry<String,Object> e:entry){
			String key=e.getKey();
			System.out.println(key);
			List<String> listValue=(List<String>)e.getValue();
			for(String v:listValue){
				System.out.println(v);
			}
		}
		
		
	}
}
