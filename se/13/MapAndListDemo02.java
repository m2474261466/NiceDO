package day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapAndListDemo02 {
     public static void main(String[] args) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name","admin");
		map.put("Pwd","123456");
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		list.add(map);
		//������list�����е�Map������key��value
		for(Map<String,Object> w:list){//����list����
			Set<Entry<String,Object>> entry=map.entrySet();//��ȡmap���������еļ�ֵ��
			for(Entry<String, Object> s:entry){//����map���������еļ�ֵ��
				System.out.println(s.getKey()+s.getValue());
			}
		}
	}
}
