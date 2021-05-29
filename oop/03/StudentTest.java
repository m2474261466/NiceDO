package day02;

import java.util.Arrays;

public class StudentTest {
	public static void main(String[] args) {
		Student s=new Student(20,"西安");
		Student s2=new Student(21,"宝鸡");
		Student s3=new Student(22,"渭南");
		
		Student[] arry=new Student[3];
		arry[0]=new Student(20,"西安");
		arry[1]=new Student(21,"宝鸡");
		arry[2]=new Student(22,"渭南");
		System.out.println(Arrays.toString(arry));//数组arry[0]和arry[1]和arry[2]的地址
		
		Student[] arrys={new Student(20,"西安"),new Student(21,"宝鸡"),new Student(22,"渭南")};
		
		for(int i=0;i<arrys.length;i++){
			Student ss=arrys[i];
			System.out.println(ss.age);//获取每个对象的年龄
		}
		
		
	}
	
	
}
