package day14;

import java.util.HashMap;
import java.util.Map;

public class MapDemo02 {
      public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("����",99);
		map.put("Ӣ��", 100);
		map.put("��ѧ", 95);
		/*�жϵ�ǰMap�Ƿ����������Key��valueֵ
		* Map�ṩ�˷���Boolean containKey()����boolean����
		*/
		boolean h=map.containsKey("��ѧ");
		System.out.println(h);
		boolean b1=map.containsValue(94);
		System.out.println(b1);
	}
}
