package day05;

import java.util.Arrays;

/**
 * 扑克牌:
 * 扑克牌一共54张,把这54张扑克牌根据不同的花色
 * 通过数组的方式放入一个数组中并显示在控制台
 * 要求:花色为一个数组,扑克牌中的数字为一个数组
 * @author Lenovo
 *
 */
public class ArrayDemo04 {
	public static void main(String[] args) {
		//花色
		String[] colorArr={"红桃","黑桃","梅花","方块"};
		//扑克牌中的数字
		String[] number={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		//放扑克牌的数组
		//方法一:
		/*String[] newArr={};
		int index=0;//newArr的下标
		for(int i=0;i<colorArr.length;i++){//花色
			for(int j=0;j<number.length;j++){//数字
				//先对放扑克牌的数组扩容
				newArr=Arrays.copyOf(newArr, newArr.length+1);
				newArr[index++]=colorArr[i]+number[j];
			}
		}
		System.out.println(newArr.length);
		//最后放两个大小王
		newArr=Arrays.copyOf(newArr, newArr.length+2);
		newArr[newArr.length-2]="小王";
		newArr[newArr.length-1]="大王";
		System.out.println(Arrays.toString(newArr));*/
		
		//方法二:
		String[] newArr02=new String[54];
		for(int i=0;i<newArr02.length-2;i++){
			/*
			 * i/number.length:以13为一个循环,每赋值13次就换一个花色
			 * i%number.length:以13为一个循环,每次都换一个数字,13各数字为一轮
			 */
			newArr02[i]=colorArr[i/number.length]+number[i%number.length];
		
		}
		newArr02[newArr02.length-2]="小王";
		newArr02[newArr02.length-1]="大王";
		System.out.println(Arrays.toString(newArr02));
		
	}
}
