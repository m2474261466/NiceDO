package day12;

import java.util.ArrayList;
import java.util.Collection;

public class NewForDemo2 {
	public static void main(String[] args) {
		Collection c=new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		
		//ʹ����ǿforѭ������
		for(Object p:c){
			System.out.println(p);
		}
	}
}
