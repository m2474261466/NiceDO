package day14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map集合的遍历
 * Map集合的遍历方法有三种：
 * 1.遍历所有的key
 * 2.遍历所有的key-value
 * 3.遍历所有的value（不常用）
 * 
 * @author 24742
 *
 */
public class MapDemo03 {
     public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("化学", 95);
		map.put("语文",99);
		map.put("英语", 100);
		map.put("数学", 95);
		/*
		 * Map提供了Set setKey()将当前map中的所有key存入一个集合set中返回
		 * 遍历这个Set集合相当于遍历了所有的key
		 * Set集合无序且不能重复
		 */
		Set<String> set=map.keySet();
		for(String s:set){
			System.out.println(s);
		}
		/*获取并遍历map集合中的value值
		 * Collection value将当前map集合中所有的value以一个集合的形式返回
		 */
		Collection<Integer> c=map.values();
		for(Integer t:c){
			System.out.println(c);
		}
		/*（重点）
		 * 遍历每一组键值对
		 * 在map接口定义了一个内部接口java.util.Entry
		 * Map提供了EntrySet()返回Set<Entry>集合
		 * Entry的每一个实例用于当前map集合中的一组键值对，且提供了两个常用的方法：
		 * 1.getkey返回key获取key的值
		 * 2.getvlaue返回value，获取value的值
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
		//判断map集合是否为空
	System.out.println(map.isEmpty());
	}
}
