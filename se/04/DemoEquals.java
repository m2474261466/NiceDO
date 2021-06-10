package day03;
/**
 * 顶级父类中的equals方法
 * equals(Other obj)；
 * 面试必考：
 * equals和==的区别
 * 1.==在基本类型中用于比较变量的值，如果用于引用类型，比较的是两个引用变量是否指向同一对象
 * 2.equals重写Object的equals方法，重写后可以用于比较对象的内容是否一样。
 * @author 24742
 *
 */
public class DemoEquals {
             public static void main(String[] args) {
				/*Point p =new Point();
				int a=9;
				int b=10;
				System.out.println(a==b);//false
				String str="abc";
				String s=str;
				System.out.println(s==str);//true
				
				
			   Point p1=new Point();
			   Point p2=p1;
			   System.out.println(p2==p1);//true
			   
			   
			   Point p3=new Point(5,6);
			   Point p4=new Point(5,6);
			   System.out.println(p3==p4);//false*/
				
            	 Point p3=new Point(5,6);
  			     Point p4=new Point(5,6);
  			    System.out.println(p3.equals(p4));//true
  			   
  			    
  			    
  			    
  			  Point p5=new Point(5,6);
			   Point p6=new Point(5,6);
			   System.out.println(p5.equals(null));//true
			   
			   
			   
				
				
				
				
			}
}
