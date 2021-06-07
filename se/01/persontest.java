package day01;

import java.util.Arrays;

public class persontest {
	public static void main(String[] args) {
		person person = new person("张三",12,10000,false);//分配地址空间              
		person =    new person("张三1",12,10000,false);
		person.sleep("李四",12);
		//继承  （extends）目的：重写方法
		//方法调用一般都要传参数
		//普通方法可以反复调用 构造方法调用一次生成一个新对象 构造方法调用必须使用new 
		System.out.println(person);
		System.out.println("-------------");
	    System.out.println(person);
		String str = new String("abc");
		System.out.println(str);
         str  ="def";	
         System.out.println(str);
         int[] a = new int[10];
         System.out.println(a[0]);
         int[] b = {1,2,3,4,6};
         //变成字符串输出
         //静态 static  类名直接调用   静态方法属于整个类所有 只有一份 （公用
         //非静态 对象调用  一个对象一份 （私有）
         //封装了数组操作的方法
         System.out.println(Arrays.toString(b));
        for(int i=0;i<b.length;i++)
        	System.out.println(b[i]);
	}
}
