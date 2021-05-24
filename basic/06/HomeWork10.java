package day04;

import java.util.Scanner;

/**
 * 1+1/2+1/3…+1/n（n>=2）。
 * 要求使用交互的方式计算此数列的和：
 * 用户在控制台录入需要计算的整数 n 的值，程序计算此数列的和，并在控制台输出结果。
 * @author Lenovo
 *
 */
public class HomeWork10 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一个大于等于2的整数");
		int n=scanner.nextInt();
		double sum=0.0;//总和
		for(int i=1;i<=n;i++){
			//注意:类型问题
			//错误写法:sum+=1/i;//i和1都是int类型的数,计算的结果就是取商
			sum+=1.0/i;
		}
		System.out.println(sum);
	}
}
