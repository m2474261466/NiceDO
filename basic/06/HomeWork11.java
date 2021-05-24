package day04;

import java.util.Scanner;

/**
 * 质数问题:
 * 质数:只能被1或者自身整除的整数叫质数(又称之为素数);
 * 例如:2,3,5,7......
 * 合数:不但能被1或者自身整除而且还可以被其他整数整除,称合数;
 * 例如:4,6,8,9......
 * 1既不是质数也不是合数,因此自然数可以分为:质数,合数,1;
 * @author Lenovo
 *
 */
public class HomeWork11 {
	public static void main(String[] args) {
		/*
		 * 输出n-m之间的的素数,并求出质数和合数的个数
		 */
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入两个整数(并用空格隔开)");
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		int z=0;//质数的个数
		int h=0;//合数的个数
		for(int i=n;i<=m;i++){//n-m的范围
			boolean flag=true;
			for(int j=2;j<i;j++){
				if(i%j==0){//判断是否为质数,如果满足条件则为合数,将flag赋值为false,若不满足则flag的值不变
					flag=false;
					break;//若为合数直接跳出循环
				}
			}
			if(flag==true){
				z++;
				System.out.println(i+"是质数");
			}else{
				h++;
				System.out.println(i+"是合数");
			}
		}
		System.out.println("质数有:"+z+"个,合数有:"+h+"个");
		
		
				
		//判断n是整数还是合数
		for(int i=2;i<n;i++){
			if(n%i==0){
				System.out.println(n+"是合数");
				return;//return跳出该方法,本题是跳出main方法(第二行)
			}
		}
		System.out.println(n+"是质数");
		//利用"开关"判断n是整数还是合数
		boolean flag=true;
		for(int i=2;i<n;i++){
			if(n%i==0){
				flag=false;
			}
		}
		if(flag==true){
			System.out.println(n+"是质数");
		}else{
			System.out.println(n+"是合数");
		}
		
	}
}
