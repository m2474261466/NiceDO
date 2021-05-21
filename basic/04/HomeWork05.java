package day04;

import java.util.Scanner;

/**
 * 编写程序判断某一个年份是否为闰年(使用if-else)
 * 
 * 闰年:年份可以被4整除而且不能被100整除或者年份可以被400整除
 * @author Lenovo
 *
 */
public class HomeWork05 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入年份,例如:2012");
		int year=scanner.nextInt();
		if((year%4==0 && year%100!=0)|| year%400==0){
			System.out.println(year+"是闰年");
		}else{
			System.out.println(year+"不是闰年");
		}
	}
}
