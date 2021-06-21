package day12;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合框架：
 * java.util.Collection
 * Collection是所有集合的顶级接口，规定了所有集合都有点的方法；
 * 
 * 
 * Collection下面有两个常见的子接口
 * java.util.List  可重复且有顺序
 * java.util.Set 不可重复且无序，判断元素是否重复，靠自身的equals比较的结果而定
 * @author 24742
 *
 */
public class CollectionDemo {
      public static void main(String[] args) {
    	  Collection c=new ArrayList();
          /*
           * Collection提供了add()方法，添加元素在集合中，
           * 成功返回true，否则返回false
           */
    	 boolean b= c.add("one");
    	 System.out.println(b);
    	 c.add("twp");
    	 c.add("three");
    	 c.add("four");
    	 c.add("five");
    	 //求集合c中的长度，Collection提供了size()方法
    	 //size()方法是集合长度，而.length是数组的长度
    	 int s=c.size();
    	 System.out.println(s);
    	 
    	 /*
    	  * boolean isEmpty()判断当前集合是否为空
    	  * 当集合不含有任何元素的时候返回true
    	  */
		
    	 boolean empty=c.isEmpty();
    	 System.out.println(empty);
    	 /*
    	  * 移除集合中的元素
    	  */
    	 c.remove("one");
    	 System.out.println("移除集合元素的长度"+c.size());
    	 System.out.println(c);//输出集合c
    	 /*
     	 * 判断一个集合是否包含一个元素
     	 * boolean contains(Object o);
     	 */
    	 boolean boo=c.contains("two");
    	 System.out.println(boo);
    
    	 
    	 /*
    	  *清空集合中的元素void clear
    	  * 
    	  */
    	 c.clear();
    	 System.out.println("集合清空了");
    	 System.out.println(empty);
    	 System.out.println(c.size());
    	
    	 
    	
    	 
	}
}
