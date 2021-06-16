package day07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 使用对象输入流完成对象的“反序列化”
 * 
 * @author 24742
 *
 */
public class ObjextInputStreamDemo {
      public static void main(String[] args) throws IOException, ClassNotFoundException {
    	  //文件输入流
		FileInputStream fis=new FileInputStream("stu.txt");
		ObjectInputStream oss=new ObjectInputStream(fis);
		/*
		 * objectInputStream提供了一个方法是readObject()返回一个Object对象
		 * 
		 */
		//反序列化
		Object stu=(Student)oss.readObject();
		System.out.println(stu);
		oss.close();
		
		
		
	}
}
