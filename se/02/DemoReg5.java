package day02;

import java.util.Arrays;

public class DemoReg5 {
	public static void main(String[] args) {
		//ȥ�����пհ׸�
		String str="java    c++   c python";
		String[] arr=str.split("\\s+");
		System.out.println(Arrays.toString(arr));
		
		
		//ȥ��*-+=����
		String line="100*98-20+56=1016";
		String[] arr2=line.split("\\*|\\-|\\+|\\=");
		System.out.println(Arrays.toString(arr2));
		System.out.println(arr2[2]);
	}
}
