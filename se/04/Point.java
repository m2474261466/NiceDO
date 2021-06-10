package day03;

  public class Point {
   private int x;
   private int y;
  public Point() {
	super();
	// TODO Auto-generated constructor stub
}
public Point(int x, int y) {
	super();
	this.x = x;
	this.y = y;
          }
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + x;
	result = prime * result + y;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Point other = (Point) obj;
	if (x != other.x)
		return false;
	if (y != other.y)
		return false;
	return true;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
@Override
public String toString() {
	return "Point [x=" + x + ", y=" + y + "]";
}


/**
 * 重写Object类中的equals(Object obj)方法，重写equals的目的是定义当前对象与给定参数对象比较内容，
 * 在实际应用中，一般需要重写该方法，通常比较对象的成员属性值
 */
 /*    public boolean equals(Object obj){
    	 if(obj==null){
         System.out.println("带吓唬");
         return true;
    	 }
    	 if(this==obj){//判断引用地址是否指向同一个对象
    		 System.out.println("interesting");
    		 return true;
    	 }
    	 if(obj instanceof Point){//判读对象的类型是否一样，如果一样再比较对象中成员属性的值
    		 Point p=(Point)obj;
    		 System.out.println("u are right");
    		 return  this.x==p.x&&this.y==p.y;
    		 
    	 }
    	 return false;
     }*/

          

   
}
