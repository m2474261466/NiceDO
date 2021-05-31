package day04;
/**
 * static final:常量(应用率很高)
 * 1.必须声明同时初始化,类名点访问,不能被改变,并且可以通过类名直接访问
 * 2.建议:常量名所有字母都大写,多个单词用"_"分隔
 * 3.在编译时被自动替换为具体的值,效果很高
 * 4.何时用:一个数永远不变,而且反复的多次使用
 * @author 刘坤
 *
 */
public class DemoStaticFinal {
	final int age=20;//成员变量,有多少个对象就有多少个final int age=20;不能改变它的值
	static int a=30;//静态变量,只有一份,可以改变它的数值
	
	public static void main(String[] args) {
		/*
		 * 加载到BOO.class到方法区,PI一并存储在方法区中,到方法区中获取PI的值并输出
		 * 编译器在编译时将常量直接替换为具体的值,这样效率很高
		 * System.out.println(BOO.PI);相当于System.out.println(3.1415926);
		 */
		System.out.println(3.1415926);
		System.out.println(BOO.PI);
		//BOO.PI=45.68;//编译错误,原因是常量不能被改变
		
		System.out.println(BOO.USER_AGE);
	}
	
	public void test(){
		System.out.println(age);
	}
	
}

class BOO{
	public static final double PI=3.1415926;//常量,如果不写public修饰词,系统会自动添加public
	public static final int USER_AGE=18;
	
}