package day02;

import java.util.Arrays;

public class DemoReg5 {
	public static void main(String[] args) {
		//去除所有空白格
		String str="java    c++   c python";
		String[] arr=str.split("\\s+");
		System.out.println(Arrays.toString(arr));
		
		
		//去掉*-+=符号
		String line="100*98-20+56=1016";
		String[] arr2=line.split("\\*|\\-|\\+|\\=");
		System.out.println(Arrays.toString(arr2));
		System.out.println(arr2[2]);
	}
}
