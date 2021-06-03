package day08;

import java.util.Arrays;

public class ArrayCopy {
	public static void main(String[] args) {
		int[] a=new int[]{1,2,3};
		Arrays.copyOf(a, a.length+1);
		System.out.println(Arrays.toString(a));
		int[] b=Arrays.copyOf(a, a.length+1);
		System.out.println(Arrays.toString(b));
		b=Arrays.copyOf(b, b.length+a.length);//Êý×éÀ©ÈÝ
		System.out.println(b.length);
		System.arraycopy(a, 0, b, b.length-a.length, a.length); 
		System.out.println(Arrays.toString(b));
	}
}
