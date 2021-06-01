package day05;

public class TestAnonymousClass {
	
	public void test(){
		/*class DOO extends AOO{
			public void dream(){
				System.out.println("继承AOO类4");
			}
		}*/
		
		//演示匿名内部类,一种特殊的局部内部类
		AOO a=new AOO(){
			public void dream(){
				System.out.println("继承AOO类4");
			}
		};
		a.dream();
	}
	
	public static void main(String[] args) {
		TestAnonymousClass t=new TestAnonymousClass();
		t.test();
		
		/*AOO b=new BOO();
		b.dream();
		
		AOO b1=new COO();
		b1.dream();
		
		//匿名内部类语法:new 对象(){};
		AOO a=new AOO(){
			public void dream(){
				System.out.println("继承AOO类3");
			}
		};
		a.dream();*/
	}
	
	
	
}

abstract class AOO{
	public abstract void dream();
}

class BOO extends AOO{
	public void dream(){
		System.out.println("继承AAO类1");
	}
	
}

class COO extends AOO {
	public void dream(){
		System.out.println("继承AOO类2");
	}
}