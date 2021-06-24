package day14;

import java.util.HashMap;
import java.util.Map;

public class MapDemo02 {
      public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("语文",99);
		map.put("英语", 100);
		map.put("数学", 95);
		/*判断当前Map是否包含给定的Key或value值
		* Map提供了方法Boolean containKey()返回boolean类型
		*/
		boolean h=map.containsKey("化学");
		System.out.println(h);
		boolean b1=map.containsValue(94);
		System.out.println(b1);
	}
}
