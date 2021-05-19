package day06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入两个矩阵，分别是m*s，s*n大小。输出两个矩阵相乘的结果。
  输入格式
　　第一行，空格隔开的三个正整数m,s,n（均不超过200）。
　　接下来m行，每行s个被空格隔开的整数，表示矩阵A（i，j）。
　　接下来s行，每行n个被空格隔开的整数，表示矩阵B（i，j）。
  输出格式
　　m行，每行n个空格隔开的整数，输出相乘後的矩阵C（i，j）的值。
  样例输入
  2 3 2
  1 0 -1
  1 1 -3
  0 3
  1 2
  3 1
  样例输出
  -3 2
  -8 2

  提示
  矩阵C应该是m行n列，其中C(i,j)等于矩阵A第i行行向量与矩阵B第j列列向量的内积。
  例如样例中C(1,1)=(1,0,-1)*(0,1,3) = 1 * 0 +0*1+(-1)*3=-3

 * @author Lenovo
 *
 */
public class ArrayDemo02 {
	public static void main(String[] args) {
		/*String str="a b c d e f";
		//split(regex):把字符串用"regex"分割,并且返回一个String[](数组)类型
		String[] arrStr=str.split(" ");
		System.out.println(arrStr[4]);
		//字符串(String)类型转换为int类型
		int b=Integer.parseInt(arrStr[4]);
		System.out.println(b);*/
		//1.第一行，空格隔开的三个正整数m,s,n（均不超过200）。
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入空格隔开的三个正整数:");
		String str=scanner.nextLine();
		//把字符串用空格隔开,返回String[]类型
		String[] arrStr=str.split(" ");
		//将隔开的字符串转换为int类型
		int m=Integer.parseInt(arrStr[0]);
		int s=Integer.parseInt(arrStr[1]);
		int n=Integer.parseInt(arrStr[2]);
		//2.m行，每行s个被空格隔开的整数
		int[][] arr01=new int[m][s];
		int[][] arr02=new int[s][n];
		for(int i=0;i<m;i++){//行
			System.out.println("请输入"+s+"个整数并用空格隔开:");
			String stt=scanner.nextLine();
			String[] arrStt=stt.split(" ");
			//System.out.println(Arrays.toString(arrStt));//输出字符串数组arrStt01
			//把用户输入的字符串分解并放在arr01的二维数组中
			for(int j=0;j<arrStt.length;j++){//列
				arr01[i][j]=Integer.parseInt(arrStt[j]);
			}
			//打印每一行的数组
			System.out.println(Arrays.toString(arr01[i]));
		}
		//3.s行，每行n个被空格隔开的整数
		for(int i=0;i<s;i++){//行
			System.out.println("请输入"+n+"个整数并用空格隔开");
			String stt02=scanner.nextLine();
			String[] arrStt02=stt02.split(" ");
			//System.out.println(Arrays.toString(arrStt02));//输出字符串数组arrStt02
			//把用户输入的字符串分解并放在arr02的二维数组中
			for(int j=0;j<arrStt02.length;j++){//列
				arr02[i][j]=Integer.parseInt(arrStt02[j]);
			}
			System.out.println(Arrays.toString(arr02[i]));			
		}
		//4.矩阵相乘,输出结果
		for(int i=0;i<m;i++){//行
			for(int j=0;j<n;j++	){//列
				int sum=0;//每一行*每一列的和
				for(int k=0;k<s;k++){
					sum+=arr01[i][k]*arr02[k][j];
				}
				System.out.print(sum+" ");//每一行中的每一列用空格隔开
			}
			System.out.println();//换行
		}
		
		
		
	}
}
