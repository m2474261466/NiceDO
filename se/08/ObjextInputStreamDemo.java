package day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * ʹ�ö�����������ɶ���ġ������л���
 * 
 * @author 24742
 *
 */
public class ObjextInputStreamDemo {
      public static void main(String[] args) throws IOException, ClassNotFoundException {
    	  //�ļ�������
		FileInputStream fis=new FileInputStream("stu.txt");
		ObjectInputStream oss=new ObjectInputStream(fis);
		/*
		 * objectInputStream�ṩ��һ��������readObject()����һ��Object����
		 * 
		 */
		//�����л�
		Object stu=(Student)oss.readObject();
		System.out.println(stu);
		oss.close();
		
		
		
	}
}
