package day01;

public class person {
	  //1.属性  静态   类 是不是一种数据类型 复合数据类型 抽象数据类型  即有属性又有方法
		 String name;
		//基本类型 
		private int age;
		private double salary;
		private boolean isMarried;
		//2.构造方法 可以有好多个 方法重载
		public person(String name,int age ,double salary,boolean isMarried) {
			this.age = age;
			this.name=name;
			this.salary = salary;
			this.isMarried= isMarried;
		}
		public person(String name,int age) {
			
			this.name = name;
			this.age = age;
		}
		//3.普通方法 动态
		public void sleep(String name) {
			System.out.println(name+"is sleeping");
		}
		
		
		public void sleep(String name,int age) {
			System.out.println(name+":"+age+"is sleeping");
		}
		
		
		
		
		public String toString() {
			
			return "名称:"+this.name+"年龄:"+this.age+"薪水:"+this.salary+"婚否:"+this.isMarried;
		}
		
}
