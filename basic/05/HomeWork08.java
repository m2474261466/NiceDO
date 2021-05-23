package day04;

import java.util.Scanner;

/**
 * 输出三个int数中的最大值(运用三目运算)
 * @author Lenovo
 *
 */
public class HomeWork08 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请分别输入三个数:");
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		int c=scanner.nextInt();
		/*
		 * 由于nextInt()底层后面跟了一个空格,而nextLine()
		 * 扫描用户的所有数据包包括空格,因此nextInt()底层后面跟了一个空格
		 * 被nextLine()误认为是用户输入的空格,所以nextLine()
		 * 已经获取到了数据(空格),也就不会出现阻塞了。
		 * next()方法读取到空白符就结束；nextLine()读取到回车结束
		 */
		System.out.println("请输入一个字符串:");
		String str=scanner.nextLine();//阻塞(等待用户输入)
		System.out.println("测试");
		System.out.println("请输入一个字符串:");
		String str1=scanner.next();
		System.out.println(str1);
		int max=(a>b?a:b)>c?(a>b?a:b):c;
		System.out.println("最大值是"+max);
	}
}
