package day05;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 二维数组:
 * 如果一维数组中的各个元素仍然是一维数组,那么它就是一个二维数组,二维数组常用于
 * 表示表,表中的信息以行和列的形式组成,第一个下标代表元素所在的行,第二个下标代表的元素所
 * 在的列
 * @author Lenovo
 *
 */
public class ArrayDemo05 {
	public static void main(String[] args) {
		/*
		 * 二维数组的声明:
		 * 类型[][] 名称;
		 * 
		 * 二维数组里存放的一组数组:
		 * 类型[][] 名称={数组1,数组2,数组3,数组n};
		 */
		int[] arr={2,3,4,5};
		//二维数组的声明并初始化
		int[][] arr01={{2,3,4,5},{6,7,8,9}};
		//二维数组的声明
		int[][] arr02=new int[2][4];
		//二维数组的长度一般指的的是行,用.length
		int n=arr01.length;
		System.out.println("二维数组的长度:"+n);
		//arr01二维数组中的第二行元素的长度
		int n1=arr01[1].length;
		System.out.println("arr01二维数组中的第二个元素的长度:"+n1);
		//获取二维数组中的元素,获取arr01的二维数组中的第1行元素的第3个元素
		System.out.println(arr01[0][2]);
		//给二维数组中的元素赋值
		arr01[1][1]=11;
		System.out.println(arr01[1][1]);
		/*
		 * 用户输入两个整数分别代表行和列并以空格隔开,
		 * 每一行随机生成的整数存入数组中
		 */
		Scanner scanner=new Scanner(System.in);
		Random random=new Random();
		System.out.println("请输入两个整数分别代表行和列并以空格隔开:");
		int row=scanner.nextInt();//行
		int column=scanner.nextInt();//列
		int[][] arr03=new int[row][column];//声明二维数组
		for(int i=0;i<arr02.length;i++){//行输入
			for(int j=0;j<arr02[i].length;j++){//列输入
				arr03[i][j]=random.nextInt(101);//随机生成0-100的整数赋值给二维数组arr03
			}
		}
		//二维数组的第一种输出:
		for(int i=0;i<arr03.length;i++){
			System.out.println(Arrays.toString(arr03[i]));
		}
		//二维数组的第二种输出:
		/*for(int i=0;i<arr02.length;i++){//行输出
			for(int j=0;j<arr02[i].length;j++){//列输出
				System.out.print(arr03[i][j]+" ");//空格隔开
			}
			System.out.println();
		}*/
		
		
		
		
		
		
		
	}
}
