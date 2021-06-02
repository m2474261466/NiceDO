package day07;
/**
 * 判断引用所指向的对象是否是该类型
 * 用instanceof关键字
 * @author Lenovo
 *
 */
public class MultiTypeDemo {
	public static void main(String[] args) {
		/*COO c=new COO();
		AOO a=new COO();
		AOO d=new DOO();
		
		if(c instanceof AOO){
			System.out.println("true AOO");
		}
		
		if(a instanceof AOO){
			System.out.println("a的引用指向了new COO()对象是AOO类型");
		}
		
		if(d instanceof AOO){
			System.out.println("true AOO");
		}
		
		if(d instanceof COO){
			System.out.println("true COO");
		}*/
		
		//类型大小关系: 父类>子类  接口>实现类
		AOO a2=new AOO();
		AOO o=new BOO();//向上造型,子类型转换为父类型(自动类转换)
		BOO o1=(BOO)o;//父类型转换子类型(引用o所指的对象就是BOO)
		Inter1 o2=(Inter1)o;//引用o所指的对象实现了Inter1
		Inter1 o3=o1;//自动类型转换
		
		//COO o3=(COO)o;//ClassCastException类型转换异常
		/*
		 * 判断类和类,类和接口是否有关系(也就是引用类型一样),
		 * 这个时候需要做判断用instanceof
		 */
		if(o instanceof COO){
			System.out.println("是");
		}
		
		if(o instanceof Inter1){
			System.out.println("o instanceof Inter1成立");
		}
		if(a2 instanceof BOO){//a2只是AOO类型,类型不会向下兼容
			System.out.println("BOO");
		}
		if(o3 instanceof BOO){
			System.out.println("o3 instanceof BOO");
		}
		
	}
}

interface Inter1{
	
}

class AOO{
	
}

class BOO extends AOO implements Inter1{
	
}

class COO extends AOO{
	
}

class DOO extends COO{
	
}