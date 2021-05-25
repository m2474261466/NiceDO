package day07;

import java.util.Scanner;

/**
 * 用户输入两个整数k,n(0<k<n)
 * 当k=0或者k=n,返回整数1
 * 当0<k<n时方法(k,n-1)+方法(k-1,n-1)
 * @author Lenovo
 *
 */
public class Method_dg02 {		
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入一个大于0的整数:");
		int k=scanner.nextInt();
		System.out.println("请输入一个大于"+k+"的整数");
		int n=scanner.nextInt();
		int result=dg(k,n);
		System.out.println(result);
	}
	
	public static int dg(int k,int n){//递归函数
		if(k==0 || k==n){//边界条件(递归停止条件)
			return 1;
		}else{
			return dg(k, n-1)+dg(k-1, n-1);
		}
	}
	
	
	
	
}
