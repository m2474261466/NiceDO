package day01;

import java.nio.charset.Charset;

public class string {
	
	public static void main(String[] args) {
		//字符串一经创建，无法改变内容
		//方法一：
		String str=new String("der");
		System.out.println(str);
		
		//方法二：
		str="poi";
		System.out.println(str);
		
		//方法三：
		char[] a={'a','b','c','s','s'};
		str=new String(a);
		System.out.println(str);
		
		str=new String(a,1,3);
		System.out.println(str);
		
		Charset charset=Charset.forName("UTF-8");
		byte bytes[]={97,98,99};
		str=new String(bytes,charset);
		System.out.println("   "+str);
		
		
	}
}
