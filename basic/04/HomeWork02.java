package day04;

import java.util.Scanner;

/**
 *   						*
						   ***
						  *****
						 *******
						*********
						 *******
						  *****
						   ***
						    *
 * 在控制台上显示一个菱形(如上图所示)
 * 分析:
 * 1.先求上半部分和中间
 * 2.第一步一共有size行
 * 3.输出空格:第一行是size-1个空格,第二行是size-2个空格...第i行是size-i个空格
 * 4.输出"*":第一行是1*2-1个"*",第2行是2*2-1个"*",第i行是2*i-1个"*"
 * @author Lenovo
 *
 */
public class HomeWork02 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入菱形的大小");
		int size=scanner.nextInt();
		//输出菱形的上半部和最中间的一行
		for(int i=1;i<=size;i++){//行
			for(int j=0;j<size-i;j++){//输出空格
				System.out.print(" ");
			}
			for(int k=0;k<2*i-1;k++){//输出"*"
				System.out.print("*");
			}
			System.out.println();//换行
		}
		//输出菱形的下半部
		for(int i=size-1;i>0;i--){
			for(int j=0;j<size-i;j++){//输出空格
				System.out.print(" ");
			}
			for(int k=0;k<2*i-1;k++){//输出"*"
				System.out.print("*");
			}
			System.out.println();//换行
		}
		
		
	}
}
