package day01;

import java.nio.charset.Charset;

public class Stringexample {
	public static void main(String[] args) {
		// 一般类都重写过toString
				String str = new String("abc");
				System.out.println(str.toString());
				// 一经创建 无法改变的内容
				// 引用 stack 栈 //对象 heap 堆
				String str1 = new String("def");
				// 字符串从0开始 为什么从零开始？
				str1 = "ghi你好";// 最常用 性能最高
				char a[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
				str1 = new String(a);
				System.out.println(str1);
				str1 = new String(a, 1, 3);
				System.out.println(str1);
				// byte short int long c
				// *.java ->*.class
				//编程的时候：1.语法错误 编译检查语法错误 IDE 帮我们解决 2. 逻辑错误（重点） 断点调试
				//ASCII
				//生成一个对象时，不要直接new 需要查文档（API）看一下源码
				//javaweb
				//代码的精髓 底层
				Charset charset = Charset.forName("UTF-8");
				byte bytes[] = { 97, 98, 99 };
				str1 = new String(bytes,charset);
				System.out.println("byte:"+str1);
				//final char
				String str4 = "dddff";
				System.out.println(str4);
				String str3 = "abc"+"def"+"hhh";//3个串拼接 变成新串
				System.out.println(str3);
				StringBuffer sb = new StringBuffer("def");
				sb.append("ddd");//缓冲区同一块区域
				String str2 = new String(new StringBuffer("dd"));
				System.out.println(str2+"abc"+12);
	}
}
