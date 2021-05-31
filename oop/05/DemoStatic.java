package day04;
/**
 * 静态变量:static
 * 静态方法:static
 * final:不能改变(变量) 不能重写(方法) 不能继承(类)
 * 
 * 常量:static final(重点 )
 * 
 * 演示静态块:
 * 	语法:static{}(重点)
 * 	1.由static修饰
 *  2.属于类,在类被加载期间自动执行的,只被加载一次,所以静态块只执行一次,
 *    比实例化对象要执行的快
 *  3.何时用:加载/初始化静态资源(图片,音频,视频等),所有对象共用的数据
 * @author 刘坤
 *
 */
public class DemoStatic {
	
	public DemoStatic(){
		System.out.println("构造方法");
	}
	
	static{//静态块
		System.out.println("静态块");
	}
	
	public static void main(String[] args) {
		DemoStatic d=new DemoStatic();
		DemoStatic d2=new DemoStatic();
		DemoStatic d3=new DemoStatic();
	}
	
}
