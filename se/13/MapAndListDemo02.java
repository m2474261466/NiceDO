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
		//遍历出list集合中的Map的所有key和value
		for(Map<String,Object> w:list){//遍历list集合
			Set<Entry<String,Object>> entry=map.entrySet();//获取map集合中所有的键值对
			for(Entry<String, Object> s:entry){//遍历map集合中所有的键值对
				System.out.println(s.getKey()+s.getValue());
			}
		}
	}
}
