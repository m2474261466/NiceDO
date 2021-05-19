package day06;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo002 {
	public static void main(String[] args) {
		//1.第一行，空格隔开的三个正整数m,s,n（均不超过200）。
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入空格隔开的三个整数");
		int m=scanner.nextInt();
		int s=scanner.nextInt();
		int n=scanner.nextInt();
		//System.out.println(m+" "+s+" "+n);//打桩,输出一下
		//2.m行，每行s个被空格隔开的整数
		int[][] arr01=new int[m][s];
		int[][] arr02=new int[s][n];
		for(int i=0;i<m;i++){//行
			System.out.println("请输入"+s+"个整数并用空格隔开:");
			for(int j=0;j<s;j++){//列
				arr01[i][j]=scanner.nextInt();
			}
			System.out.println(Arrays.toString(arr01[i]));
		}
		//3.s行，每行n个被空格隔开的整数
		for(int i=0;i<s;i++){//行
			System.out.println("请输入"+n+"个整数并用空格隔开:");
			for(int j=0;j<n;j++){//列
				arr02[i][j]=scanner.nextInt();
			}
			System.out.println(Arrays.toString(arr02[i]));
		}
		//4.矩阵相乘,输出结果
		for(int i=0;i<m;i++){//行
			for(int j=0;j<n;j++){//列
				int sum=0;//每一行*每一列的结果
				for(int k=0;k<s;k++){
					sum+=arr01[i][k]*arr02[k][j];
				}
				System.out.print(sum+" ");//每一行中的每一列用空格隔开
			}
			System.out.println();//换行
		}
		
		
		
		
		
		
		
	}
}
