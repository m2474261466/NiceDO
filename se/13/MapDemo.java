package day14;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map接口
 * Map称之为查找表，该数据结构体现的样子是一个“多行两列的表格”
 * 左列为key，右列为value
 * Map总是根据key查找相对应的value，存储元素也要求key-value成对存入
 * 
 * 
 * 常见的实现类：java.util.HashMap 哈希表
 * HashMap是基于散列算法实现的Map，也是当今世界上最快的查询结构
 * @author 24742
 *
 */
public class MapDemo {
         public static void main(String[] args) {
			Map<String,Integer> map=new HashMap<String,Integer>();
			//给map中存储元素
			/*
			 * map提供了存储元素的方法put(key,value)
			 * Map有一个要求，key不允许重复（key的equals比较而决定），
			 *若使用Map已有的key存入value则是替换value值，那么put方法
			 *返回的就是被替换的value，若没有替换返回null，在这里返回类型
			 *切记应该是包装类型Integer，否则会发生空指针异常
			 */
			Integer n=map.put("语文", 95);
		    n=map.put("语文",99);
			System.out.println(n);
			System.out.println(map);
			map.put("数学", 100);
			map.put("英语", 95);
			map.put("物理", 99);
			//Map集合的长度
			System.out.println(map.size());
			System.out.println(map);
			/*
			 * 根据给定的key获取对应的value，若给定的key不存在则返回null，
			 * Map提供了获取value值的方法get(Key k)
			 */
			//查看物理成绩
			Integer w=map.get("物理");
			System.out.println(w);
			/*
			 * 删除当前Map中给定的key所对应得这组键值对，返回值为key所对应的value值
			 * 如果给定得Key不存在，则返回null
			 * Map提供了删除元素的方法remove（Key k）
			 * 
			 */
			Integer y=map.remove("英语");
			System.out.println("长度"+map.size()+"删除后的Map集合"+map);
			System.out.println(y);
			
			
			
			
	}
}
