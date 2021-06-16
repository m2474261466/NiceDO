package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * 将对象写入文本中，称之为对象"序列化"
 * 
 * 
 * 使用对象输出流完成对象的”反序列化“
 */
public class Objectinputstream {
	public static void main(String[] args) throws IOException, Exception {
		//文件输入流
		FileInputStream fis=new FileInputStream("stu.txt");
		//对象输入流
		ObjectInputStream ois=new  ObjectInputStream(fis);
		
		/**
		 * ObjectInputStream提供了一个方法是readObject()返回一个object对象
		 */
		Student stu=(Student) ois.readObject();//相等于object obj=ois.readObject();
		System.out.println(stu);
		ois.close();
	}
}
