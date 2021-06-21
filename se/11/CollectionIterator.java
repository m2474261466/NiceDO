package day12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * Iterate iterator()
 * 该方法可以获取一个用于遍历当前集合元素的迭代器实现类，
 * 不同的集合实现类都提供了一个可以用于遍历自身的迭代器，
 * 我们不需要记住每种迭代器实现类的名字，需要Iterate接口并用迭代方法遍历即可。
 * 
 * 迭代器遍历集合遵循：问，取，删的遍历过程，其中删除元素不是必须要操作
 * @author 24742
 *
 */
public class CollectionIterator {
    public static void main(String[] args) {
    	Collection c1=new ArrayList();
		c1.add("java");
		c1.add("c#");
		c1.add("C++");
		c1.add("js");
        System.out.println("c1:"+c1);
        /*返回true否则返回false
         * 如果返回true还提供了一个方法next()取出集合中的元素
         */
        //创建迭代器的实例
        Iterator it=c1.iterator();
        while(it.hasNext()){//问
        	Object obj=it.next();//取
        	//删除集合中的js元素
        	if("js".equals(obj)){
        		/*
        		 * 迭代器要求在遍历的过程中不允许通过集合(同一类型)的方式增删元素，
        		 * 否则会抛出异常，删除元素可以通过迭代器提供的remove()方法。
        		 * 删除的是本次通过的next()方法迭代的元素
        		 * 
        		 */
        		//c1.remove(obj);用集合提供的remove(Object obj)删除会抛出异常
        		it.remove();
        	}
        	System.out.println("输出c1中的元素"+obj);//输出集合中的元素
        	
        }
        System.out.println("删除集合c1中的js:"+c1);
	}
}
