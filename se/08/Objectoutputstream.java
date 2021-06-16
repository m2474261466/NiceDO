package day07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * 对象流：
 * 对象流是一种高级流，可以方便我们将java中的任何对象进行读写操作，
 * java.io.objectoutputstream
 * 对象输出流，可以将对象转换为一组字节写出
 * 
 * java.io.objectinputstream
 * 对象输入流，可以读取一组字节转换为原对象，还原为原对象的条件是
 * 读取这个字节应该是对象输出流将一个对象转换的字节
 */
public class Objectoutputstream {
	public static void main(String[] args) throws IOException {
		Student pdd=new Student();
		pdd.setName("潇参数");
		pdd.setAge(18);
		pdd.setGender('男');
		System.out.println(pdd.toString());
		
		//文件输出流
		FileOutputStream fos=new FileOutputStream("stu.txt");
		//对象输出流
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		/**
		 * ObjectOutputStream 提供了writeObject(object obj)；
		 * oos将对象转换为字节后 将这组字节交给fos写入文本等于写到硬盘，
		 * 这个过程称之为“数据持久化”；
		 * oos将给定的对象pdd转为一组字节，这个过程称之为“对象序列化”；
		 */
		oos.writeObject(pdd);
		System.out.println("写入完毕！！");
		oos.close();
	}
}
