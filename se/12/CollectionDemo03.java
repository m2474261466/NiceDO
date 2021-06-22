package day12;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo03 {
             public static void main(String[] args) {
				int a=5;
				String b="abc";
				Point p=new Point(2,4);
				Collection c=new ArrayList();
				c.add(p);
				dosome(a,b,p,c);
				System.out.println("a:"+a);
				System.out.println("b:"+b);
				System.out.println("c:"+c);
				System.out.println("p:"+p);
			
			}
        //局部变量的生命周期是方法开始到方法结束，最后由GC垃圾回收器不定时回收
             
			private static void dosome(int a, String b, Point p, Collection c) {
				a=a+3;
				b=b+4;
				p.setX(6);
				p=new Point(3,4);
				c.clear();
				c.add(p);
				c=new ArrayList();
				c.add(new Point(5,6));
				
				
			}
}
