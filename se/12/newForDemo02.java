package day12;

import java.util.ArrayList;
import java.util.Collection;

public class newForDemo02 {
           public static void main(String[] args) {
			Collection c=new ArrayList();
			c.add("one");
			c.add("two");
			c.add("three");
			c.add("four");
			for(Object s:c){
				System.out.println(s);
			}
		}
}
