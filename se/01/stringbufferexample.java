package day01;

public class stringbufferexample {
	//为了解决 String 经常拼接效率比较低问题 StringBuffer/StringBuilder 
	//基于缓冲区操作
		//StringBuffer /StringBuilder 用法差不多，都是基于缓冲区操作
		//StringBuffer 线程安全  排队访问  100 99 98 安全  效率低
		//StringBuilder 线程不安全 100 效率高 不安全 
		//Thread/并发 （面试高频点）   Java thread  (操作系统 CPU)
		//计算中所有的硬件 程序都不能操作 通过操作系统
		public static void main(String[] args) {
			//16位
			// int[] a ={1,2,3,4} 在 2与3之间插入100 
			//查找 a[0] a[1]
			//JVM  JDK  java程序运行在JVM（java虚拟机）
			// 在操作系统上 window/linux /unix 装JDK -> eclipse
			//一次编译到处运行
			//兼容性非常好
			
			StringBuffer sb = new StringBuffer("a");
			StringBuilder sbi = new StringBuilder();
			sbi.append("ddddd");
			System.out.println(sbi);
			System.out.println(sb.length());//缓冲区中字符串的长度
			System.out.println(sb.capacity());//缓冲区的长度
	        sb.append(true);
	        sb.append(56.7);
	        sb.append("abc");
	        sb.append("ghi");
	        System.out.println(sb);
	        sb = new StringBuffer("first");
	        sb.insert(2, "bigData");
	        System.out.println(sb);
	        char [] chars = {'i','n','u','i'};
	        sb.insert(3,chars,2,2);//从sb第三个位置插入char数组的第二个元素开始的2个元素，
	        System.out.println(sb);
	        sb.setCharAt(0, 'P');
	        System.out.println(sb);
		}
}
