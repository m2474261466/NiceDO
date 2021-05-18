package day05;

import java.util.Arrays;

/**
 * 杨辉三角
 * 
 * 
 * 			1			i=0	6-i-1
 *         1 1			
 *        1 2 1
 *       1 3 3 1
 *      1 4 6 4 1
 *     1 5 10 10 5 1
 * 
 * 分析:
 * 1.数组一共有n行
 * 2.第一行特殊,长度为一,且它没有上一行
 * 3.赋值杨辉三角每行两边的数为1
 * 4.赋值杨辉三角中间的数arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
 * 输出(它相当于输出菱形的上半部分,可以参考day04中Homework02的菱形输出):
 * 1.共有n行
 * 2.每一行的前面有n-1个空格
 * 
 * @author Lenovo
 * 
 * 
 */
public class ArrayDemo06 {
	public static void main(String[] args) {
		/*
		 * 给二维数组赋值
		 */
		//声明二维数组
		int[][] arr=new int[6][];
		for(int i=0;i<arr.length;i++){//行
			arr[i]=new int[i+1];
			/*
			 * 因为第一行是一个特殊的行,没有上一行
			 * 这个判断可有可无,复习前面的知识
			 */
			if(arr[i].length==1){//判断数组长度是否为1,第一行
				arr[i][0]=1;
				//或者arr[i]=new int[]{1};
				continue;
			}
			for(int j=0;j<i+1;j++){//从第二行开始循环的列
				if(j==0 || i==j){//每一行两边的整数均赋值1
					arr[i][j]=1;
				}else{//每一行中间的数
					arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
				}
			}
			
		}
		/*
		 * 排版:按照固定格式输出杨辉三角
		 */
		//输出二维数组arr中的每一行元素
		for(int i=0;i<arr.length;i++){
			System.out.println(Arrays.toString(arr[i]));
		}
		for(int i=0;i<arr.length;i++){//控制行输出的循环,数组下标是从0开始的
			for(int j=0;j<arr.length-i-1;j++){//控制输出每一行前面的空格数的循环
				System.out.print(" ");
			}
			for(int k=0;k<=i;k++){//每一行的所有整数
				//输出每一行中的每一列的整数并用空格隔开
				System.out.print(arr[i][k]+" ");
			}
			System.out.println();//换行
		}
		
		
		
		
		
		
	}
}
