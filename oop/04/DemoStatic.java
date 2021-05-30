package day03;
/**
 * 
 * 静态变量:
 * 1)由static 修饰
 * 2)属于类,存储在方法区,只有一份
 * 3)通常通过类名来访问
 * 4)何时用?所有对象所共享的数据(图片,音频,视频等)
 * 
 * 
 * 静态方法,静态类 明天讲
 *
 * @author Lenovo
 *
 */
public class DemoStatic {
	int a=1;//成员变量
	static int b=1;//静态变量
	public DemoStatic(){
		a++;
		b++;
	}
	
	public void show(){
		System.out.println("a="+this.a);
		System.out.println("b="+DemoStatic.b);
	}
	
	public static void main(String[] args) {
		
		System.out.println(DemoStatic.b);
		//System.out.println(DemoStatic.a);//因为a是成员变量在堆中,必须实例化后才可以访问
		
		DemoStatic demo=new DemoStatic();
		demo.show();
		
		DemoStatic demo2=new DemoStatic();
		demo2.show();
		
		DemoStatic demo3=new DemoStatic();
		demo3.show();
		
		
	}
}
