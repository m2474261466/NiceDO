package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * ������д���ı��У���֮Ϊ����"���л�"
 * 
 * 
 * ʹ�ö����������ɶ���ġ������л���
 */
public class Objectinputstream {
	public static void main(String[] args) throws IOException, Exception {
		//�ļ�������
		FileInputStream fis=new FileInputStream("stu.txt");
		//����������
		ObjectInputStream ois=new  ObjectInputStream(fis);
		
		/**
		 * ObjectInputStream�ṩ��һ��������readObject()����һ��object����
		 */
		Student stu=(Student) ois.readObject();//�����object obj=ois.readObject();
		System.out.println(stu);
		ois.close();
	}
}
