package day08;

import java.util.Arrays;

public class TestInternal {
	
	public void test(int a,int b,Person person,String[] ss){
		a=a+18;//23 test中的局部变量
		b=b+20;//22 test中的局部变量
		System.out.println("局部变量:a="+a+",b="+b);//23 22
		person.setAge(2021);
		person=new Person(2020,"武汉");
		person.setAge(2029);
		System.out.println("局部变量中person对象的age为:"+person.getAge());//? 2029
		Arrays.copyOf(ss, ss.length+1);//复制作用
		ss[ss.length-1]="four";
		ss=Arrays.copyOf(ss, ss.length+1);
		System.out.println("局部变量中ss的长度:"+ss.length);//? 4
		ss[ss.length-1]="four";
		System.out.println("局部变量中ss的元素:"+Arrays.toString(ss));//? "one","two","four","four"
		ss=new String[0];
	}
	
	public static void main(String[] args) {
		int a=5;
		int b=2;
		Person person=new Person(2020, "中国");
		//String[] ss=new String[]{"one","two","three"};//声明数组
		String[] ss={"one","two","three"};
		TestInternal t=new TestInternal();
		t.test(a, b, person, ss);
		System.out.println(a);//? 5
		System.out.println(b);//? 2
		System.out.println(person.getAge());//? 2021
		System.out.println(ss.length);//? 3
		System.out.println(Arrays.toString(ss));//? "one","two","four"
		System.out.println(person.getName());//? "中国"
	}
}
