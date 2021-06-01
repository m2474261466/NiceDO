package day05;

import day05.Outer.StaticInner;

public class TestInnerClass {
	public static void main(String[] args) {
		//创建内部类对象(依赖外部类对象)
		//访问MemberInner中的method()方式一
		Outer.MemberInner m=new Outer().new MemberInner();
		m.method();
		
		//访问MemberInner中的method()方式二
		//Outer o=new Outer();
		//o.t();
		
		//创建静态内部类(不依赖外部类)
		StaticInner s=new StaticInner();
		s.method();
		
		Outer o=new Outer();
		o.m();
		
		Outer p=new Outer(){
			public void m(){
				System.out.println("我是匿名内部类");
			}
		};
		p.m();
		
	}
	
}

class Outer{
	private int a=30;
	private static int b=10;
	/*public void t(){
		//内部类只服务于外部类
		MemberInner m=new MemberInner();
		m.method();
	}*/
	
	//成员内部类
	class MemberInner{
		private int a=20;
		public void method(){
			int a=40;
			System.out.println("成员内部类");
			System.out.println("局部变量:"+a);
			System.out.println("成员内部类中的成员变量:"+this.a);
			System.out.println("外部类成员变量:"+Outer.this.a);
		}
	}
	
	//静态内部类
	static class StaticInner{
		private int x=10;
		public void method(){
			System.out.println("静态内部类");
			System.out.println(x);
			System.out.println(b);
			//System.out.println(a);//只能访问外部类的静态成员
		}
	}
	
	//局部内部类
	public void m(){//开始
		/*
		 * 局部变量不能加修饰词
		 */
		int x=50;//jdk1.8版本之前局部内部类访问局部变量的时候,必须要给局部变量使用final修饰
		class LocalInner{
			private int o=25;
			//private static int p=40;//在局部内部类中不能定义静态属性
			public void method(){
				System.out.println("局部内部类");
				System.out.println(o);
				System.out.println(a);
				System.out.println(b);
				System.out.println(x);
			}						
		}
		LocalInner l=new LocalInner();
		l.method();		
		
	}//结尾
	
	
	
	
	
}