package day14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map���ϵı���
 * Map���ϵı������������֣�
 * 1.�������е�key
 * 2.�������е�key-value
 * 3.�������е�value�������ã�
 * 
 * @author 24742
 *
 */
public class MapDemo03 {
     public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("��ѧ", 95);
		map.put("����",99);
		map.put("Ӣ��", 100);
		map.put("��ѧ", 95);
		/*
		 * Map�ṩ��Set setKey()����ǰmap�е�����key����һ������set�з���
		 * �������Set�����൱�ڱ��������е�key
		 * Set���������Ҳ����ظ�
		 */
		Set<String> set=map.keySet();
		for(String s:set){
			System.out.println(s);
		}
		/*��ȡ������map�����е�valueֵ
		 * Collection value����ǰmap���������е�value��һ�����ϵ���ʽ����
		 */
		Collection<Integer> c=map.values();
		for(Integer t:c){
			System.out.println(c);
		}
		/*���ص㣩
		 * ����ÿһ���ֵ��
		 * ��map�ӿڶ�����һ���ڲ��ӿ�java.util.Entry
		 * Map�ṩ��EntrySet()����Set<Entry>����
		 * Entry��ÿһ��ʵ�����ڵ�ǰmap�����е�һ���ֵ�ԣ����ṩ���������õķ�����
		 * 1.getkey����key��ȡkey��ֵ
		 * 2.getvlaue����value����ȡvalue��ֵ
		 *  
		 * 
		 */
		Set<Entry<String,Integer>> entry=map.entrySet();
		for(Entry<String,Integer> e:entry){
		String s=e.getKey();
		Integer i=e.getValue();
		System.out.println(s+","+i);
		}
		map.clear();
		//�ж�map�����Ƿ�Ϊ��
	System.out.println(map.isEmpty());
	}
}
