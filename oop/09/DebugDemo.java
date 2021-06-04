package day09;
/**
 * 演示Debug调试
 * @author Lenovo
 * 当程序的运行结果与你所预期的结果不同时:
 * 1.打桩: System.out.println(数据);
 * 2.Debug调试工具
 * 2.1 添加断点
 * 2.2 掌握4个键
 * 		1. F5:单步调试(会进入到方法中)
 * 		2. F6:逐步过程调试(不会进入到方法中,但是方法中若有断点还是会运行到该断点处)
 * 		3. F7:结束方法的调试
 * 		4. F8:直接跳到下一个断点(若后面没有断点则结束调试)
 * 会看两个东西:
 * 1.会看变量
 * 2.会添加监视(选中表达式,右键Watch-->Variables)
 */
public class DebugDemo {
	public static void main(String[] args) {
		int a=5;
		test(a);
		show();
	}

	private static void show() {
		System.out.println("aaa");
		System.out.println("bbb");
	}

	private static void test(int a) {
		int b=a+10;
		if(b>15){
			System.out.println("b");
		}
	}
	
	
}
