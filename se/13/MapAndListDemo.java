package day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * 模拟商品分类：
 * 一级商品分类：家用电器
 * 二级商品分类：电视、冰箱洗衣机、空调、生活电器
 * 三级商品分类：电视（平板电视、家庭影音）、冰箱洗衣机（对开门冰箱、洗烘一体机）、空调（壁挂式空调、立柜式空调）
 *                生活电器（吸尘器、净化除醛）
 */
public class MapAndListDemo {
    public static void main(String[] args) {
    	
    	//一级分类
	      List<String> list1=new ArrayList<String>();
		list1.add("家用电器");
		//二级分类
		List<String> list2=new ArrayList<String>();
		list2.add("电视");
		list2.add("冰箱洗衣机");
		list2.add("空调");
		list2.add("生活电器");
		//三级分类
		List<String> list3=new ArrayList<String>();
		list3.add("平板电视");
		list3.add("家庭影音");
		list3.add("对开门冰箱");
		list3.add("洗烘一体机");
		list3.add("壁挂式空调");
		list3.add("立柜式空调");
		list3.add("吸尘器");
		list3.add("净化除醛");
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
