package day02;

import java.util.Arrays;

public class StudentTest {
	public static void main(String[] args) {
		Student s=new Student(20,"����");
		Student s2=new Student(21,"����");
		Student s3=new Student(22,"μ��");
		
		Student[] arry=new Student[3];
		arry[0]=new Student(20,"����");
		arry[1]=new Student(21,"����");
		arry[2]=new Student(22,"μ��");
		System.out.println(Arrays.toString(arry));//����arry[0]��arry[1]��arry[2]�ĵ�ַ
		
		Student[] arrys={new Student(20,"����"),new Student(21,"����"),new Student(22,"μ��")};
		
		for(int i=0;i<arrys.length;i++){
			Student ss=arrys[i];
			System.out.println(ss.age);//��ȡÿ�����������
		}
		
		
	}
	
	
}
